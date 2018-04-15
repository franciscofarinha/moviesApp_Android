package movies.flag.pt.moviesapp.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import movies.flag.pt.moviesapp.R;
import movies.flag.pt.moviesapp.http.entities.PopularTv;

/**
 * Created by franciscofarinha on 19/01/2018.
 */

public class PopularTvDetailScreen extends Screen {

    private TextView tvShowName;
    private ImageView tvShowPoster;
    private TextView tvShowOverview;
    private RatingBar tvShowRatingBar;
    private TextView tvShowRating;
    private ProgressBar tvShowLoader;
    private ImageView tvShowshareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_screen);

        //CONNECTING THE VIEWS FROM THE LAYOUT

        tvShowName = findViewById(R.id.detail_screen_title);

        tvShowPoster = findViewById(R.id.detail_screen_poster);

        tvShowOverview = findViewById(R.id.detail_screen_overview);

        tvShowRatingBar = findViewById(R.id.detail_screen_rating_bar);

        tvShowRating = findViewById(R.id.detail_screen_rating);

        tvShowLoader = findViewById(R.id.detail_screen_loader);

        tvShowshareButton = findViewById(R.id.detail_screen_share_button);



        //RECEIVING THE ITEM

        Intent tvShowDetails = getIntent();
        PopularTv item = tvShowDetails.getParcelableExtra("TV_SHOW_ITEM");





        tvShowName.setText(item.getName());



        if(item.getOverview().length() > 0) {

            tvShowOverview.setText(item.getOverview());
        } else {

            tvShowOverview.setText(R.string.no_description_available);
            tvShowOverview.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }




        double voteAverage = item.getVoteAverage();

        tvShowRating.setText(String.valueOf(voteAverage));

        tvShowRatingBar.setRating((float)voteAverage);

        tvShowRatingBar.setNumStars(10);




        String posterFinalPath = "https://image.tmdb.org/t/p/" + "w185" + item.getPosterPath();



        movies.flag.pt.moviesapp.http.requests.DownloadImageAsyncTask asyncTask = new movies.flag.pt.moviesapp.http.requests.DownloadImageAsyncTask(tvShowPoster, tvShowLoader);
        asyncTask.execute(posterFinalPath);





        final String shareMovieDetail =  getString(R.string.share_message_1) + " " + item.getName() + " " + getString(R.string.share_message_2) + " " + String.valueOf(voteAverage) + " " + getString(R.string.share_message_3);


        tvShowshareButton.setOnClickListener(new View.OnClickListener() {
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
