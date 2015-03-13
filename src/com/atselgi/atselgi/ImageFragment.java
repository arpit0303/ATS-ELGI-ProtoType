package com.atselgi.atselgi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageFragment extends Fragment {

	public static final int[] images = {R.drawable.elegant_xp_1,R.drawable.elegant_xp_2};
	public static final String mImageTitle = "Wheel Service Alignment XP";
	public static final String mImageDesc = "With the Automatic car washer ATS ELGI brings " +
			"a new revolution in car washing in India. It offers an advanced washing technology to " +
			"the car washing industry and comes as a panacea for all the difficulties in manual car washing." +
			"It is a completely automated machine which gives an immaculate finish and increased productivity. " +
			"It is an excellent investment opportunity for entrepreneurs to reap big revenues and for " +
			"beginners who wish to start their new business venture.";
	public static int click = 0;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.image_fragment, container,
				false);
		
		ImageButton next = (ImageButton) rootView.findViewById(R.id.nextButton);
		ImageButton prev = (ImageButton) rootView.findViewById(R.id.prevButton);
		final ImageView details = (ImageView) rootView.findViewById(R.id.details);
		final TextView imageTitle = (TextView) rootView.findViewById(R.id.imageTitle);
		final TextView imageDesc = (TextView) rootView.findViewById(R.id.ImageDesc);
		
		imageTitle.setText(mImageTitle);
		imageDesc.setText(mImageDesc);
		details.setImageResource(images[click]);
		
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				click++;
				if(click >= images.length){
					click = 0;
				}
				details.setImageResource(images[click]);
//				imageTitle.setText(mImageTitle[click]);
//				imageDesc.setText(mImageDesc[click]);
			}
		});
		
		prev.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				click--;
				if(click < 0){
					click = images.length - 1;
				}
				details.setImageResource(images[click]);
//				imageTitle.setText(mImageTitle[click]);
//				imageDesc.setText(mImageDesc[click]);
			}
		});

		return rootView;
	}

}
