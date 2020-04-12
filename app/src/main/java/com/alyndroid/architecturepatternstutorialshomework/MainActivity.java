package com.alyndroid.architecturepatternstutorialshomework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,Presenter.PresenterInterface {

    Button mPlusBtn, mDivisionBtn, mMulBtn;

    DataBase dataBase = new DataBase();
    // MVP
    Presenter presenter = new Presenter(this);

    // MVVM
    NumberViewModel numberViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // %%%%%%%% MVC
        mPlusBtn = findViewById(R.id.plus_button);
        mPlusBtn.setOnClickListener(this);
        // %%%%%%%% MVC

        // ^^^^^^^^^ MVP
        mDivisionBtn = findViewById(R.id.div_button);
        mDivisionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.divideNumbers(dataBase.getNumbers().getFirstNum() / dataBase.getNumbers().getSecondNum());
            }
        });
        // ^^^^^^^^^ MVP

        // ********* MVVM
        mMulBtn = findViewById(R.id.mul_button);
        mMulBtn.setOnClickListener(this);
            numberViewModel = new ViewModelProvider(this).get(NumberViewModel.class);
            numberViewModel.numberViewModelLiveData.observe(this, new Observer<Integer>() {
                @Override
                public void onChanged(Integer integer) {
                    TextView mMultiplicationTxtView = findViewById(R.id.mul_result_textView);
                    mMultiplicationTxtView.setText("" + integer);
                }
            });
        // ********* MVVM

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.plus_button:
                // %%%%%%%% MVC
                makePlusEquation();
                // %%%%%%%% MVC
                break;
            case R.id.mul_button:
                // ********* MVVM
                numberViewModel.getMultiplicationNumber();
                // ********* MVVM
                break;
        }
    }

    // %%%%%%%% MVC
    private void makePlusEquation(){
        TextView mPlusTxtView = findViewById(R.id.plus_result_textView);
        mPlusTxtView.setText("" + (dataBase.getNumbers().getFirstNum() + dataBase.getNumbers().getSecondNum()));
    }
    // %%%%%%%% MVC




    // ^^^^^^^^^ MVP
    @Override
    public void showDividedNumber(int divided) {
        TextView mDividedResult = findViewById(R.id.div_result_textView);
        mDividedResult.setText("" + divided);
    }
    // ^^^^^^^^^ MVP



}
