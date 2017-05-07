package projext_x.quotegenerator;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Night extends AppCompatActivity {

    public Button button5;
    public TextView Test;

    private static final int NUM_BACKGROUNDS=4; // or whatever
    private Random mRandom = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night);

        Button button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                TextView tv = (TextView)Night.this.findViewById(R.id.Test);
                tv.setVisibility(View.VISIBLE);

                ArrayList<String> strings = new ArrayList<String>();

                strings.add("In the end, it's not the years in your life that count. It's the life in your years");
                strings.add("Life is not a problem to be solved, but a reality to be experienced.");
                strings.add("Believe that life is worth living and your belief will help create the fact.");
                strings.add("The only disability in life is a bad attitude.");
                strings.add("Only a life lived for others is a life worthwhile.");
                strings.add("In three words I can sum up everything I've learned about life: it goes on.");
                strings.add("Each person must live their life as a model for others.");
                Random r = new Random();

                String string = strings.get(r.nextInt(strings.size()));
                TextView text = (TextView) findViewById(R.id.Test);
                text.setText(string);

                View v = findViewById(R.id.life);
                int res;
                int i = mRandom.nextInt(NUM_BACKGROUNDS);
                switch (i) {
                    case 0: res = R.drawable.thinkercategorysecond; break;
                    case 1: res = R.drawable.thinkersecondphoto; break;
                    case 2: res = R.drawable.thinkerthirdphoto; break;
                    case 3: res = R.drawable.thinkerthird; break;


                    default: throw new IllegalArgumentException("oops?");
                }
                v.setBackgroundResource(res);
            }
        });
    }
}
