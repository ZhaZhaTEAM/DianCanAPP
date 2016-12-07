package com.example.sushi_select;

import java.util.ArrayList;
import java.util.List;

import com.example.sushi.MainActivity;
import com.example.sushi.R;
import com.team.dao.FoodDao;
import com.team.model.Food;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.MenuItem;
import android.widget.ListView;

public class shousiActivity extends Activity {
	ListView lv;
	List<Food> foods;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shousi_layout);
		lv=(ListView) findViewById(R.id.shousilv);

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);
		
	//	foods=ArrayList<Food>;
		FoodDao foodDao=new FoodDao(shousiActivity.this);
		List<Food> foods=foodDao.findAll();
		
		SimpleCursorAdapter simpleCursorAdapter=new SimpleCursorAdapter(shousiActivity.this,
				R.layout.item, (Cursor) foods, new String[]{"imagepath","name","detail","price"}, 
				new int[]{R.id.imageView1,R.id.nametext,R.id.detailtext,R.id.pricetext}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		lv.setAdapter(simpleCursorAdapter);
		
	}
	
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent intent = new Intent(this, MainActivity.class);			
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
