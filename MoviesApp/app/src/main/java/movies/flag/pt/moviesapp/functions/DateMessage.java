package movies.flag.pt.moviesapp.functions;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import movies.flag.pt.moviesapp.R;
import movies.flag.pt.moviesapp.screens.NowPlayingMoviesScreen;

import static android.provider.Settings.Global.getString;

/**
 * Created by franciscofarinha on 05/02/2018.
 */

public class DateMessage {



    public String finalFormattedDate;


    public static String DateMessage(Long longSavedTime, String loadedOn, String loadedAt, String language) {


        if(language.equals("en")){

            SimpleDateFormat justDate = new SimpleDateFormat("yyyy-dd-MM");
            SimpleDateFormat justHours = new SimpleDateFormat("hh:mm:ss");
            String formattedDate = justDate.format(longSavedTime);
            String formattedHours = justHours.format(longSavedTime);


            String finalFormatedDate = String.format("%s %s %s %s", loadedOn, formattedDate, loadedAt, formattedHours);

            return finalFormatedDate;

        } else {

            SimpleDateFormat justDate = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat justHours = new SimpleDateFormat("hh:mm:ss");
            String formattedDate = justDate.format(longSavedTime);
            String formattedHours = justHours.format(longSavedTime);


            String finalFormatedDate = String.format("%s %s %s %s", loadedOn, formattedDate, loadedAt, formattedHours);

            return finalFormatedDate;
        }





    }







}
