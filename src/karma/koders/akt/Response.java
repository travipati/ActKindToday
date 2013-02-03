package karma.koders.akt;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Response extends Activity {

	TextView result;
    public static String filename = "MyStoredData";
    SharedPreferences data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.responsepage);
	
        result = (TextView) findViewById(R.id.tvResponse);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            result.setText(extras.getString("response"));
        }
        
        data = getSharedPreferences(filename, 0);
		int points = data.getInt("points", 0);
		
		ProgressBar progress = (ProgressBar) findViewById(R.id.pbKarma);
        progress.setMax(5);
        progress.setProgress(points);
        
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
}
