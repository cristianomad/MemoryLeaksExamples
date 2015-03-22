package com.memory.leak;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;


public class AnonymousClassLeakActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Singleton sgt = Singleton.getInstance();
        sgt.addListener(new Singleton.OnTaskCompleteListener() {
            @Override
            public void onTaskComplete() {
                Toast.makeText(AnonymousClassLeakActivity.this,
                        "Task done!", Toast.LENGTH_SHORT).show();
            }
        });

        sgt.doTask();
    }

}
