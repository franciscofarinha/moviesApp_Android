package movies.flag.pt.moviesapp.http.requests;

import android.content.Context;
import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import movies.flag.pt.moviesapp.R;
import movies.flag.pt.moviesapp.http.entities.UpcomingResponse;

/**
 * Created by franciscofarinha on 02/02/2018.
 */

public abstract class GetUpcomingAsyncTask extends ExecuteRequestAsyncTask<UpcomingResponse> {

    private static final String PATH = "/movie/upcoming";
    private static final String LANGUAGE_KEY = "language";
    //private static final String LANGUAGE_VALUE = Locale.getDefault().getLanguage();
    private static final String PAGE_KEY = "page";
    private static final String REGION_KEY = "region";
    private static final String RELEASE_DATE_KEY = "primary_release_date.gte";
    private int pageValue;


    public GetUpcomingAsyncTask(Context context, int pageValue) {
        super(context);
        this.pageValue = pageValue;
        this.context = context;
    }

    Calendar c = Calendar.getInstance();

    SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
    String formattedDate = df.format(c.getTime());



    @Override
    protected String getPath() {

        return PATH;
    }

    @Override
    protected void addQueryParams(StringBuilder sb) {
        addQueryParam(sb, LANGUAGE_KEY, context.getString(R.string.language_value));
        addQueryParam(sb, REGION_KEY, context.getString(R.string.region));
        addQueryParam(sb, PAGE_KEY, String.valueOf(pageValue));
        addQueryParam(sb, RELEASE_DATE_KEY, formattedDate);

    }

    @Override
    protected Class<UpcomingResponse> getResponseEntityClass() {

        return UpcomingResponse.class;
    }
}