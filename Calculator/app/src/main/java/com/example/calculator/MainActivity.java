package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;



import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNumber;
    private TextView tvResult;

    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;
    private Button btnNumber0;

    private Button btnPlus;
    private Button btnMinus;
    private Button btnMul;
    private Button btnDiv;
    private Button btnPoint;
    private Button btnEquals;
    private Button btnClear;
    private Button btnClearAll;
    private final String TAG = getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        initwidget();
        setEventClickViews();
    }
    public void initwidget(){
        edtNumber = (EditText) findViewById(R.id.edt_input);
        tvResult = (TextView)  findViewById(R.id.tv_result);

        btnNumber1 = (Button) findViewById(R.id.btnNumber1);
        btnNumber2 = (Button) findViewById(R.id.btnNumber2);
        btnNumber3 = (Button) findViewById(R.id.btnNumber3);
        btnNumber4 = (Button) findViewById(R.id.btnNumber4);
        btnNumber5 = (Button) findViewById(R.id.btnNumber5);
        btnNumber6 = (Button) findViewById(R.id.btnNumber6);
        btnNumber7 = (Button) findViewById(R.id.btnNumber7);
        btnNumber8 = (Button) findViewById(R.id.btnNumber8);
        btnNumber9 = (Button) findViewById(R.id.btnNumber9);
        btnNumber0 = (Button) findViewById(R.id.btnNumber0);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnPoint = (Button) findViewById(R.id.btnPoint);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnClearAll = (Button) findViewById(R.id.btnClearAll);
       btnEquals  = (Button) findViewById(R.id.btnEqual);

    }
    public void setEventClickViews(){
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);
        btnNumber0.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnClearAll.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnNumber0:
            //TO DO
                edtNumber.append("0");
                break;
            case R.id.btnNumber1:
                //TO DO
                edtNumber.append("1");
                break;
            case R.id.btnNumber2:
                //TO DO
                edtNumber.append("2");
                break;
            case R.id.btnNumber3:
                //TO DO
                edtNumber.append("3");
                break;
            case R.id.btnNumber4:
                //TO DO
                edtNumber.append("4");
                break;
            case R.id.btnNumber5:
                //TO DO
                edtNumber.append("5");
                break;
            case R.id.btnNumber6:
                //TO DO
                edtNumber.append("6");
                break;
            case R.id.btnNumber7:
                //TO DO
                edtNumber.append("7");
                break;
            case R.id.btnNumber8:
                //TO DO
                edtNumber.append("8");
                break;
            case R.id.btnNumber9:
                //TO DO
                edtNumber.append("9");
                break;
            case R.id.btnPlus:
                //TO DO
                edtNumber.append("+");
                break;
            case R.id.btnMinus:
                //TO DO
                edtNumber.append("-");
                break;
            case R.id.btnMul:
                //TO DO
                edtNumber.append("*");
                break;
            case R.id.btnDiv:
                //TO DO
                edtNumber.append("/");
                break;
            case R.id.btnPoint:
                //TO DO
                edtNumber.append(".");
                break;
            case R.id.btnClear:
                //TO DO
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(edtNumber, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btnClearAll:
                //TO DO
                edtNumber.setText("");
                tvResult.setText("");
                break;
            case R.id.btnEqual:
                //TO DO
                double result = 0;
                addOperation(edtNumber.getText().toString());
                addNumber(edtNumber.getText().toString());
                // Algorithm for calculating expressions
                if(arrOperation.size()>=arrNumber.size() ||arrOperation.size()<1){
                    tvResult.setText("format error");
                }else {
                    for (int i = 0; i < (arrNumber.size() - 1); i++) {
                        switch (arrOperation.get(i)) {
                            case "+":
                                if (i == 0) {
                                    result = arrNumber.get(i) + arrNumber.get(i + 1);
                                } else {
                                    result = result + arrNumber.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    result = arrNumber.get(i) - arrNumber.get(i + 1);
                                } else {
                                    result = result - arrNumber.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0) {
                                    result = arrNumber.get(i) * arrNumber.get(i + 1);
                                } else {
                                    result = result * arrNumber.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0) {
                                    result = arrNumber.get(i) / arrNumber.get(i + 1);
                                } else {
                                    result = result / arrNumber.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    tvResult.setText((result) + "");
                }

                // tvResult.setText(df.format(result) + "");
                //  edtNumber.setText("");
                //  result = 0;
//
        }
    }

    //Array contains calculations +, - , x, /
    public ArrayList<String> arrOperation;
    //Array contains numbers
    public ArrayList<Double> arrNumber;
    //Get all calculations stored in arrOperation arrays
    public int addOperation(String input) {
        arrOperation = new ArrayList<>();

        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '*':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/':
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }
    //Gets all numbers stored in the arrNumber array
    public void addNumber(String stringInput) {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while(matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
}
