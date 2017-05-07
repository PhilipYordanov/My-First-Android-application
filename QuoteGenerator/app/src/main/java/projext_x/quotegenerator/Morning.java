package projext_x.quotegenerator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Morning extends AppCompatActivity {

    public Button button4;
    public TextView Quote;
    String temp;

    private static final int NUM_BACKGROUNDS=4; // or whatever
    private Random mRandom = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning);

        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                TextView tv = (TextView) Morning.this.findViewById(R.id.Quote);
                tv.setVisibility(View.VISIBLE);

                ArrayList<String> strings = new ArrayList<String>();

                strings.add("Traveling – it leaves you speechless, then turns you into a storyteller.");
                strings.add("No place is ever as bad as they tell you it’s going to be.");
                strings.add("I am not the same, having seen the moon shine on the other side of the world.");
                strings.add("Man cannot discover new oceans unless he has the courage to lose sight of the shore.");
                strings.add("The world is a book, and those who do not travel read only one page.");
                strings.add("Travel and change of place impart new vigor to the mind.");
                strings.add("Travel is the only thing you buy that makes you richer.");
                Random r = new Random();

                String string = strings.get(r.nextInt(strings.size()));
                TextView text = (TextView) findViewById(R.id.Quote);
                //Temp  е равен на последния рандом стринг .....
                temp = string;
                text.setText(string);

                View v = findViewById(R.id.travelCategory);
                int res;
                int i = mRandom.nextInt(NUM_BACKGROUNDS);
                switch (i) {
                    case 0: res = R.drawable.travelcategorysixt; break;
                    case 1: res = R.drawable.trarvelcategoryfifth; break;
                    case 2:res = R.drawable.travelcategoryforth;break;
                    case 3: res = R.drawable.travelcategoryfirst;break;

                    default: throw new IllegalArgumentException("oops?");
                }
                v.setBackgroundResource(res);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

      @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.info:
                //Intent launchNewIntent = new Intent(Morning.this,MyLastQuote.class);
                //startActivityForResult(launchNewIntent,0);
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Result",temp );
                editor.commit();
                Intent sd=new Intent(this,MyLastQuote.class);
                startActivity(sd);
          return true;
        default:
          return super.onOptionsItemSelected(item);
       }
    }
   // public void saveInfo(View view){
        // SharedPreferences sharedPref = getSharedPreferences("LastQuote", Context.MODE_PRIVATE);
        // SharedPreferences.Editor editor = sharedPref.edit();
        // editor.putString("lastQuote", "This is the sign");
        //editor.apply();
    //}
}
