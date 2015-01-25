package wasserman.kishan_or_kolade;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Vibrator;

public class GameScreen extends ActionBarActivity{
	private volatile boolean isCorrect;
	private int koladeP;
	private  Button kolade,kishan;
	private  ImageView image;
	private final PictureObj[] list;
	private volatile int index;
	
	
	
	public GameScreen(){
		list= new PictureObj[17];
		list[0]= new PictureObj(R.drawable.kolade1,true);
		list[1]= new PictureObj(R.drawable.kolade2,true);
		list[2]= new PictureObj(R.drawable.kolade3,true);
		list[3]= new PictureObj(R.drawable.kolade4,true);
		list[4]= new PictureObj(R.drawable.kolade5,true);
		
		list[5]= new PictureObj(R.drawable.kishan1,false);
		list[6]= new PictureObj(R.drawable.kishan2,false);
		list[7]= new PictureObj(R.drawable.kishan3,false);
		list[8]= new PictureObj(R.drawable.kishan4,false);
		list[9]= new PictureObj(R.drawable.kishan5,false);
		list[10]= new PictureObj(R.drawable.kishan6,false);
		
		list[11]= new PictureObj(R.drawable.kolade6,true);
		list[12]= new PictureObj(R.drawable.kolade7,true);
		list[13]= new PictureObj(R.drawable.kolade8,true);
		
		list[14]= new PictureObj(R.drawable.kishan7,false);
		list[15]= new PictureObj(R.drawable.kishan8,false);
		list[16]= new PictureObj(R.drawable.kishan9,false);
		
		
		isCorrect=false;
		koladeP=-500;
		
		
	}
	
	
	
	@SuppressLint("NewApi")
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gamescreen);
		
		kolade=(Button) findViewById(R.id.koladeButt);
		kishan=(Button) findViewById(R.id.kishButt);
		
		
		kolade.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				isCorrect = list[index].getIsKolade();
				
				
			}
		});
		
		
		
		kishan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				isCorrect = !list[index].getIsKolade();
			}
		});
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		
		
		
		
		
		final Thread timer = new Thread() {
			public void run(){
				do{
				try{
					isCorrect=false;
					
					
					index= (int) (Math.random()*17);
					
					
					
					image= (ImageView) findViewById(R.id.image);
					
					
					runOnUiThread(new Runnable() {
					    public void run() {
					    	image.setImageResource(list[index].getID());
					    }
					});
					
					
					sleep(1000);
				} catch(Throwable e){
					e.printStackTrace();
				}finally{
					koladeP +=500;
					if(!isCorrect){
						Intent intent=new Intent("wasserman.kishan_or_kolade.SCORESCREEN");
						intent.putExtra("KoladePoints", koladeP);
						startActivity(intent);
					} 
				}
			}while(isCorrect);
				
			}
		};

		timer.start();
		
		
		
	}
	
	
}
