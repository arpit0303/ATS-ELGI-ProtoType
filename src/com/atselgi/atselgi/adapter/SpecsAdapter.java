package com.atselgi.atselgi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.atselgi.atselgi.R;

public class SpecsAdapter extends ArrayAdapter<String> {

	protected Context mContext;
	protected String[] mSpecs;
	protected String[] mDesc;
	protected String[] mWt;
	protected String[] mSpecsValue;

	public SpecsAdapter(Context context, String[] specs, String[] details,String[] wt,String[] specsValue) {
		super(context, R.layout.specs_row, specs);
		mContext = context;
		mSpecs = specs;
		mDesc = details;
		mWt = wt;
		mSpecsValue = specsValue;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.specs_row, null);
			holder = new ViewHolder();
			
			holder.specs = (TextView) convertView.findViewById(R.id.specs);
			holder.specs_details = (TextView) convertView.findViewById(R.id.specs_details);
			holder.wt = (TextView) convertView.findViewById(R.id.imageTitle);
			holder.specsValue = (TextView) convertView.findViewById(R.id.specsValue);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.specs.setText(mSpecs[position]);
		holder.specs_details.setText(mDesc[position]);
		holder.wt.setText(mWt[position]);
		holder.specsValue.setText(mSpecsValue[position]);

		return convertView;
	}

	public static class ViewHolder {
		TextView specs;
		TextView specs_details;
		TextView wt;
		TextView specsValue;
	}
}
