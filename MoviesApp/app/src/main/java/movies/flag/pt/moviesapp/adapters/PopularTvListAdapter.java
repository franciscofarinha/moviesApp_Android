package movies.flag.pt.moviesapp.adapters;

        import android.content.Intent;
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
        import movies.flag.pt.moviesapp.http.entities.PopularTv;
        import movies.flag.pt.moviesapp.screens.PopularTvDetailScreen;
        import movies.flag.pt.moviesapp.screens.PopularTvScreen;


/**
 * Created by franciscofarinha on 18/01/2018.
 */

public class PopularTvListAdapter extends BaseAdapter {

    private ArrayList<PopularTv> list;
    private PopularTvScreen context;


    public PopularTvListAdapter(ArrayList<PopularTv> list, PopularTvScreen context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public PopularTv getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if(convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.list_item_test, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.label = view.findViewById(R.id.list_item_label);
            viewHolder.itemWrap = view.findViewById(R.id.list_item_wrap);
            view.setTag(viewHolder);
            viewHolder.poster = view.findViewById(R.id.list_item_poster);
            viewHolder.loader = view.findViewById(R.id.list_item_screen_loader);
        }
        else{
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }

        final PopularTv item = getItem(position);

        final String checkedTitle = Ellipsis.ellipsize(item.getName(),30);


        viewHolder.label.setText( checkedTitle  );







        String posterFinalPath = "https://image.tmdb.org/t/p/" + "w185" + item.getBackdropPath();



        movies.flag.pt.moviesapp.http.requests.DownloadImageAsyncTask asyncTask = new movies.flag.pt.moviesapp.http.requests.DownloadImageAsyncTask(viewHolder.poster, viewHolder.loader);
        asyncTask.execute(posterFinalPath);




        viewHolder.itemWrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Toast.makeText(view.getContext() , Movie.getTitle() , Toast.LENGTH_LONG).show();
                  Intent intentToPopularTvDetailScreen = new Intent(context, PopularTvDetailScreen.class);

                  intentToPopularTvDetailScreen.putExtra("TV_SHOW_ITEM", item);

                   context.startActivity(intentToPopularTvDetailScreen);

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