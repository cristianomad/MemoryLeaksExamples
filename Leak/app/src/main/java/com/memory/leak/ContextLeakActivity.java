package com.memory.leak;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


/**
 * O memory leak aqui acontece pois está sendo passado o contexto da classe para uma
 * instância singleton, como essa instância irá existir durante toda a aplicação
 * então ela vai manter a referência para essa activity mesmo após ela ser destruída.
 */
public class ContextLeakActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SingletonTwo sgt = SingletonTwo.getInstance();
        sgt.setContext(this);

        /**
         * Solução. Ao passar o contexto da aplicação o memory leak não irá acontecer,
         * pois o contexto da aplicação é o mesmo durante toda a execução da aplicação
         */

        // sgt.setContext(getApplicationContext());
    }

}
