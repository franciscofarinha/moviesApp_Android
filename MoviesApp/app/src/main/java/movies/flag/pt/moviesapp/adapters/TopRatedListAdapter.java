package movies.flag.pt.moviesapp.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import movies.flag.pt.moviesapp.R;
import movies.flag.pt.moviesapp.functions.Ellipsis;
import movies.flag.pt.moviesapp.http.entities.TopRated;
import movies.flag.pt.moviesapp.screens.TopRatedDetailScreen;
import movies.flag.pt.moviesapp.screens.TopRatedScreen;

/**
 * Created by franciscofarinha on 01/02/2018.
 */

public class TopRatedListAdapter extends BaseAdapter {

    private ArrayList<TopRated> list;
    private TopRatedScreen context;




    public TopRatedListAdapter(ArrayList<TopRated> list, TopRatedScreen context) {
        this.list = list;
        this.context = context;
    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public TopRated getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        TopRatedListAdapter.ViewHolder viewHolder;
        if(convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.list_item_alt, parent, false);
            viewHolder = new TopRatedListAdapter.ViewHolder();
            viewHolder.label = view.findViewById(R.id.list_item_label);
            viewHolder.itemWrap = view.findViewById(R.id.list_item_wrap);
            view.setTag(viewHolder);
            viewHolder.poster = view.findViewById(R.id.list_item_poster);
            viewHolder.loader = view.findViewById(R.id.list_item_screen_loader);
            viewHolder.rating = view.findViewById(R.id.list_item_bottom_label);

        }
        else{
            view = convertView;
            viewHolder = (TopRatedListAdapter.ViewHolder)view.getTag();
        }

        final TopRated item = getItem(position);


        final String checkedTitle = Ellipsis.ellipsize(item.getTitle(),30);


        viewHolder.label.setText( checkedTitle  );

        double voteAverage = item.getVoteAverage();

        viewHolder.rating.setText( String.valueOf(voteAverage) + "★");







        String posterFinalPath = "https://image.tmdb.org/t/p/" + "w185" + item.getBackdropPath();



        movies.flag.pt.moviesapp.http.requests.DownloadImageAsyncTask asyncTask = new movies.flag.pt.moviesapp.http.requests.DownloadImageAsyncTask(viewHolder.poster, viewHolder.loader);
        asyncTask.execute(posterFinalPath);





        viewHolder.itemWrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Toast.makeText(view.getContext() , Movie.getTitle() , Toast.LENGTH_LONG).show();
                Intent intentToTopRatedDetailSreen = new Intent(context, TopRatedDetailScreen.class);

                intentToTopRatedDetailSreen.putExtra("TOP_RATED_ITEM", item);

                context.startActivity(intentToTopRatedDetailSreen);

            }
        });




        return view;
    }

    private class ViewHolder{
        TextView label;
        ImageView poster;
        ProgressBar loader;
        TextView rating;
        LinearLayout itemWrap;

    }


}
