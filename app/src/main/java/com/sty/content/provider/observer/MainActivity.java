package com.sty.content.provider.observer;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.注册一个内容观察者
        Uri uri = Uri.parse("content://sms/");
        getContentResolver().registerContentObserver(uri, true, new MyContentObserver(new Handler()));
    }

    private class MyContentObserver extends ContentObserver {

        /**
         * Creates a content observer.
         *
         * @param handler The handler to run {@link #onChange} on, or null if none.
         */
        public MyContentObserver(Handler handler) {
            super(handler);
        }

        @Override
        public void onChange(boolean selfChange) {
            Log.i("Tag", "来自ContentProviderSmsBackObserverHM：短信的内容被更改了！！" );
            super.onChange(selfChange);
        }
    }
}
