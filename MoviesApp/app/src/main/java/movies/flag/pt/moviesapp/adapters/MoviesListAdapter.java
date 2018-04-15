package movies.flag.pt.moviesapp.adapters;

import android.content.Intent;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import movies.flag.pt.moviesapp.R;
import movies.flag.pt.moviesapp.functions.Ellipsis;
import movies.flag.pt.moviesapp.http.entities.Movie;
import movies.flag.pt.moviesapp.screens.MovieDetailScreen;
import movies.flag.pt.moviesapp.screens.NowPlayingMoviesScreen;


/**
 * Created by franciscofarinha on 18/01/2018.
 */

public class MoviesListAdapter extends BaseAdapter {



    private ArrayList<Movie> list;
    private NowPlayingMoviesScreen context;




    public MoviesListAdapter(ArrayList<Movie> list, NowPlayingMoviesScreen context) {
        this.list = list;
        this.context = context;
    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Movie getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        MoviesListAdapter.ViewHolder viewHolder;
        if(convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.list_item_test, parent, false);
            viewHolder = new MoviesListAdapter.ViewHolder();
            viewHolder.label = view.findViewById(R.id.list_item_label);
            view.setTag(viewHolder);
            viewHolder.itemWrap = view.findViewById(R.id.list_item_wrap);
            viewHolder.poster = view.findViewById(R.id.list_item_poster);
            viewHolder.loader = view.findViewById(R.id.list_item_screen_loader);
        }
        else{
            view = convertView;
            viewHolder = (MoviesListAdapter.ViewHolder)view.getTag();
        }

        final Movie item = getItem(position);



        final String checkedTitle = Ellipsis.ellipsize(item.getTitle(),30);


        viewHolder.label.setText( checkedTitle  );







        String posterFinalPath = "https://image.tmdb.org/t/p/" + "w185" + item.getBackdropPath();



        movies.flag.pt.moviesapp.http.requests.DownloadImageAsyncTask asyncTask = new movies.flag.pt.moviesapp.http.requests.DownloadImageAsyncTask(viewHolder.poster, viewHolder.loader);
        asyncTask.execute(posterFinalPath);



        viewHolder.itemWrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intentToMovieDetailScreen = new Intent(context, MovieDetailScreen.class);

                intentToMovieDetailScreen.putExtra("MOVIE_ITEM", item);

                context.startActivity(intentToMovieDetailScreen);

            }
        });




        return view;
    }

    private class ViewHolder{
        TextView label;
        ImageView poster;
        ProgressBar loader;
        LinearLayout itemWrap;
    }






}
