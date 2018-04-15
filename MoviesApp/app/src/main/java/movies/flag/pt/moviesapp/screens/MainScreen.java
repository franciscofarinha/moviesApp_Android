package movies.flag.pt.moviesapp.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import movies.flag.pt.moviesapp.R;

/**
 * Created by franciscofarinha on 17/01/2018.
 */

public class MainScreen extends Screen {


    private TextView nowPlayingMoviesButton;
    private TextView popularTvButton;
    private TextView topRatedButton;
    private TextView upcomingButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);


        nowPlayingMoviesButton = findViewById(R.id.main_screen_now_playing_movies_textview);
        popularTvButton = findViewById(R.id.main_screen_popular_tv_textview);
        topRatedButton = findViewById(R.id.main_screen_top_rated_textview);
        upcomingButton = findViewById(R.id.main_screen_upcoming_textview);


        nowPlayingMoviesButton.setText(R.string.now_playing_short);
        popularTvButton.setText(R.string.popular_tv_short);
        topRatedButton.setText(R.string.top_rated);
        upcomingButton.setText(R.string.upcoming);

        nowPlayingMoviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentToNowPlayingMovies = new Intent(MainScreen.this, NowPlayingMoviesScreen.class);
                startActivity(intentToNowPlayingMovies);
            }
        });

        popularTvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentToPopularTv = new Intent(MainScreen.this, PopularTvScreen.class);
                startActivity(intentToPopularTv);
            }
        });

        topRatedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentToTopRated = new Intent(MainScreen.this, TopRatedScreen.class);
                startActivity(intentToTopRated);
            }
        });

        upcomingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentToUpcoming = new Intent(MainScreen.this, UpcomingScreen.class);
                startActivity(intentToUpcoming);
            }
        });
    }
}
