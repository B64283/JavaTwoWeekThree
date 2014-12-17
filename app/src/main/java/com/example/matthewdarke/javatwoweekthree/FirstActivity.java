package com.example.matthewdarke.javatwoweekthree;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

/**
 * Created by matthewdarke on 12/14/14.
 */
////ADD VIEW SCREEN ///////////////// ADD VIEW ///////////////////


public class FirstActivity extends Activity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        if (savedInstanceState == null){
            FirstFragment f1 = new FirstFragment();
            getFragmentManager()
                    .beginTransaction()


                    .add(R.id.first_activity_id, f1)
                    .commit();


        }
        //actionBar for navagation back to main


        //noinspection ConstantConditions
        getActionBar().setDisplayHomeAsUpEnabled(true);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


}