package jp.ac.hal.kobayashi.rgbmeter;

import android.R.integer;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity {
	TextView mTextView;
	SeekBar[] mSeekBars = new SeekBar[3];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mTextView = (TextView)findViewById(R.id.textView1);
		mSeekBars[0] = (SeekBar)findViewById(R.id.seekBar1);
		mSeekBars[1] = (SeekBar)findViewById(R.id.seekBar2);
		mSeekBars[2] = (SeekBar)findViewById(R.id.seekBar3);
		for(int i = 0; i < 3; i++){
			mSeekBars[i].setMax(255);
			mSeekBars[i].setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
				}
				
				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
				}
				
				@Override
				public void onProgressChanged(SeekBar seekBar, int progress,
						boolean fromUser) {
					showColor();
				}
			});
		}
		showColor();
	}
	
	private void showColor(){
		int r = mSeekBars[0].getProgress();
		int g = mSeekBars[1].getProgress();
		int b = mSeekBars[2].getProgress();
		int color = Color.rgb(r, g, b);
		int color2 = Color.rgb(255 - r, 255 - g, 255 - b);
		mTextView.setText(String.format("RGB(%d, %d, %d)\n#%02X%02X%02X", r, g, b, r, g, b));
		mTextView.setBackgroundColor(color);
		mTextView.setTextColor(color2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
