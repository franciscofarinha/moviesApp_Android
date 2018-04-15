package movies.flag.pt.moviesapp.http.requests;

import android.content.Context;

import java.util.Locale;

import movies.flag.pt.moviesapp.R;
import movies.flag.pt.moviesapp.http.entities.PopularTvResponse;

import static android.provider.BaseColumns._ID;
import static android.provider.Settings.Global.getString;

/**
 * Created by franciscofarinha on 19/01/2018.
 */

public abstract class GetPopularTvAsyncTask extends ExecuteRequestAsyncTask<PopularTvResponse> {

    private static final String PATH = "/tv/popular";
    private static final String LANGUAGE_KEY = "language";
 //private static final String LANGUAGE_VALUE = Locale.getDefault().getLanguage();
    private static final String PAGE_KEY = "page";
    private int pageValue;


    public GetPopularTvAsyncTask(Context context, int pageValue) {
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
    protected Class<PopularTvResponse> getResponseEntityClass() {

        return PopularTvResponse.class;
    }
}
