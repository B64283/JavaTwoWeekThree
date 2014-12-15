package com.example.matthewdarke.javatwoweekthree;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by matthewdarke on 12/14/14.
 */
///////This is ADD view /////////////////////////////ADD view



public class FirstFragment extends Fragment {


    private Cars cars;
    public ArrayList<Cars> mCars = new ArrayList<Cars>();
    private EditText carMake;
    private EditText carModel;
    private EditText carRate;
    private Button addBtn;

    public FirstFragment(){

        //super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v;
        v = inflater.inflate(R.layout.first_fragment, container, false);


        carMake = (EditText) v.findViewById(R.id.car_make_edit);
        carModel = (EditText) v.findViewById(R.id.editText2);
        carRate = (EditText) v.findViewById(R.id.editText3);
        addBtn = (Button) v.findViewById(R.id.b_add);

        addBtn.setOnClickListener(new View.OnClickListener() {

// add info to listview
            @Override
            public void onClick(View v) {
                String firstMake = carMake.getText().toString();
                String firstModel = carModel.getText().toString();
                String firstRate = carRate.getText().toString();

                cars = new Cars();
                cars.setmMake(firstMake);
                cars.setmModel(firstModel);
                cars.setmRate(firstRate);
                mCars.add(cars);

                Intent intent = new Intent();
                intent.putExtra("carData", mCars);

                getActivity().setResult(Activity.RESULT_OK, intent);
                getActivity().finish();





            }

        });

        return v;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }




}
