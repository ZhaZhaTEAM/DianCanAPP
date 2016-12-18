package com.example.jc.store.com.team.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jc.store.R;
import com.example.jc.store.com.team.bean.User;
import com.example.jc.store.com.team.dao.UserDao;
import com.example.jc.store.com.team.helper.ActivityManagerUtils;


/**
 * 注册页面
 *
 * @author JC
 */
public class RegisterActivity extends Activity {

    private TextView queding_textView, quxiao_textView;
    private String str = "";
    private Spinner spinner;
    private final static int RESULT_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
      /*  if (!CacheActivity.activityList.contains(RegisterActivity.this)) {
            CacheActivity.addActivity(RegisterActivity.this);
        }*/
        ActivityManagerUtils.getInstance().addActivity(this);
        queding_textView = (TextView) findViewById(R.id.queding);
        // quxiao_textView= (TextView) findViewById(R.id.quxiao);
        queding_textView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // 账户
                EditText usernametext = (EditText) findViewById(R.id.zhanghao);
                String username = usernametext.getText().toString().trim();
                // 密码
                EditText passwordtext = (EditText) findViewById(R.id.mima);
                String password = passwordtext.getText().toString().trim();
                // 性别，永远都不为空

                spinner = (Spinner) findViewById(R.id.xingbei);
                String str=spinner.getSelectedItem().toString();
                /*spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                        // str = (String) spinner.getSelectedItem();
                       spinner = (Spinner) adapterView;
                        str = (String) spinner.getItemAtPosition(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });*/
               /* Toast.makeText(RegisterActivity.this, str,
                        Toast.LENGTH_SHORT).show();*/

                // 电话号码
                EditText teltext = (EditText) findViewById(R.id.dianhua);
                String tel = teltext.getText().toString().trim();

                if ("".equals(username)) {
                    Toast.makeText(RegisterActivity.this, "账户不能为空~",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if ("".equals(password)) {
                    Toast.makeText(RegisterActivity.this, "密码不能为空~",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (("".equals(str.trim())) || (str == null) || ("" == (str.trim())) || (str.equals(null))) {
                    Toast.makeText(RegisterActivity.this, "性别不能为空~",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if ("".equals(tel)) {
                    Toast.makeText(RegisterActivity.this, "电话号码不能为空~",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                // String sex = str.trim();


                UserDao userDao = new UserDao(RegisterActivity.this);

                //查询是否存在已经拥有该用户
                User isexist = userDao.findByUserName(username);
                if (isexist != null) {
                    Toast.makeText(RegisterActivity.this, "用户名已经被注册，请重新填写用户名~",
                            Toast.LENGTH_SHORT).show();
                    return;

                }
                //添加用户

                User user = new User(0, username, password, str, tel);
                userDao.add(user);//添加数据

                new AlertDialog.Builder(RegisterActivity.this).setTitle("提示框").setMessage("注册成功，是否返回登录页面？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent();
                                setResult(RESULT_CODE, intent);
                                finish();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
/*
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("tel", tel);
                bundle.putString("username", username);
                bundle.putString("password", password);
                intent.putExtras(bundle);
                intent.setClass(RegisterActivity.this,
                        RegisterSuccessActivity.class);
                startActivity(intent);*/
            }
        });

   /*     quxiao_textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
Intent intent=new Intent();
setResult(RESULT_CODE,intent);
                finish();
            }
        });*/
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
