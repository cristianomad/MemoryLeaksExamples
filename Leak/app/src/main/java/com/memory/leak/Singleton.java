package com.memory.leak;

import java.util.ArrayList;


public class Singleton {

    public interface OnTaskCompleteListener {
        void onTaskComplete();
    }

    private static Singleton mInstance;

    private ArrayList<OnTaskCompleteListener> mListenerQueue;

    public static Singleton getInstance() {
        if (mInstance == null) {
            mInstance = new Singleton();
        }

        return mInstance;
    }

    protected Singleton () {
        mListenerQueue = new ArrayList<OnTaskCompleteListener>();
    }

    public void addListener(OnTaskCompleteListener listener) {
        mListenerQueue.add(listener);
    }

    public void doTask () {
        // Task code

        for (OnTaskCompleteListener listener : mListenerQueue) {
            if (listener != null)
                listener.onTaskComplete();
        }

        /**
         * Solução:
         * Uma das soluções é remover essa referência antes que a activity seja destruída.
         */

        // mListenerQueue.clear();
    }

}
