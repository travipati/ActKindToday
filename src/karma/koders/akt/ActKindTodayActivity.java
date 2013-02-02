package karma.koders.akt;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActKindTodayActivity extends Activity {

    int points = 0;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Random randomGenerator = new Random();
        String rakList[] = {"test0", "test1", "test2", "test3", "test4", "test5"};
        
        TextView rak = (TextView) findViewById(R.id.tvRak);
        Button upPoint = (Button) findViewById(R.id.bSuccess);
        Button downPoint = (Button) findViewById(R.id.bFail);
        
        int rIndex = randomGenerator.nextInt(6);
        rak.setText(rakList[rIndex]);
        
        upPoint.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				points++;
			}
		});
        
        downPoint.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
			
			}
		});
    }
}