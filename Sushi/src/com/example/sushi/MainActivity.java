package com.example.sushi;

import com.example.sushi_select.cishenActivity;
import com.example.sushi_select.fanjuanActivity;
import com.example.sushi_select.junjianActivity;
import com.example.sushi_select.qiancaiActivity;
import com.example.sushi_select.shousiActivity;
import com.example.sushi_select.xiaojuanActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {
private ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView1=(ImageView)findViewById(R.id.shousiView);
        imageView2=(ImageView)findViewById(R.id.cishenView);
        imageView3=(ImageView)findViewById(R.id.junjianView);
        imageView4=(ImageView)findViewById(R.id.fanjuanView);
        imageView5=(ImageView)findViewById(R.id.xiaojuanView);
        imageView6=(ImageView)findViewById(R.id.qiancaiView);
        imageView1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, shousiActivity.class);
				startActivity(intent);
				finish();
			}
		});
       imageView2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, cishenActivity.class);
				startActivity(intent);
				finish();
			}
		});
     imageView3.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent=new Intent();
		intent.setClass(MainActivity.this, junjianActivity.class);
		startActivity(intent);
		finish();
	}
    });
   imageView4.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent=new Intent();
		intent.setClass(MainActivity.this, fanjuanActivity.class);
		startActivity(intent);
		finish();
	}
});
    imageView5.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent=new Intent();
		intent.setClass(MainActivity.this, xiaojuanActivity.class);
		startActivity(intent);
		finish();
	}
});
    imageView6.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent=new Intent();
		intent.setClass(MainActivity.this, qiancaiActivity.class);
		startActivity(intent);
		finish();
	}
});

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
