package com.example.sushi_leader;

import com.example.sushi.MainActivity;
import com.example.sushi.R;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ShoppingCartActivity extends MainActivity{
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.shoppingcart_layout);
	        
	        ActionBar actionBar=getActionBar();
	        actionBar.setDisplayShowHomeEnabled(true);
	        actionBar.setDisplayHomeAsUpEnabled(true);
	    }


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
	    
	    @Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// TODO Auto-generated method stub
			switch (item.getItemId()) {
			case android.R.id.home:
				//创建启动MainActivity的Intent
				Intent intent=new Intent(this,MainActivity.class);
				//添加额外的Flag，将Activity栈中处于MainActivity之上的Activity弹出
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				break;

			default:
				break;
			}
			return super.onOptionsItemSelected(item);
		}


}
