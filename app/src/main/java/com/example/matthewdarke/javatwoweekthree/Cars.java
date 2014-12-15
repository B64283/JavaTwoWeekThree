package com.example.matthewdarke.javatwoweekthree;

import java.io.Serializable;

/**
 * Created by matthewdarke on 12/14/14.
 */
///CUSTOM CARS CLASS ////////////////////////////


public class Cars implements Serializable {

    //set up svUID
    public static final long serialVersionUID = 7877777587982937458L;

    public static Cars newInstance(String _model, String _make, String _rate) {

        Cars car = new Cars();
        car.setmModel(_model);
        car.setmMake(_make);
        car.setmRate(_rate);
        return car;
    }

    private String mModel;
    private String mMake;
    private String mRate;

    public Cars(){


        mModel ="";
        mMake = "";
        mRate = "";

    }
    private Cars(String _model, String _make, String _rate) {

        mModel = _model;
        mMake = _make;
        mRate = _rate;




    }

    public String getmModel() {
        return mModel;
    }

    public void setmModel(String mModel) {
        this.mModel = mModel;
    }

    public String getmMake() {
        return mMake;
    }

    public void setmMake(String mMake) {
        this.mMake = mMake;
    }

    public String getmRate() {
        return mRate;
    }

    public void setmRate(String mRate) {
        this.mRate = mRate;
    }



    @Override
    public String toString() {
        return mModel;

    }

}
