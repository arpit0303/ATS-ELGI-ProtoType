package com.atselgi.atselgi;


import com.atselgi.atselgi.adapter.SpecsAdapter;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SpecsFragment extends ListFragment{

	String[] specs = {"No of Brushes",
			"Recommended Bay Dimension",
			"Max Vehicle Access",
			"Washing System",
			"Controls",
			"Brush Material",
			"Shampoo / Wax Mixing Controls",
			"Drying",
			"Electric Supply",
			"Pneumatic Requirement"};
	String[] specsValue ={"","","","PLC Automation","","Polyethylene","Venturi System","","415 V, 3ph, 50 Hz",""
	};
	
	String[] desc = {"Vertical Brush\nHorizontal Brush\nWheel brush",
			"Length\nWidth\nHeight",
			"Length\nWidth\nHeight",
			"","Horizontal Brush\n  Brush Pressure Control\n  Up/Down Movement" +
					"\n\nVertical Brush\n  Brush Pressure Control\n  Pressure Applied on the \n  Car" +
					"\n\nWheel Brush\n  Wheel position Detection\n  Brush Movement",
			"","",
			"Top Blower\nTop blower Movement Control\nCar Contour Detection\nSide Blower",
			"Max Power Required",
			"Pressure"};
	String[] wt ={"2 Nos\n1 Nos\n2 Nos",
			"10000 mm\n  4600 mm\n  5000 mm",
			"5200 mm\n2000 mm\n2300 mm",
			"","\n  Electronic Pressure Sensing\n  Hydraulic System" +
					"\n\n\n  Pneumatic System\n  0.8 -1.2 bar\n" +
					"\n\n\n  Through photo sensor\n  Pneumatic System",
			"","",
			"2 nos (Each 2.2 KW)\nHydraulic System\nPhoto Sensor\n2 nos (Each 3.8 KW)",
			"25/18 Hp/KW",
			"6-7 bar"};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.specs_fragment, container,
				false);
		
		SpecsAdapter adapter = new SpecsAdapter(getActivity().getApplicationContext(),specs,desc, wt, specsValue);
		setListAdapter(adapter);
		
		return rootView;
	}
}
