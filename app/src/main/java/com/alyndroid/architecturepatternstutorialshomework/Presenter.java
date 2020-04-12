package com.alyndroid.architecturepatternstutorialshomework;

public class Presenter {

    private PresenterInterface presenterInterface;

    public Presenter(PresenterInterface presenterInterface){
       this.presenterInterface =   presenterInterface ;
    }

    public void divideNumbers(int divNumber){
        presenterInterface.showDividedNumber(divNumber);
    }

    public interface PresenterInterface{
        void showDividedNumber(int divided);
    }

}
