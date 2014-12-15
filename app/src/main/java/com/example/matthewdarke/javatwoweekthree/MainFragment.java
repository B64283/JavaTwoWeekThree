package com.example.matthewdarke.javatwoweekthree;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by matthewdarke on 12/14/14.
 */
public class MainFragment extends ListFragment {

    View v;

    public MainFragment(){

    }


    //use save instance state with bundles

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        v = inflater.inflate(R.layout.main_fragment, container, false);


        return v;

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {


        super.onActivityCreated(savedInstanceState);

//Load cached Data from main activity
        if (getActivity() != null) {
            ((MainActivity)getActivity()).loadCacheData();
        }


    }

//set up onListItemClick





    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        MainActivity.deleteIndex = position;


        Cars carData = (Cars) l.getItemAtPosition(position);

        Bundle bundle = new Bundle();
        bundle.putString("mMake", carData.getmMake());
        bundle.putString("mRate", carData.getmRate());
        bundle.putString("mModel", carData.getmModel());

        Intent intent = new Intent(v.getContext(),SecondActivity.class);
        intent.putExtra("carData", ((MainActivity)getActivity()).carsArray);
        intent.putExtras(bundle);

        startActivity(intent);


    }









}
