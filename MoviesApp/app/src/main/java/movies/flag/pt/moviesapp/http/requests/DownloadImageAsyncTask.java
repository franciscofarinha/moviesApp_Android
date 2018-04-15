package movies.flag.pt.moviesapp.http.requests;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by franciscofarinha on 23/01/2018.
 */

public class DownloadImageAsyncTask extends AsyncTask<String, Void, Bitmap> {

    private final ImageView moviePoster;
    private final ProgressBar loader;

    public DownloadImageAsyncTask(ImageView moviePoster, ProgressBar loader) {
        this.moviePoster = moviePoster;
        this.loader = loader;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        loader.setVisibility(View.VISIBLE);
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String url = strings[0];
        return downloadImage(url);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            Bitmap bm = Bitmap.createScaledBitmap(bitmap, moviePoster.getWidth(), moviePoster.getHeight(), false);
            moviePoster.setImageBitmap(bm);

        }
        loader.setVisibility(View.GONE);
    }

    private Bitmap downloadImage(String url) {
        Bitmap bitmap = null;
        try {
            InputStream inputStream = new java.net.URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}