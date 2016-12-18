package com.example.jc.store.com.team.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jc.store.R;
import com.example.jc.store.com.team.bean.MyApplication;
import com.example.jc.store.com.team.dao.UserDao;
import com.example.jc.store.com.team.helper.ActivityManagerUtils;
import com.example.jc.store.com.team.helper.ImportDB;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 主页面
 */

public class MainActivity extends Activity {

    private TextView textView_register;// "注册"按钮
    private TextView textView_login;// "登录"按钮
    private final static int REQUEST_CODE = 1;
    private EditText usernametext, passwordtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

     /*   if (!CacheActivity.activityList.contains(MainActivity.this)) {
            CacheActivity.addActivity(MainActivity.this);
        }*/
        ActivityManagerUtils.getInstance().addActivity(this);
        //initAssets("store.db");// 读取数据库文件



        // WriteDB writeDB=new WriteDB(this);
        // writeDB.write();


        textView_register = (TextView) findViewById(R.id.register);
        textView_login = (TextView) findViewById(R.id.login);
        usernametext = (EditText) findViewById(R.id.usernametext);
        passwordtext = (EditText) findViewById(R.id.passwordtext);
        // 跳转到"注册"页面
        textView_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, RegisterActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        // 跳转到"登录"页面
        textView_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 账户
                // usernametext = (EditText) findViewById(R.id.usernametext);
                String username = usernametext.getText().toString().trim();
                // 密码
                //  passwordtext = (EditText) findViewById(R.id.passwordtext);
                String password = passwordtext.getText().toString().trim();
                if ("".equals(username)) {
                    Toast.makeText(MainActivity.this, "账户不能为空",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if ("".equals(password)) {
                    Toast.makeText(MainActivity.this, "密码不能为空",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                UserDao userDao = new UserDao(MainActivity.this);
                boolean isexist = userDao.findUserAndPass(username, password);


                if (!isexist) {
                    Toast.makeText(MainActivity.this, "账户和密码不匹配",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                MyApplication myApplication = (MyApplication) getApplication();
                myApplication.setUsername(username);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("username", username);
                bundle.putString("password", password);
                intent.putExtras(bundle);
                intent.setClass(MainActivity.this, LoginSuccessActivity.class);
                startActivity(intent);
                ActivityManagerUtils.getInstance().finishActivity(MainActivity.this);
                //finish();
            }
        });

    }

    /**
     * 读取文件
     *
     * @param dbName
     */
    private void initAssets(String dbName) {
        File filesDir = getFilesDir();
        File file = new File(filesDir, dbName);
        if (file.exists()) {
            return;
        }
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            is = getAssets().open(dbName);
            fos = new FileOutputStream(file);
            byte[] b = new byte[1024];
            int temp = -1;
            while ((temp = is.read(b)) != -1) {
                fos.write(b, 0, temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null && fos != null) {
                try {
                    is.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
