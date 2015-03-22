package com.memory.leak;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

/**
 * O memory leak aqui acontece ao passar uma inner class anônima para uma instância singleton, pois
 * a inner class anônima irá manter uma referência ao contexto da classe externa mesmo após
 * ela ser destruída.
 *
 * Ver solução na classe Singleton.java
 */

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
