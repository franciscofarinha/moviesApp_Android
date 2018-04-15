package movies.flag.pt.moviesapp.screens;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

import movies.flag.pt.moviesapp.R;

/**
 * Created by Formando on 16/01/2018.
 */


public class OverviewScreen extends Screen {

    private final String PREFERENCES_NAME = "FIRST_LOGIN";
    private final String FIRST_LOGIN_KEY = "FIRST_LOGIN_KEY";

    private TextView welcomeMessageTextView;
    private TextView descriptionTextView;
    private Button confirmationButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview_screen);

        welcomeMessageTextView = findViewById(R.id.overview_screen_textview_welcome);
        descriptionTextView = findViewById(R.id.overview_screen_textview_description);
        confirmationButton = findViewById(R.id.overview_screen_button_confirm);

        welcomeMessageTextView.setText(R.string.welcome_message);
        descriptionTextView.setText(R.string.overview);

        confirmationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToMainScreen = new Intent(v.getContext(), MainScreen.class);
                startActivity(intentToMainScreen);
            }
        });


        SharedPreferences preferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();


        boolean isFirstLogin = preferences.getBoolean(FIRST_LOGIN_KEY, true);
        if (isFirstLogin) {
            editor.putBoolean(FIRST_LOGIN_KEY, false);
            editor.commit();
            //Toast.makeText(this, getString(R.string.first_login), Toast.LENGTH_LONG).show();

        } else {

            //Toast.makeText(this, "it's not the first login", Toast.LENGTH_LONG).show();

            Intent intentToMainScreen = new Intent(OverviewScreen.this, MainScreen.class);
            startActivity(intentToMainScreen);

        }






    }
}
