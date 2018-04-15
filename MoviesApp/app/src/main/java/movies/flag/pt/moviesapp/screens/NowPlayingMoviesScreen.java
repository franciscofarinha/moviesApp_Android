package movies.flag.pt.moviesapp.screens;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.Date;

import movies.flag.pt.moviesapp.R;
import movies.flag.pt.moviesapp.adapters.MoviesListAdapter;
import movies.flag.pt.moviesapp.functions.DateMessage;
import movies.flag.pt.moviesapp.http.entities.Movie;
import movies.flag.pt.moviesapp.http.entities.MoviesResponse;
import movies.flag.pt.moviesapp.http.requests.GetNowPlayingMoviesAsyncTask;
import movies.flag.pt.moviesapp.items.AdapterItem;
import movies.flag.pt.moviesapp.services.ServiceManager;
import movies.flag.pt.moviesapp.utils.DLog;


/**
 * Created by franciscofarinha on 17/01/2018.
 */

public class NowPlayingMoviesScreen extends Screen {

    private ListView listView;
    private final static String LIST_KEY = "LIST_KEY";
    private ArrayList<AdapterItem> arrayList;
    private View footerView;
    private TextView textViewTime;
    private NetworkChangeReceiver receiver;
    private ArrayList<Movie> movieList;
    private MoviesListAdapter adapter;
    private int page_value = 1;
    private String savedTime;
    private long nowPlayingMoviesLongSavedTime;
    private ProgressBar progressBar;
    private ImageView listIcon;
    private TextView listMajorTitle;
    private ImageView backToMain;
    private ImageView wifiOffIcon;




    @SuppressLint({"WrongConstant", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_screen);
        SugarContext.init(this);


        listIcon =  findViewById(R.id.list_screen_icon);
        listIcon.setImageResource(R.drawable.ic_now_playing);

        listMajorTitle = findViewById(R.id.list_screen_major_title);
        listMajorTitle.setText(R.string.now_playing);

        textViewTime = findViewById(R.id.list_screen_textview_time);
        progressBar = findViewById(R.id.list_screen_progress_bar);
        wifiOffIcon = findViewById(R.id.list_screen_no_net);

        backToMain = findViewById(R.id.list_screen_back);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intentToMain = new Intent(NowPlayingMoviesScreen.this, MainScreen.class);
                startActivity(intentToMain);
             }
        });

         listView = findViewById(R.id.list_view);
        progressBar = findViewById(R.id.list_screen_progress_bar);

        LayoutInflater layoutInflater = LayoutInflater.from(NowPlayingMoviesScreen.this);
        footerView = layoutInflater.inflate(R.layout.footer_view, listView, false);
        listView.addFooterView(footerView);



        final SwipeRefreshLayout swipeRefresh = findViewById(R.id.list_screen_swipe_refresh);

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefresh.setRefreshing(true);
                //Log.d("Swipe", "Refreshing Number");
                ( new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefresh.setRefreshing(false);

                        executeRequest(1);

                        //Toast.makeText(NowPlayingMoviesScreen.this, "refreshing", Toast.LENGTH_SHORT).show();
                    }
                }, 3000);
            }
        });



        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();



        final boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        if(isConnected) {

            //Toast.makeText(this, "online!", 8000).show();

            executeRequest(1);


        } else {


            ArrayList<Movie> movies = (ArrayList<Movie>) Movie.listAll(Movie.class);

            movieList = movies;

            adapter = new MoviesListAdapter(movieList, NowPlayingMoviesScreen.this);
            listView.setAdapter(adapter);

            savedTime = PreferenceManager.getDefaultSharedPreferences(NowPlayingMoviesScreen.this).getString("NOW_PLAYING_SCREEN_SAVED_TIME", getString(R.string.no_internet));
            textViewTime.setText(savedTime  );

             progressBar.setVisibility(View.GONE);
            wifiOffIcon.setVisibility(View.VISIBLE);






        }

        footerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo footerActiveNetwork = cm.getActiveNetworkInfo();


                final boolean ableToLoad = footerActiveNetwork != null && footerActiveNetwork.isConnectedOrConnecting();


                if(ableToLoad){

                    executeRequest(page_value = page_value +1);
                } else {

                    Toast.makeText(NowPlayingMoviesScreen.this, R.string.connect_wifi, Toast.LENGTH_LONG).show();
                }




            }
        });



        receiver = new NetworkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, intentFilter);

    } // onCreate ends here







    private void executeRequest(final int page_value) {
        // Example to request get now playing movies
        @SuppressLint("StaticFieldLeak") GetNowPlayingMoviesAsyncTask asyncTask = new GetNowPlayingMoviesAsyncTask(this, page_value)  {


            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressBar.setVisibility(View.VISIBLE);



            }


            @Override
            protected void onResponseSuccess(MoviesResponse moviesResponse) {



                Date currentTime = new Date(System.currentTimeMillis());
                nowPlayingMoviesLongSavedTime = currentTime.getTime();

                final String nowPlayingMoviesLoadingTime = DateMessage.DateMessage(nowPlayingMoviesLongSavedTime, getString(R.string.loaded_on) , getString(R.string.loaded_at), getString(R.string.language_value));
                textViewTime.setText(nowPlayingMoviesLoadingTime  );
                PreferenceManager.getDefaultSharedPreferences(NowPlayingMoviesScreen.this).edit().putString("NOW_PLAYING_SCREEN_SAVED_TIME", nowPlayingMoviesLoadingTime).apply();



                DLog.d(tag, "onResponseSuccess " + moviesResponse);


                if(movieList == null) {



                    movieList = moviesResponse.getMovies();
                    adapter = new MoviesListAdapter(movieList, NowPlayingMoviesScreen.this);
                    listView.setAdapter(adapter);

                    SugarRecord.saveInTx(movieList);


                } else {

                    movieList.addAll(moviesResponse.getMovies());
                    adapter.notifyDataSetChanged();

                    SugarRecord.saveInTx(movieList);

                }




                progressBar.setVisibility(View.GONE);
                wifiOffIcon.setVisibility(View.GONE);



            }



            @Override
            protected void onNetworkError() {
                DLog.d(tag, "onNetworkError ");
                // Here i now that some error occur when processing the request,
                // possible my internet connection is turned off

                //List<Book> books = Book.find(Book.class);

                progressBar.setVisibility(View.GONE);




            }
        };
        asyncTask.execute();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);

        Parcelable state = listView.onSaveInstanceState();

        listView.onRestoreInstanceState(state);

    }




    public class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, final Intent intent) {



            if(checkInternet(context) && fiveMinutes(nowPlayingMoviesLongSavedTime))
            {
                //Toast.makeText(context, "Net is on & 5 m have passed",Toast.LENGTH_LONG).show();
                executeRequest(page_value = 1);



            }

        }

        boolean fiveMinutes(long longSavedTime) {

            Date currentTime = new Date(System.currentTimeMillis());

            long newTime = currentTime.getTime();

            long difference = newTime - longSavedTime;

            if(difference >= 20000) {

                return true;
            }

            return false;





        }

        boolean checkInternet(Context context) {
            ServiceManager serviceManager = new ServiceManager(context);
            if (serviceManager.isNetworkAvailable()) {
                return true;
            } else {
                return false;
            }
        }
    }
}
