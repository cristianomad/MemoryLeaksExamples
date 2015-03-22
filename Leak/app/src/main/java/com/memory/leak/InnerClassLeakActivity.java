package com.memory.leak;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.lang.ref.WeakReference;

/**
 * O memory leak aqui acontece pois ao utilizar uma inner class não estática esta class mantém
 * referência a sua classe externa. Como a propriedade estática "leak" se mantém viva após
 * activity ser recriada, está propriedade mantém uma referência a activity anterior que já foi
 * destruída, impedindo esta porção de memória de ser liberada.
 */

public class InnerClassLeakActivity extends ActionBarActivity {

    private static Leak leak = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (leak == null)
            leak = new Leak();

        leak.doTask();

        // Solução
        // leak.doTask(this);
    }

    public class Leak {
        public void doTask() {
            Toast.makeText(InnerClassLeakActivity.this, "Task done!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Solução:
     * Utilize uma inner estática assim ela não irá manter nenhuma referência para a
     * classe externa. Caso precise de uma referência da classe externa na classe interna passe a
     * referência por parâmetro e proteja ela com uma weak reference. Assim o garbage collector
     * podera liberar essa porção de memória.
     */

    // private static class Leak {
    //     public void doTask(InnerClassLeakActivity context) {
    //         InnerClassLeakActivity activity = new WeakReference<InnerClassLeakActivity> (context).get();
    //         Toast.makeText(activity, "Task done!", Toast.LENGTH_SHORT).show();
    //     }
    // }

}
