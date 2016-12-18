package com.example.jc.store.com.team.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jc.store.R;
import com.example.jc.store.com.team.bean.MyApplication;


/**
 * “我的”页面
 * @author JC
 *
 */
public class MineActivity extends Activity{

	private Button order,mylike,quit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view3);

		order=(Button)findViewById(R.id.order);
		mylike=(Button)findViewById(R.id.mylike);
		quit=(Button)findViewById(R.id.quit);

		order.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				MyApplication myApplication = (MyApplication) getApplication();
				String username = myApplication.getUsername();
				Intent intent = new Intent();
				if (username == "" || ("").equals(username) || ("null").equals(username) || null == username) {
					intent = new Intent(MineActivity.this, MainActivity.class);


				} else {

					intent = new Intent(MineActivity.this, OrderListActivity.class);

				}
				startActivity(intent);
			}
		});

		mylike.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
//				Intent intent=new Intent(MineActivity.this,LikeActivity.class);
//				startActivity(intent);
				MyApplication myApplication = (MyApplication) getApplication();
				String username = myApplication.getUsername();
				Intent intent = new Intent();
				if (username == "" || ("").equals(username) || ("null").equals(username) || null == username) {
					intent = new Intent(MineActivity.this, MainActivity.class);

				} else {

					intent = new Intent(MineActivity.this, LikeActivity.class);

				}
				startActivity(intent);
			}
		});

		quit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				android.os.Process.killProcess(android.os.Process.myPid());

			}
		});
	}
}
