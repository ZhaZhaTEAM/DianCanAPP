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
	private TextView textView_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        textView_login= (TextView) findViewById(R.id.login);
        
        
        textView_login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				EditText usernametext=(EditText) findViewById(R.id.usernametext);
				String username=usernametext.getText().toString().trim();
				
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
					Toast.makeText(LoginActivity.this,"用户名或密码不正确",Toast.LENGTH_SHORT).show();
					
					return;
				}
				Intent intent = new Intent(LoginActivity.this,MainActivity.class);
				/*intent.putExtra("username", username);
				intent.putExtra("password", password);*/
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
