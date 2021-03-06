package movies.flag.pt.moviesapp.services;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by franciscofarinha on 19/01/2018.
 */

public class ServiceManager {

    Context context;

    public ServiceManager(Context base) {
        context = base;
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
