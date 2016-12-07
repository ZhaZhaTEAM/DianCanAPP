package com.example.sushi;

import com.team.dao.UserDao;
import com.team.model.User;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity{
	private TextView textView_login,textView_register;
	public static SQLiteDatabase db; //创建SQLite数据库
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        textView_login= (TextView) findViewById(R.id.login);
        textView_register=(TextView) findViewById(R.id.zhuce);
        textView_login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				EditText usernametext=(EditText) findViewById(R.id.usernametext);
				String username=usernametext.getText().toString().trim();
				
				EditText passwordtext=(EditText) findViewById(R.id.passwordtext);
				String password=passwordtext.getText().toString().trim();
				
				/*if ("".equals(username)) {
					Toast.makeText(LoginActivity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
					return;
				}
				if ("".equals(password)) {
					Toast.makeText(LoginActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
					return;
				}
				if ((!"123".equals(password))||(!"admin".equals(username))) {
					Toast.makeText(LoginActivity.this,"用户名或密码不正确",Toast.LENGTH_SHORT).show();
				
					return;
				}
				Intent intent=new Intent();
				intent.setClass(LoginActivity.this, MainActivity.class);
				startActivity(intent);
				finish();*/
				
				if(username.equals("")||password.equals("")){
					Toast.makeText(LoginActivity.this,"账号或密码不能为空",Toast.LENGTH_SHORT).show();
				}else {
				
					 UserDao userDao=new UserDao(LoginActivity.this);
					boolean isexist= userDao.findUserAndPass(username, password);
					if (!isexist) {
						//跳到成功页面
						
						Toast.makeText(LoginActivity.this, "账号或密码不正确", Toast.LENGTH_LONG).show();
					}
					else{
						//提示不正确
						//Toast.makeText(LoginActivity.this, "账号或密码不正确", Toast.LENGTH_LONG).show();
						Intent intent=new Intent();
						intent.setClass(LoginActivity.this, MainActivity.class);
						startActivity(intent);
						finish();
					}
				}
			}
		});
        textView_register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(LoginActivity.this, RegisterActivity.class);
				startActivity(intent);
				finish();
			}
		});
        
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    


}
