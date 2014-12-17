package com.example.matthewdarke.javatwoweekthree;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by matthewdarke on 12/14/14.
 */
///// THIS IS THE DETAIL VIEW ////////////// DETAIL VIEW /////////////////



public class SecondFragment extends Fragment {

    public ArrayList<Cars> mCarsArrayList = new ArrayList<Cars>();
    public String mCar;
    private TextView mCarMake;
    private TextView mCarModel;
    private TextView mCarRate;
    Button bnImpli;
    Button bnDelete;
    //ActionBar actionBar;
    //private int contentView;



    public SecondFragment() {


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view;
        view = inflater.inflate(R.layout.second_fragment, container, false);

        bnImpli = (Button) view.findViewById(R.id.b3);
        bnDelete = (Button) view.findViewById(R.id.bnDelete);

        mCarMake = (TextView) view.findViewById(R.id.textView_Make);
        mCarModel = (TextView) view.findViewById(R.id.textView_model);
        mCarRate = (TextView) view.findViewById(R.id.textView_rate);



        Intent intent = getActivity().getIntent();

        //noinspection unchecked
        mCarsArrayList = (ArrayList<Cars>) intent.getSerializableExtra("carsArray");

        Bundle data = intent.getExtras();


        if (data != null) {
///get key value

            //String firstMake = data.getString("mMake");

            String firstMake = data.getString("mMake");
            mCar = data.get("mMake").toString();

            String firstModel = data.getString("mModel");
            String firstRate = data.getString("mRate");

            mCarMake.setText(firstMake);
            mCarModel.setText(firstModel);
            mCarRate.setText(firstRate);
        }


        //accsesss the activity instance using the get Activity method

        bnImpli.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                // TDOD Auto-generated method stub

                Intent implicit = new Intent(Intent.ACTION_SEND);
                implicit.setType("text/plain");
                startActivity(implicit);

            }
        });

        bnDelete.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View view) {
                int deleteIndex = MainActivity.deleteIndex;
                MainActivity.carsArray.remove(deleteIndex);
                MainActivity.adapter.notifyDataSetChanged();

                updateCache();
                getActivity().
                        finish();

            }
        });

        return view;

    }

    private void updateCache() {
                try{


                    @SuppressWarnings("ConstantConditions") FileOutputStream outputStream = getActivity().openFileOutput("carData", Context.MODE_PRIVATE);

                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                    //iterate through carsArray
                    for(int i = 0; i < MainActivity.carsArray.size(); i++){

                        MainActivity.mCarData = MainActivity.carsArray.get(i);


                        objectOutputStream.writeObject(MainActivity.mCarData);
                    }
                    objectOutputStream.close();
                }catch (Exception e){
                    e.printStackTrace();

                }


            }



    }




