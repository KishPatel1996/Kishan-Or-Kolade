package wasserman.kishan_or_kolade;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.media.AudioManager;

@SuppressLint("NewApi")
public class Score extends ActionBarActivity{

Button returnButt;
TextView score;
MediaPlayer phone;

	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		setContentView(R.layout.scorescreen);
		
		Bundle temp= getIntent().getExtras();
		int sco=temp.getInt("KoladePoints");
		
		score=(TextView) findViewById(R.id.score);
		score.setText(sco+"");
		
		
		
		returnButt =(Button) findViewById(R.id.returnButt);
		returnButt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent("wasserman.kishan_or_kolade.MAINACTIVITY");
				startActivity(intent);
			}
		});
		phone= MediaPlayer.create(this,R.raw.phoneaway);    	
        phone.setVolume(1f, 1f);
        phone.start();
                 
             
         
		
		
	}
	
	
}
