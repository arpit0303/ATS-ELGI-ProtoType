package com.atselgi.atselgi.wheelservice;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.atselgi.atselgi.Constants;
import com.atselgi.atselgi.R;
import com.atselgi.atselgi.adapter.NavDrawerAdapter;
import com.atselgi.atselgi.adapter.ProductAdapter;

public class D3WheelAlignerActivity extends ListActivity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_products_sub);

		mTitle = getTitle().toString().toUpperCase();
		getActionBar().setIcon(new ColorDrawable(android.R.color.transparent));
		getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM|ActionBar.DISPLAY_SHOW_HOME|ActionBar.DISPLAY_HOME_AS_UP); 
        getActionBar().setCustomView(R.layout.abs_layout);
        
        final TextView actionBarTitle = (TextView)findViewById(R.id.mytext);
        actionBarTitle.setText(mTitle.toString());
		
		ProductAdapter adapter = new ProductAdapter(this,
				Constants.mProductLine1_1_1, Constants.mProductLineImages1_1_1);
		setListAdapter(adapter);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		mDrawerList.setAdapter(new NavDrawerAdapter(this,
				Constants.mProductLine, Constants.mProductLineImages));
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_navigation_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				actionBarTitle.setText(mTitle.toString());
			}

			public void onDrawerOpened(View drawerView) {
				actionBarTitle.setText("PRODUCTS");
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

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		if (position == 0) {
			Intent intent = new Intent(D3WheelAlignerActivity.this,
					ElegantXPActivity.class);
			startActivity(intent);
		}
	}

}
