package com.memory.leak;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class ContextLeakActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SingletonTwo sgt = SingletonTwo.getInstance();
        sgt.setContext(getApplicationContext());
    }

}
