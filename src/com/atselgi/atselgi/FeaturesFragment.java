package com.atselgi.atselgi;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atselgi.atselgi.adapter.FeaturesAdapter;

public class FeaturesFragment extends ListFragment{
	
	String[] features = {"Corrosion resistant Hot dipped Galvanized structure","Soft Polyethylene brushes",
			"Stainless Steel precision nozzles","Wax to facilitate drying process","Rugged PLC control system",
			"Photo cell technology for vehicle mapping","Contour following brush and air blower",
			"Telescopic wheel brush system","Optimized flow control in side and top blower",
			"Increased Productivity( 7-8 minute operation time)",
			"Reduced water consumption ( 75 liters to 90 liters per car)",
			"Reduced labor costs ( Only one labor for the machine)"};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.features_fragment, container,
				false);
		
		FeaturesAdapter adapter = new FeaturesAdapter(getActivity().getApplicationContext(), features);
		setListAdapter(adapter);
		
		return rootView;
	}
}
