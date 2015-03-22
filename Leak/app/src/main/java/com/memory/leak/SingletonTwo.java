package com.memory.leak;

import android.content.Context;


public class SingletonTwo {

    private static SingletonTwo mInstance;

    private Context mContext;

    public static SingletonTwo getInstance() {
        if (mInstance == null) {
            mInstance = new SingletonTwo();
        }

        return mInstance;
    }

    protected SingletonTwo() {}

    public void setContext(Context context) {
        if (mContext == null) {
            mContext = context;
        }
    }

}
