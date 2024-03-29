package com.example.project1_ctof;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.project1_ctof.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {
    double temperature = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //handles from content_main buttons/views
        final TextView display_temperature = findViewById(R.id.temperature);
        final TextView user_num = findViewById(R.id.user_num);

        FloatingActionButton fab = findViewById(R.id.fab);
        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //temperature = 107; //This works, need to set it to the value of user input now instead of a constant
                try{
                    temperature = Double.valueOf(user_num.getText().toString()); // This crashes the app if no number is input -- use try/catch block
                    temperature = temperature * 9/5 + 32;
                    //temperature.setText(Double.toString(temperature));
                    display_temperature.setText(Double.toString(temperature));
                    //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    //        .setAction("Action", null).show();
                }
                catch(Exception e){
                    display_temperature.setText("Error, enter only numbers for the temperature");
                }

            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //temperature = 107; //This works, need to set it to the value of user input now instead of a constant
                try{
                    temperature = Double.valueOf(user_num.getText().toString()); // This crashes the app if no number is input -- use try/catch block
                    temperature = (temperature-32) * 5/9;
                    //temperature.setText(Double.toString(temperature));
                    display_temperature.setText(Double.toString(temperature));
                    //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    //        .setAction("Action", null).show();
                }
                catch(Exception e){
                    display_temperature.setText("Error, enter only numbers for the temperature");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
