package com.atselgi.atselgi;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.atselgi.atselgi.adapter.NavDrawerAdapter;
import com.atselgi.atselgi.wheelservice.WheelServiceActivity;

public class MainActivity extends Activity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getActionBar().setIcon(new ColorDrawable(android.R.color.transparent));
		mTitle = getTitle().toString().toUpperCase();
		getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM|ActionBar.DISPLAY_SHOW_HOME|ActionBar.DISPLAY_HOME_AS_UP); 
        getActionBar().setCustomView(R.layout.abs_start_layout);
        
        final TextView logo = (TextView) findViewById(R.id.mytext);
        final ImageView ABSIcon = (ImageView) findViewById(R.id.logo);
        ABSIcon.setImageResource(R.drawable.logo);
		
		Button start = (Button) findViewById(R.id.backButton);
		ImageView bg = (ImageView) findViewById(R.id.product_bg);
		bg.setBackgroundResource(R.drawable.s);
		ImageButton ImageStart = (ImageButton) findViewById(R.id.imageButton1);
		
		ImageStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this,
						ProductsActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				startActivity(intent);
				finish();
			}
		});
		
		
		start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this,
						ProductsActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				startActivity(intent);
				finish();
			}
		});
				
		
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		mDrawerList
				.setAdapter(new NavDrawerAdapter(this, Constants.mProductLine, Constants.mProductLineImages));
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		
		mDrawerToggle = new ActionBarDrawerToggle(this,
		mDrawerLayout,
		R.drawable.ic_navigation_drawer, 
		R.string.drawer_open, 
		R.string.drawer_close)
		{
			@Override
			public void onDrawerClosed(View view) {
				//getActionBar().setDisplayShowHomeEnabled(true);
				//getActionBar().setDisplayShowTitleEnabled(false);
				ABSIcon.setImageResource(R.drawable.logo);
				logo.setText("");
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				//getActionBar().setDisplayShowHomeEnabled(false);
				//getActionBar().setDisplayShowTitleEnabled(true);
				ABSIcon.setImageResource(0);
				logo.setText("PRODUCTS");
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return false;
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}

	private void selectItem(int position) {

		switch (position) {
		case 0:
			Intent intent = new Intent(this, WheelServiceActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

}