package karma.koders.akt;

import java.util.Random;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActKindTodayActivity extends Activity implements OnClickListener {
	
	TextView rak;
    Button upPoint;
    Button downPoint;
    public static String filename = "MyStoredData";
    SharedPreferences data;
    
    String rakList[] = {"test0", "test1", "test2", "test3", "test4", "test5"};
	
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
			int points = data.getInt("points", -1);
			points++;
			SharedPreferences.Editor editor = data.edit();
			editor.putInt("points", points);
			editor.commit();
			break;
		case R.id.bFail:
			break;
		}
	}
}