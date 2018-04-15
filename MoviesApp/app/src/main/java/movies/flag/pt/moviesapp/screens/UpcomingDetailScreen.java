package movies.flag.pt.moviesapp.screens;

import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import movies.flag.pt.moviesapp.R;
import movies.flag.pt.moviesapp.http.entities.Upcoming;

/**
 * Created by franciscofarinha on 02/02/2018.
 */

public class UpcomingDetailScreen extends Screen {

    private TextView upcomingTitle;
    private ImageView upcomingPoster;
    private TextView upcomingOverview;
    private RatingBar upcomingRatingBar;
    private TextView upcomingRating;
    private ProgressBar upcomingLoader;
    private ImageView upcomingShareButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_screen);

        //CONNECTING THE VIEWS FROM THE LAYOUT

        upcomingTitle = findViewById(R.id.detail_screen_title);

        upcomingPoster = findViewById(R.id.detail_screen_poster);

        upcomingOverview = findViewById(R.id.detail_screen_overview);

        upcomingRatingBar = findViewById(R.id.detail_screen_rating_bar);

        upcomingRating = findViewById(R.id.detail_screen_rating);

        upcomingLoader = findViewById(R.id.detail_screen_loader);

        upcomingShareButton = findViewById(R.id.detail_screen_share_button);



        //RECEIVING THE ITEM

        Intent upcomingDetails = getIntent();
        Upcoming item = upcomingDetails.getParcelableExtra("UPCOMING_ITEM");





        upcomingTitle.setText(item.getTitle());



        if(item.getOverview().length() > 0) {

            upcomingOverview.setText(item.getOverview());
        } else {

            upcomingOverview.setText(R.string.no_description_available);
            upcomingOverview.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }




        double voteAverage = item.getVoteAverage();

        upcomingRating.setText(String.valueOf(voteAverage));

        upcomingRatingBar.setRating((float)voteAverage);

        upcomingRatingBar.setNumStars(10);


        String posterFinalPath = "https://image.tmdb.org/t/p/" + "w185" + item.getPosterPath();



        movies.flag.pt.moviesapp.http.requests.DownloadImageAsyncTask asyncTask = new movies.flag.pt.moviesapp.http.requests.DownloadImageAsyncTask(upcomingPoster, upcomingLoader);
        asyncTask.execute(posterFinalPath);





        final String shareMovieDetail =  getString(R.string.share_message_1) + " " + item.getTitle() + " " + getString(R.string.share_message_2) + " " + String.valueOf(voteAverage) + " " + getString(R.string.share_message_3);


        upcomingShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, shareMovieDetail);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);




            }
        });







    }

}
