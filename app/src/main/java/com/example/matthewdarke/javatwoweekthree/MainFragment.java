package com.example.matthewdarke.javatwoweekthree;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by matthewdarke on 12/14/14.
 */



public class MainFragment extends ListFragment {
    Button bnImpli;

    View v;

    public MainFragment(){

    }


    //use save instance state with bundles

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        v = inflater.inflate(R.layout.main_fragment, container, false);
        bnImpli = (Button) v.findViewById(R.id.b3);

        return v;

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {


        super.onActivityCreated(savedInstanceState);

//Load cached Data from main activity
        if (getActivity() != null) {
            ((MainActivity)getActivity()).loadCacheData();
        }
        bnImpli.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // TDOD Auto-generated method stub

                Intent implicit = new Intent(Intent.ACTION_SEND);
                implicit.setType("text/plain");
                startActivity(implicit);

            }
        });

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

        Intent pdIntent = new Intent(v.getContext(),SecondActivity.class);
        pdIntent.putExtra("carsArray", ((MainActivity)getActivity()).carsArray);
        pdIntent.putExtras(bundle);

        startActivity(pdIntent);


    }









}
