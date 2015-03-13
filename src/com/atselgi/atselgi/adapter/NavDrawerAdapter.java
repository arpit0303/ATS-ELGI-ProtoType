package com.atselgi.atselgi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atselgi.atselgi.R;

public class NavDrawerAdapter extends ArrayAdapter<String> {

	protected Context mContext;
	protected String[] mText;
	protected int[] mImages;

	public NavDrawerAdapter(Context context, String[] text, int[] images) {
		super(context, R.layout.nav_drawer_item, text);
		mContext = context;
		mText = text;
		mImages = images;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.nav_drawer_item, null);
			holder = new ViewHolder();
			
			holder.nav_title = (TextView) convertView.findViewById(R.id.nav_text);
			holder.nav_image = (ImageView) convertView.findViewById(R.id.nav_image);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.nav_title.setText(mText[position]);
		holder.nav_image.setImageResource(mImages[position]);

		return convertView;
	}

	public static class ViewHolder {
		TextView nav_title;
		ImageView nav_image;
	}
}
