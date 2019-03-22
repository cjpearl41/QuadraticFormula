package com.example.caleb_p_quadratic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Button calcBtn = (Button) findViewById(R.id.calcBtn);
        calcBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                TextView ATextView = (TextView) findViewById(R.id.ATextView);
                TextView BTextView = (TextView) findViewById(R.id.BTextView);
                TextView CTextView = (TextView) findViewById(R.id.CTextView);


                ATextView.setText("A=" + solveA() +" ");
                BTextView.setText("B=" + solveB() + " ");
                CTextView.setText("C=" + solveC() + " ");





            }
        });
    }
    private double getX1(){
        EditText X1 = (EditText) findViewById(R.id.X1);
        return Double.parseDouble(X1.getText().toString());
    }
    private double getX2(){
        EditText X2 = (EditText) findViewById(R.id.X2);
        return Double.parseDouble(X2.getText().toString());
    }
    private double getX3(){
        EditText X3 = (EditText) findViewById(R.id.X3);
        return Double.parseDouble(X3.getText().toString());
    }
    private double getY1(){
        EditText Y1 = (EditText) findViewById(R.id.Y1);
        return Double.parseDouble(Y1.getText().toString());
    }
    private double getY2(){
        EditText Y2 = (EditText) findViewById(R.id.Y2);
        return Double.parseDouble(Y2.getText().toString());
    }
    private double getY3() {
        EditText Y3 = (EditText) findViewById(R.id.Y3);
        return Double.parseDouble(Y3.getText().toString());
    }
    private double solveA(){

        double step1 = getX1()*(getY3()-getY2());
        double step2 = getX2()*(getY1()-getY3());
        double step3 = getX3()*(getY2()-getY1());
        double numerator = step1+step2+step3;
        double step4 = getX1()-getX2();
        double step5 =  getX1()-getX3();
        double step6 = getX2()-getX3();
        double denominator = step4*step5*step6;
        double a = numerator/denominator;
        return a;
    }
    private double solveB(){

        double step1 = (getY2()-getY1())/(getX2()-getX1());
        double step2 = solveA()*(getX1()+getX2());
        double b = step1-step2;
        return b;
    }
    private double solveC(){
        double step1 = solveA()*Math.pow(getX1(),2);
        double step2 = solveB()*getX1();
        double c = getY1()-step1-step2;
        return c;
    }

}
