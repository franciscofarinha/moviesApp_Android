package movies.flag.pt.moviesapp.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import movies.flag.pt.moviesapp.R;
import movies.flag.pt.moviesapp.http.entities.Movie;

/**
 * Created by franciscofarinha on 18/01/2018.
 */

public class MovieDetailScreen extends Screen {

    private TextView topRatedTitle;
    private ImageView topRatedPoster;
    private TextView topRatedOverview;
    private RatingBar topRatedRatingBar;
    private TextView topRatedRating;
    private ProgressBar topRatedLoader;
    private ImageView topRatedShareButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_screen);

        //CONNECTING THE VIEWS FROM THE LAYOUT

        topRatedTitle = findViewById(R.id.detail_screen_title);

        topRatedPoster = findViewById(R.id.detail_screen_poster);

        topRatedOverview = findViewById(R.id.detail_screen_overview);

        topRatedRatingBar = findViewById(R.id.detail_screen_rating_bar);

        topRatedRating = findViewById(R.id.detail_screen_rating);

        topRatedLoader = findViewById(R.id.detail_screen_loader);

        topRatedShareButton = findViewById(R.id.detail_screen_share_button);



        //RECEIVING THE ITEM

        Intent movieDetails = getIntent();
        Movie item = movieDetails.getParcelableExtra("MOVIE_ITEM");





        topRatedTitle.setText(item.getTitle());



        if(item.getOverview().length() > 0) {

            topRatedOverview.setText(item.getOverview());
        } else {

            topRatedOverview.setText(R.string.no_description_available);
            topRatedOverview.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }




        double voteAverage = item.getVoteAverage();

        topRatedRating.setText(String.valueOf(voteAverage));

        topRatedRatingBar.setRating((float)voteAverage);

        topRatedRatingBar.setNumStars(10);




        String posterFinalPath = "https://image.tmdb.org/t/p/" + "w185" + item.getPosterPath();



        movies.flag.pt.moviesapp.http.requests.DownloadImageAsyncTask asyncTask = new movies.flag.pt.moviesapp.http.requests.DownloadImageAsyncTask(topRatedPoster, topRatedLoader);
        asyncTask.execute(posterFinalPath);




        final String shareMovieDetail =  getString(R.string.share_message_1) + " " + item.getTitle() + " " + getString(R.string.share_message_2) + " " + String.valueOf(voteAverage) + " " + getString(R.string.share_message_3);


        topRatedShareButton.setOnClickListener(new View.OnClickListener() {
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
