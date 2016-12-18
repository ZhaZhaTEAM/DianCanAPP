package com.example.jc.store.com.team.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.jc.store.R;
import com.example.jc.store.com.team.helper.ImportDB;

/**
 * Created by JC on 2016/12/16.
 */
public class StartActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        ImportDB importDB = new ImportDB(StartActivity.this);
        importDB.copyDatabase(this);// 复制文件

        Handler x = new Handler();
        x.postDelayed(new splashhandler(), 2000);

    }
    class splashhandler implements Runnable{
        public void run() {
            startActivity(new Intent(getApplication(),LoginSuccessActivity.class));
            StartActivity.this.finish();
        }
    }
}
