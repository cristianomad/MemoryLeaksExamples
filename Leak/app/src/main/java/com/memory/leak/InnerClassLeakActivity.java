package com.memory.leak;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.lang.ref.WeakReference;


public class InnerClassLeakActivity extends ActionBarActivity {

    private static Leak leak = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (leak == null)
            leak = new Leak();

        leak.doTask(this);
    }

    private static class Leak {
        public void doTask(InnerClassLeakActivity context) {
            InnerClassLeakActivity activity = new WeakReference<InnerClassLeakActivity> (context).get();
            Toast.makeText(activity, "Task done!", Toast.LENGTH_SHORT).show();
        }
    }

}
