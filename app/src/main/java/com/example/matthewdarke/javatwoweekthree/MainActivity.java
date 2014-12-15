package com.example.matthewdarke.javatwoweekthree;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


////This is the LIST VIEW ///////////// LIST VIEW



public class MainActivity extends Activity {

    public static ArrayList<Cars> carsArray = new ArrayList<Cars>();
    public static ArrayAdapter<Cars> adapter;
    public static int deleteAtIndex;

    public static final int REQUEST_CODE = 2001;
    public static Cars mCarData;
    public static int deleteIndex;


    //Use save instance state with bundles
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// If no state bundle exists, this is the first launch.
        // Add your fragments just this one time.
        if (savedInstanceState == null) {

            MainFragment fragment = new MainFragment();
            getFragmentManager().beginTransaction()
                    .add(R.id.main_activity_id, fragment).commit();
        }


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        MainFragment mainFragment = (MainFragment) getFragmentManager()
                .findFragmentById(R.id.main_activity_id);///this is correct///////THIS IS CORRECT

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {

            ArrayList<Cars> first = (ArrayList<Cars>) data.getSerializableExtra("carData");

            if (carsArray != null) {
                cacheCarData();
                carsArray.addAll(first);

                adapter = new ArrayAdapter<Cars>(this, android.R.layout.simple_list_item_1, carsArray);

                mainFragment.setListAdapter(adapter);

            } else {
                cacheCarData();
                carsArray = first;

            }


        }

    }



    //save Data
    public void cacheCarData() {

        try {
            FileOutputStream outputStream = openFileOutput("carData", Context.MODE_PRIVATE);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            for (Cars aCarsArray : carsArray) {

                mCarData = aCarsArray;

                objectOutputStream.writeObject(mCarData);
            }

            objectOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }



//Load saved data

    public void loadCacheData() {

        MainFragment mainFragment = (MainFragment)
                getFragmentManager().findFragmentById(R.id.main_fragment_id);


        try{

            FileInputStream inputStream = openFileInput("carData");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            //needs while loop

            while (inputStream.available()!=0){

                //cast Cars data
                mCarData = (Cars) objectInputStream.readObject();
                carsArray.add(mCarData);
                //close input stream
            }

            //close input stream

            objectInputStream.close();

            adapter = new ArrayAdapter<Cars>(this, android.R.layout.simple_list_item_1, carsArray);

            mainFragment.setListAdapter(adapter);
        }catch (Exception e) {

            e.printStackTrace();
        }
    }










    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_Add_Car) {

            Intent addTo = new Intent(this,FirstActivity.class);
            startActivityForResult(addTo, REQUEST_CODE);


            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
