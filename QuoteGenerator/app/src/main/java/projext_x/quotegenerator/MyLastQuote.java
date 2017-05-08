package projext_x.quotegenerator;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MyLastQuote extends AppCompatActivity {

    TextView here;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_last_quote);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String data = sharedPreferences.getString("Result", "") ;

        Calendar c= Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String currentDate= df.format(c.getTime());

        if ( data != null){
             if(!(data.equals(currentDate))){

                TextView here = (TextView) findViewById(R.id.here);
                here.setText(data);
                //get a random number
                //get String from the list
                //set the Textview value
             }
        }
    }

}
