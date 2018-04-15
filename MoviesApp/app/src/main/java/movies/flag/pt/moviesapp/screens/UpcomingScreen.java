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
import movies.flag.pt.moviesapp.adapters.UpcomingListAdapter;
import movies.flag.pt.moviesapp.functions.DateMessage;
import movies.flag.pt.moviesapp.http.entities.Upcoming;
import movies.flag.pt.moviesapp.http.entities.UpcomingResponse;
import movies.flag.pt.moviesapp.http.requests.GetUpcomingAsyncTask;
import movies.flag.pt.moviesapp.items.AdapterItem;
import movies.flag.pt.moviesapp.services.ServiceManager;
import movies.flag.pt.moviesapp.utils.DLog;

/**
 * Created by franciscofarinha on 02/02/2018.
 */

public class UpcomingScreen extends Screen {

    private ListView listView;
    private final static String LIST_KEY = "LIST_KEY";
    private ArrayList<AdapterItem> arrayList;
    private View footerView;
    private TextView footerText;
    private TextView textViewTime;
    private SwipeRefreshLayout swipeRefresh;
    private NetworkChangeReceiver receiver;
    private ArrayList<Upcoming> upcomingList;
    private UpcomingListAdapter adapter;
    private int page_value = 1;
    private String savedTime;
    private long upcomingScreenLongSavedTime;
    private ProgressBar progressBar;
    private ImageView listIcon;
    private TextView listMajorTitle;
    private ImageView backToMain;
    private ImageView wifiOffIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.list_screen);


        listIcon =  findViewById(R.id.list_screen_icon);
        listIcon.setImageResource(R.drawable.ic_upcoming);

        listMajorTitle = findViewById(R.id.list_screen_major_title);
        listMajorTitle.setText(R.string.upcoming);

        backToMain = findViewById(R.id.list_screen_back);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intentToMain = new Intent(UpcomingScreen.this, MainScreen.class);
                startActivity(intentToMain);



            }
        });

        SugarContext.init(this);



        listView = findViewById(R.id.list_view);
        progressBar = findViewById(R.id.list_screen_progress_bar);


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

                        Toast.makeText(UpcomingScreen.this, "so fresh", Toast.LENGTH_SHORT).show();
                    }
                }, 3000);
            }
        });

        LayoutInflater layoutInflater = LayoutInflater.from(UpcomingScreen.this);

        footerView = layoutInflater.inflate(R.layout.footer_view, listView, false);



        listView.addFooterView(footerView);





        textViewTime = findViewById(R.id.list_screen_textview_time);
        wifiOffIcon = findViewById(R.id.list_screen_no_net);



        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        if(isConnected) {

            //Toast.makeText(this,"está online!!!!",8000).show();

            executeRequest(1);
        } else {



            ArrayList<Upcoming> upcomingMovies = (ArrayList<Upcoming>) Upcoming.listAll(Upcoming.class);

            upcomingList = upcomingMovies;


            adapter = new UpcomingListAdapter(upcomingList, UpcomingScreen.this);
            listView.setAdapter(adapter);


            savedTime = PreferenceManager.getDefaultSharedPreferences(UpcomingScreen.this).getString("UPCOMING_SCREEN_SAVED_TIME", getString(R.string.no_internet));
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

                    Toast.makeText(UpcomingScreen.this, R.string.connect_wifi, Toast.LENGTH_LONG).show();
                }




            }
        });



        receiver = new UpcomingScreen.NetworkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, intentFilter);

    }  // onCreate ends here



    private void executeRequest(final int page_value) {
        // Example to request get now playing movies

        @SuppressLint("StaticFieldLeak") GetUpcomingAsyncTask asyncTask = new GetUpcomingAsyncTask(this, page_value)  {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressBar.setVisibility(View.VISIBLE);



            }

            @Override
            protected void onResponseSuccess(UpcomingResponse upcomingResponse) {



                Date currentTime = new Date(System.currentTimeMillis());
                upcomingScreenLongSavedTime = currentTime.getTime();

                final String upcomingScreenLoadingTime = DateMessage.DateMessage(upcomingScreenLongSavedTime, getString(R.string.loaded_on) , getString(R.string.loaded_at), getString(R.string.language_value));
                textViewTime.setText(upcomingScreenLoadingTime  );
                PreferenceManager.getDefaultSharedPreferences(UpcomingScreen.this).edit().putString("UPCOMING_SCREEN_SAVED_TIME", upcomingScreenLoadingTime).apply();




                DLog.d(tag, "onResponseSuccess " + upcomingResponse);
                // Here i can create the adapter :)


                if(upcomingList == null) {

                    upcomingList = upcomingResponse.getUpcoming();
                    adapter = new UpcomingListAdapter(upcomingList, UpcomingScreen.this);
                    listView.setAdapter(adapter);

                    SugarRecord.saveInTx(upcomingList);


                } else {

                    upcomingList.addAll(upcomingResponse.getUpcoming());

                    adapter.notifyDataSetChanged();

                    SugarRecord.saveInTx(upcomingList);

                }

                progressBar.setVisibility(View.GONE);
                wifiOffIcon.setVisibility(View.GONE);


            }

            @Override
            protected void onNetworkError() {
                DLog.d(tag, "onNetworkError ");
                // Here i now that some error occur when processing the request,
                // possible my internet connection is turned off
            }
        };
        asyncTask.execute();
    }



    public class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, final Intent intent) {



            if(checkInternet(context) && fiveMinutes(upcomingScreenLongSavedTime))
            {
                //Toast.makeText(context, "Net is on & 5 m have passed",Toast.LENGTH_LONG).show();
                //swipeRefresh.setRefreshing(true);
                executeRequest(page_value = 1);


            }

        }

        boolean fiveMinutes(long longSavedTime) {

            Date currentTime = new Date(System.currentTimeMillis());

            long newTime = currentTime.getTime();

            long difference = newTime - longSavedTime;

            if(difference >= 300000) {

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }


}
