package com.atselgi.atselgi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atselgi.atselgi.R;

public class CustomAdapter extends ArrayAdapter<String> {

	protected Context mContext;
	protected String[] mProduct;
	protected int[] mImages;
	protected int i = 0;

	public CustomAdapter(Context context, String[] product, int[] images) {
		super(context, R.layout.custom_row, product);
		mContext = context;
		mProduct = product;
		mImages = images;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.custom_row, null);
			holder = new ViewHolder();

			holder.bg = (ImageView) convertView.findViewById(R.id.product_bg);
			holder.pline = (TextView) convertView.findViewById(R.id.imageTitle);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.pline.setText(mProduct[position]);
		holder.bg.setBackgroundResource(mImages[position]);
		

		return convertView;
	}

	public static class ViewHolder {
		ImageView bg;
		TextView pline;
	}
}
