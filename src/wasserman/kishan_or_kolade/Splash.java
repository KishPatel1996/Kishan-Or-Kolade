package wasserman.kishan_or_kolade;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

@SuppressLint("NewApi")
public class Splash extends ActionBarActivity {
private volatile MediaPlayer bg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

		
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		Thread timerThree = new Thread(){
			public void run(){
				try{
					sleep(3000);
				} catch(Throwable e){
					e.printStackTrace();
				} finally{
					Intent temp = new Intent("wasserman.kishan_or_kolade.MAINACTIVITY");
					
					startActivity(temp);
					
				}
			}
		};
		
		
		bg= MediaPlayer.create(this,R.raw.party);
		bg.setLooping(true);
		bg.setVolume(.1f,.1f);
		bg.start();
		timerThree.start();
		
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		bg.reset();
		bg.release();
	}
	
}
