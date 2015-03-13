package com.atselgi.atselgi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.atselgi.atselgi.R;

public class FeaturesAdapter extends ArrayAdapter<String> {

	protected Context mContext;
	protected String[] mFeature;

	public FeaturesAdapter(Context context, String[] feature) {
		super(context, R.layout.features_row, feature);
		mContext = context;
		mFeature = feature;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.features_row, null);
			holder = new ViewHolder();
			
			holder.feature = (TextView) convertView.findViewById(R.id.feature);
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.feature.setText(mFeature[position]);

		return convertView;
	}

	public static class ViewHolder {
		TextView feature;
	}
}
