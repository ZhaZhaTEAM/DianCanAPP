package com.example.sushi;

import com.team.dao.UserDao;
import com.team.model.User;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends MainActivity{
	 Button Rsurebt;
	 EditText Rusername,Rpassord;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		Rsurebt=(Button) findViewById(R.id.Rsure);
		Rusername=(EditText) findViewById(R.id.Rusername);
		Rpassord=(EditText) findViewById(R.id.Rpassword);
		Rsurebt.setOnClickListener(new OnClickListener() {
			
			private User user;

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String username=Rusername.getText().toString().trim();
				String password=Rpassord.getText().toString().trim();
				if(username.equals("")||password.equals("")){
					Toast.makeText(RegisterActivity.this,"账号或密码不能为空",Toast.LENGTH_SHORT).show();
				}else {
				
					 UserDao userDao=new UserDao(RegisterActivity.this);
					 boolean isexist = userDao.add(null, username,password);
					if(!(username.equals("")&&password.equals(""))){
						if ((Boolean) isexist) {
							DialogInterface.OnClickListener ss=new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface arg0, int arg1) {
									// TODO Auto-generated method stub
									Intent intent=new Intent();
									intent.setClass(RegisterActivity.this, LoginActivity.class);
									RegisterActivity.this.onDestroy();//销毁当前Activity
								}
							};
							Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
						}else {
							Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
						}
					}else {
						Toast.makeText(RegisterActivity.this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
					}
					
				}
			}
		});
	}

}
