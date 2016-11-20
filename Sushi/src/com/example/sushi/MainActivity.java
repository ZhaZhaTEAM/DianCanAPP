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
import android.text.Layout;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MainActivity extends Activity {
	private ImageView imageView1, imageView2, imageView3, imageView4,
			imageView5, imageView6;
	private Button shouye, gouwuche, dingdan;
	private LinearLayout shouyelayout, gouwuchelayout, dingdanlayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.leader_layout);
	imageView1 = (ImageView) findViewById(R.id.shousiView);
		imageView2 = (ImageView) findViewById(R.id.cishenView);
		imageView3 = (ImageView) findViewById(R.id.junjianView);
		imageView4 = (ImageView) findViewById(R.id.fanjuanView);
		imageView5 = (ImageView) findViewById(R.id.xiaojuanView);
		imageView6 = (ImageView) findViewById(R.id.qiancaiView);
		shouye = (Button) findViewById(R.id.shouye);// 首页
		gouwuche = (Button) findViewById(R.id.gouwuche);// 购物车
		dingdan = (Button) findViewById(R.id.dingdan);// 订单
		shouyelayout = (LinearLayout) findViewById(R.id.shouyelayout);
		gouwuchelayout = (LinearLayout) findViewById(R.id.gouwuchelayout);
		dingdanlayout = (LinearLayout) findViewById(R.id.dingdanlayout);

		imageView1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, shousiActivity.class);
				startActivity(intent);
				finish();
			}
		});
		imageView2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, cishenActivity.class);
				startActivity(intent);
				finish();
			}
		});
		imageView3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, junjianActivity.class);
				startActivity(intent);
				finish();
			}
		});
		imageView4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, fanjuanActivity.class);
				startActivity(intent);
				finish();
			}
		});
		imageView5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, xiaojuanActivity.class);
				startActivity(intent);
				finish();
			}
		});
		imageView6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, qiancaiActivity.class);
				startActivity(intent);
				finish();
			}
		});

		// 首页按钮监听
		shouye.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 将购物车的层次隐藏
				if (gouwuchelayout.getVisibility() == 0) {
					gouwuchelayout.setVisibility(View.GONE);
				}
				// 将订单的层次隐藏
				if (dingdanlayout.getVisibility() == 0) {
					dingdanlayout.setVisibility(View.GONE);
				}
				// 将首页层次显示
				shouyelayout.setVisibility(View.VISIBLE);
			}
		});

		// 购物车按钮监听
		gouwuche.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// 将首页层次显示
				if (shouyelayout.getVisibility() ==0) {
					shouyelayout.setVisibility(View.GONE);
				}
				// 将订单的层次隐藏
				if (dingdanlayout.getVisibility() == 0) {
					dingdanlayout.setVisibility(View.GONE);
				}
				// 将购物车的层次隐藏
				gouwuchelayout.setVisibility(View.VISIBLE);
			}
		});

		// 订单按钮监听
		dingdan.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 将首页层次显示
				if (shouyelayout.getVisibility() == 0) {
					shouyelayout.setVisibility(View.GONE);
				}
				// 将购物车的层次隐藏
				if (gouwuchelayout.getVisibility() ==0) {
					gouwuchelayout.setVisibility(View.GONE);
				}
				// 将订单的层次隐藏
				dingdanlayout.setVisibility(View.VISIBLE);
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
