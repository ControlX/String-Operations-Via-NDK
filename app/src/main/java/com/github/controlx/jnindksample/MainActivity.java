package com.github.controlx.jnindksample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int i = 0;
    private String activityState = "onCreate";

    {
        System.loadLibrary("MyNativeLibrary");
    }

    public static native String MyNativeMethodStringType(String state);
    public static native int MyNativeMethodIntegerType(int times);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*TextView textView = new TextView(this);
        textView.setText(MyNativeMethodStringType()+" "+MyNativeMethodIntegerType());
        setContentView(textView);*/
    }

    @Override
    protected void onPause() {
        super.onPause();
        activityState = "onPause";
    }

    @Override
    protected void onResume() {
        super.onResume();
        i = i + MyNativeMethodIntegerType(0);

        TextView textView = new TextView(this);
        textView.setText(MyNativeMethodStringType(activityState)+" "+i);
        setContentView(textView);
    }

    @Override
    protected void onStop() {
        super.onStop();
        activityState = "onStop";
    }
}
