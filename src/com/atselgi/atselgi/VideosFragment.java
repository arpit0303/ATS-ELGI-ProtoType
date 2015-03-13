package com.atselgi.atselgi;


import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class VideosFragment extends Fragment {

	public static final String uriPath = "rtsp://r2---sn-o097zues.c.youtube.com/CiILENy73wIaGQmXazsLEgHBCxMYESARFEgGUgZ2aWRlb3MM/0/0/0/video.3gp";
	public static final String mVideoTitle = "Wheel video";
	public static final String mVideoDesc = "Wheel";
	public static int click = 0;
	public static int CurrentPosition = 0;
	private VideoView mVideoView;
	private ImageButton mMedia;
	ProgressDialog pDialog;

	@Override
	public View onCreateView(LayoutInflater inflater,
			final ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.video_fragment, container,
				false);

		mVideoView = (VideoView) rootView.findViewById(R.id.video);
		TextView videoTitle = (TextView) rootView.findViewById(R.id.VideoTitle);
		TextView videoDesc = (TextView) rootView.findViewById(R.id.VideoDesc);
		final ImageButton mReplay = (ImageButton) rootView
				.findViewById(R.id.replay);
		mMedia = (ImageButton) rootView.findViewById(R.id.mediaButton);

		videoTitle.setText(mVideoTitle);
		videoDesc.setText(mVideoDesc);

		MediaController mc = new MediaController(container.getContext());
		mc.setAnchorView(mVideoView);
		mc.setMediaPlayer(mVideoView);

		final Uri uri = Uri.parse(uriPath);
		mVideoView.setMediaController(mc);

		mReplay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View ReplayView) {
				mVideoView.setVideoURI(uri);
				mVideoView.requestFocus();
				mVideoView.start();
			}
		});

		mMedia.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View Mediav) {
				if (click == 0) {
					mVideoView.setVideoURI(uri);
					mVideoView.requestFocus();
					mVideoView.start();
					mMedia.setImageResource(R.drawable.pause);
				} else if (click % 2 == 0) {
					mVideoView.seekTo(CurrentPosition);
					mVideoView.start();
					mMedia.setImageResource(R.drawable.pause);
				} else {
					CurrentPosition = mVideoView.getCurrentPosition();
					mVideoView.pause();
					mMedia.setImageResource(R.drawable.resume);
				}
				click++;
			}

			private void streaming(ViewGroup container) {
				// Create a progressbar
				pDialog = new ProgressDialog(container.getContext());
				// Set progressbar title
				pDialog.setTitle("ATS-ELGI Video Streaming");
				// Set progressbar message
				pDialog.setMessage("Buffering...");
				pDialog.setIndeterminate(false);
				pDialog.setCancelable(false);
				// Show progressbar
				pDialog.show();
			}
		});

		return rootView;
	}

	@Override
	public void onPause() {
		super.onPause();
		CurrentPosition = mVideoView.getCurrentPosition();
		mVideoView.pause();
		mMedia.setImageResource(R.drawable.resume);
	}

	@Override
	public void onStop() {
		super.onStop();
		click = 0;
	}

}
