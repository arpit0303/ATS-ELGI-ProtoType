package com.atselgi.atselgi.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.atselgi.atselgi.R;

public class ProductAdapter extends ArrayAdapter<String> {

	protected Context mContext;
	protected String[] mProduct;
	protected int[] mImages;
	protected int i = 0;

	public ProductAdapter(Context context, String[] product, int[] images) {
		super(context, R.layout.product_row, product);
		mContext = context;
		mProduct = product;
		mImages = images;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;

		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.product_row, null);
			holder = new ViewHolder();

			holder.bg = (ImageView) convertView.findViewById(R.id.details);
			holder.pline = (TextView) convertView.findViewById(R.id.text);

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
