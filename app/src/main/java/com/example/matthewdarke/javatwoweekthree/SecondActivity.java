package com.example.matthewdarke.javatwoweekthree;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

/**
 * Created by matthewdarke on 12/14/14.
 */
///////THIS IS THE DETAIL VIEW ///////////////// DETAIL VIEW

public class SecondActivity extends Activity {

    //public static ArrayList<Cars> carsArray = new ArrayList<Cars>();

    //public boolean carsArray;

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // If no state bundle exists, this is the first launch.
        // Add your fragments just this one time.

        if (savedInstanceState == null){

            SecondFragment secondFrag = new SecondFragment();

            getFragmentManager()
                    .beginTransaction().add(R.id.second_activity_id, secondFrag)
                    .commit();


        }

//creates/Nav bar
        //noinspection ConstantConditions
        getActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId()== android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}



