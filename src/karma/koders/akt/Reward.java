package karma.koders.akt;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Reward extends Activity implements OnClickListener {

	Button bReturn;
    public static String filename = "MyStoredData";
    SharedPreferences data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.reward);
		
		bReturn = (Button) findViewById(R.id.bReturn);
		bReturn.setOnClickListener(this);
		
        data = getSharedPreferences(filename, 0);
		SharedPreferences.Editor editor = data.edit();
		editor.putInt("points", 0);
		editor.commit();
	}

	public void onClick(View v) {
		Intent hreturn = new Intent("karma.koders.akt.ACTKINDTODAYACTIVITY");
		startActivity(hreturn);		
	}
}
