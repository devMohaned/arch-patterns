package com.alyndroid.architecturepatternstutorialshomework;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NumberViewModel extends ViewModel {
    MutableLiveData<Integer> numberViewModelLiveData = new MutableLiveData<>();
    DataBase dataBase = new DataBase();

    public void getMultiplicationNumber(){
        int multipliedNumber = dataBase.getNumbers().getFirstNum() * dataBase.getNumbers().getSecondNum();
        numberViewModelLiveData.setValue(multipliedNumber);
    }
}
