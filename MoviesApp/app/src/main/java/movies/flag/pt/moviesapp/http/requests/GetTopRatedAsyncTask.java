package movies.flag.pt.moviesapp.http.requests;

import android.content.Context;

import movies.flag.pt.moviesapp.R;
import movies.flag.pt.moviesapp.http.entities.PopularTvResponse;
import movies.flag.pt.moviesapp.http.entities.TopRatedResponse;

/**
 * Created by franciscofarinha on 25/01/2018.
 */

public abstract class GetTopRatedAsyncTask extends ExecuteRequestAsyncTask<TopRatedResponse> {

    private static final String PATH = "/movie/top_rated";
    private static final String LANGUAGE_KEY = "language";
    //private static final String LANGUAGE_VALUE = Locale.getDefault().getLanguage();
    private static final String PAGE_KEY = "page";
    private int pageValue;


    public GetTopRatedAsyncTask(Context context, int pageValue) {
        super(context);
        this.pageValue = pageValue;
        this.context = context;
    }


    @Override
    protected String getPath() {

        return PATH;
    }

    @Override
    protected void addQueryParams(StringBuilder sb) {
        addQueryParam(sb, LANGUAGE_KEY, context.getString(R.string.language_value));
        addQueryParam(sb, PAGE_KEY, String.valueOf(pageValue));

    }

    @Override
    protected Class<TopRatedResponse> getResponseEntityClass() {

        return TopRatedResponse.class;
    }
}
