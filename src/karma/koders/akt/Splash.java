package karma.koders.akt;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity{
	MediaPlayer ourSong;
	@Override
	protected void onCreate(Bundle BeTheBest) {

		super.onCreate(BeTheBest);
		setContentView(R.layout.splach);
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(3000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openStartingPoint= new Intent("karma.koders.akt.ACTKINDTODAYACTIVITY");
					startActivity(openStartingPoint);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
