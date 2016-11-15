package com.example.sushi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity{
	private TextView textView_register;//"娉ㄥ唽"鎸夐挳
	private TextView textView_login;//"鐧诲綍"鎸夐挳
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        textView_register= (TextView) findViewById(R.id.register);
        textView_login= (TextView) findViewById(R.id.login);
        
        //璺宠浆鍒?娉ㄥ唽"椤甸潰
        textView_register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				//intent.setClass(LoginActivity.this,RegisterActivity.class);
				startActivity(intent);
			}
		});        
        //璺宠浆鍒?鐧诲綍"椤甸潰
        textView_login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//璐︽埛
				EditText usernametext=(EditText) findViewById(R.id.usernametext);
				String username=usernametext.getText().toString().trim();
				//瀵嗙爜
				EditText passwordtext=(EditText) findViewById(R.id.passwordtext);
				String password=passwordtext.getText().toString().trim();
				if ("".equals(username)) {
					Toast.makeText(LoginActivity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
					return;
				}
				if ("".equals(password)) {
					Toast.makeText(LoginActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
					return;
				}
				if ((!"123".equals(password))||(!"admin".equals(username))) {
					Toast.makeText(LoginActivity.this,"请输入正确密码",Toast.LENGTH_SHORT).show();
					
					return;
				}
				Intent intent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("username", username);
				bundle.putString("password", password);
				intent.putExtras(bundle);
				intent.setClass(LoginActivity.this,MainActivity.class);
				startActivity(intent);
			}
		});
		
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    


}
