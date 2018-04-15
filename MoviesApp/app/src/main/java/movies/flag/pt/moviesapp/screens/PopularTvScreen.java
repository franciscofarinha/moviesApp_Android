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
import movies.flag.pt.moviesapp.adapters.PopularTvListAdapter;
import movies.flag.pt.moviesapp.functions.DateMessage;
import movies.flag.pt.moviesapp.http.entities.PopularTv;
import movies.flag.pt.moviesapp.http.entities.PopularTvResponse;
import movies.flag.pt.moviesapp.http.requests.GetPopularTvAsyncTask;
import movies.flag.pt.moviesapp.items.AdapterItem;
import movies.flag.pt.moviesapp.services.ServiceManager;
import movies.flag.pt.moviesapp.utils.DLog;

/**
 * Created by franciscofarinha on 17/01/2018.
 */

public class PopularTvScreen extends Screen {


    private ListView listView;
    private final static String LIST_KEY = "LIST_KEY";
    private ArrayList<AdapterItem> arrayList;
    private View footerView;
    private TextView textViewTime;
    private NetworkChangeReceiver receiver;
    private ArrayList<PopularTv> tvList;
    private PopularTvListAdapter adapter;
    private int page_value = 1;
    private String savedTime;
    private long popularTvLongSavedTime;
    private ProgressBar progressBar;
    private ImageView listIcon;
    private TextView listMajorTitle;
    private ImageView backToMain;
    private ImageView wifiOffIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_screen);


        SugarContext.init(this);

        listIcon =  findViewById(R.id.list_screen_icon);
        listIcon.setImageResource(R.drawable.ic_tv);

        listMajorTitle = findViewById(R.id.list_screen_major_title);
        listMajorTitle.setText(R.string.popular_tv);

        backToMain = findViewById(R.id.list_screen_back);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intentToMain = new Intent(PopularTvScreen.this, MainScreen.class);
                startActivity(intentToMain);



            }
        });

        listView = findViewById(R.id.list_view);
        progressBar = findViewById(R.id.list_screen_progress_bar);

        textViewTime = findViewById(R.id.list_screen_textview_time);
        wifiOffIcon = findViewById(R.id.list_screen_no_net);



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

                        Toast.makeText(PopularTvScreen.this, "so fresh", Toast.LENGTH_SHORT).show();
                    }
                }, 3000);
            }
        });

        LayoutInflater layoutInflater = LayoutInflater.from(PopularTvScreen.this);
        footerView = layoutInflater.inflate(R.layout.footer_view, listView, false);
        listView.addFooterView(footerView);





        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        if(isConnected) {

            //Toast.makeText(this,"está online!!!!",8000).show();

            executeRequest(1);
        } else {



            ArrayList<PopularTv> popularTv = (ArrayList<PopularTv>) PopularTv.listAll(PopularTv.class);

            tvList = popularTv;


            adapter = new PopularTvListAdapter(tvList, PopularTvScreen.this);
            listView.setAdapter(adapter);

            savedTime = PreferenceManager.getDefaultSharedPreferences(PopularTvScreen.this).getString("POPULAR_TV_SCREEN_SAVED_TIME", getString(R.string.no_internet));

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

                    Toast.makeText(PopularTvScreen.this, R.string.connect_wifi, Toast.LENGTH_LONG).show();
                }


            }
        });

        receiver = new PopularTvScreen.NetworkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, intentFilter);

    }  // onCreate ends here



    private void executeRequest(final int page_value) {
        // Example to request get now playing movies

        @SuppressLint("StaticFieldLeak") GetPopularTvAsyncTask asyncTask = new GetPopularTvAsyncTask(this, page_value)  {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressBar.setVisibility(View.VISIBLE);



            }


            @Override
            protected void onResponseSuccess(PopularTvResponse popularTvResponse) {


               /* Date currentTime = new Date(System.currentTimeMillis());
                String StringTime = (currentTime).toString();

                longSavedTime = currentTime.getTime();

                textViewTime.setText( DateFormat.getTimeInstance().format(new Date(StringTime))   );


                savedTime = textViewTime.getText().toString();*/

                Date currentTime = new Date(System.currentTimeMillis());
                popularTvLongSavedTime = currentTime.getTime();

                final String popularTvLoadingTime = DateMessage.DateMessage(popularTvLongSavedTime, getString(R.string.loaded_on) , getString(R.string.loaded_at), getString(R.string.language_value));
                textViewTime.setText(popularTvLoadingTime  );
                PreferenceManager.getDefaultSharedPreferences(PopularTvScreen.this).edit().putString("POPULAR_TV_SCREEN_SAVED_TIME", popularTvLoadingTime).apply();




                DLog.d(tag, "onResponseSuccess " + popularTvResponse);
                // Here i can create the adapter :)


                if(tvList == null) {

                    tvList = popularTvResponse.getPopularTv();
                    adapter = new PopularTvListAdapter(tvList, PopularTvScreen.this);
                    listView.setAdapter(adapter);

                    SugarRecord.saveInTx(tvList);
                   // PreferenceManager.getDefaultSharedPreferences(PopularTvScreen.this).edit().putString("POPULAR_TV_SCREEN_SAVED_TIME", savedTime).apply();
                    //PreferenceManager.getDefaultSharedPreferences(PopularTvScreen.this).edit().putLong("POPULAR_TV_SCREEN_LONG_SAVED_TIME", longSavedTime).apply();

                } else {

                    tvList.addAll(popularTvResponse.getPopularTv());
                    //listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                    SugarRecord.saveInTx(tvList);
                   // PreferenceManager.getDefaultSharedPreferences(PopularTvScreen.this).edit().putString("POPULAR_TV_SCREEN_SAVED_TIME", savedTime).apply();
                   // PreferenceManager.getDefaultSharedPreferences(PopularTvScreen.this).edit().putLong("POPULAR_TV_SCREEN_LONG_SAVED_TIME", longSavedTime).apply();

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



            if(checkInternet(context) && fiveMinutes(popularTvLongSavedTime))
            {
                //Toast.makeText(context, "Net - On & 5 m have passed",Toast.LENGTH_LONG).show();
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
