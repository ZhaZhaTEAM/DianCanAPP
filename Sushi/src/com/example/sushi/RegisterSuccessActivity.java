package com.example.jc.store.com.team.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.jc.store.R;
import com.example.jc.store.com.team.helper.ActivityManagerUtils;

public class RegisterSuccessActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registersuccess);
	/*	if (!CacheActivity.activityList.contains(RegisterSuccessActivity.this)) {
			CacheActivity.addActivity(RegisterSuccessActivity.this);
		}*/
		ActivityManagerUtils.getInstance().addActivity(this);
	}
}
