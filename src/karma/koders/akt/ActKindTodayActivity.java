package karma.koders.akt;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ActKindTodayActivity extends Activity implements OnClickListener {
	
	TextView rak;
	TextView result;
    Button upPoint;
    Button downPoint;
    ProgressBar progress;
    public static String filename = "MyStoredData";
    SharedPreferences data;
    
    String rakList[] = {
    	"Smile at a stranger", 
    	"Add money to an expired meter", 
    	"Pick up some litter", 
    	"Take your neighbor's trashbins in", 
    	"Hold the elevator door", 
    	"Compliment a complete stranger"
	};
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setUpVariables();
        
        Random randomGenerator = new Random();
        int rIndex = randomGenerator.nextInt(6);
        rak.setText(rakList[rIndex]);
    }
	
	private void setUpVariables() {
        rak = (TextView) findViewById(R.id.tvRak);
        upPoint = (Button) findViewById(R.id.bSuccess);
        downPoint = (Button) findViewById(R.id.bFail);
        upPoint.setOnClickListener(this);
        downPoint.setOnClickListener(this);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bSuccess:
	        data = getSharedPreferences(filename, 0);
			int points = data.getInt("points", 0);
			points++;
			SharedPreferences.Editor editor = data.edit();
			editor.putInt("points", points);
			editor.commit();
			
			if (points < 5) {
				Intent response = new Intent("karma.koders.akt.RESPONSE");
				response.putExtra("response", "Congrats!");
				startActivity(response);				
			} else {
				Intent reward = new Intent("karma.koders.akt.REWARD");
				startActivity(reward);					
			}
			
			break;
		case R.id.bFail:
			Intent response = new Intent("karma.koders.akt.RESPONSE");
			response.putExtra("response", "You suck!");
			startActivity(response);	

			break;
		}
	}
}