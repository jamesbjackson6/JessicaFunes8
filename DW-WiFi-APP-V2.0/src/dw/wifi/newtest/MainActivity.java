package dw.wifi.newtest;

import dw.wifi.config.WiFiConfigActivity;
import dw.wifi.fast_test.WIfiFastTestActivity;
import dw.wifi.main.LoginActivity;
import dw.wifi.main.R;
import dw.wifi.server_test.WifiServerConnectActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button smartCfgBtn, normalCfgBtn, apTestBtn, remoteCotBtn;
	private Switch ledSWT, beepSWT, tempSWT;
	private ImageView ledIimageView, beepIimageView;
	private TextView myAddress;//‘› ±√ª”√
	private TextView currentModeTV, temperatureTV;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.test);
		
		myAddress = (TextView) findViewById(R.id.myAddress);
		
		currentModeTV = (TextView) findViewById(R.id.currentModeTV);
		temperatureTV = (TextView) findViewById(R.id.temperatureTV);		
		
		smartCfgBtn = (Button) findViewById(R.id.smartCfgBtn);
		normalCfgBtn = (Button) findViewById(R.id.normalCfgBtn);
		apTestBtn = (Button) findViewById(R.id.apTestBtn);
		remoteCotBtn = (Button) findViewById(R.id.remoteCotBtn);
		
		ledSWT = (Switch) findViewById(R.id.ledSWT);
		beepSWT = (Switch) findViewById(R.id.beepSWT);
		tempSWT = (Switch) findViewById(R.id.tempSWT);
		
		ledIimageView = (ImageView) findViewById(R.id.ledIimageView);
		beepIimageView = (ImageView) findViewById(R.id.beepIimageView);
		
		smartCfgBtn.setOnClickListener(new ButtonClickEvent());
		normalCfgBtn.setOnClickListener(new ButtonClickEvent());
		apTestBtn.setOnClickListener(new ButtonClickEvent());
		remoteCotBtn.setOnClickListener(new ButtonClickEvent());
		
		ledSWT.setOnClickListener(new ButtonClickEvent());
		beepSWT.setOnClickListener(new ButtonClickEvent());
		tempSWT.setOnClickListener(new ButtonClickEvent());
	}
	class ButtonClickEvent implements View.OnClickListener {
		public void onClick(View v) {

			if(v == smartCfgBtn){
				Intent intent = new Intent(MainActivity.this,SmartconfigActigity.class);  
                startActivity(intent);				
			}
			else if(v == normalCfgBtn){
//				Intent intent = new Intent(MainActivity.this,WiFiConfigActivity.class);  
//                startActivity(intent);				
			}
			else if(v == apTestBtn){
//				Intent intent = new Intent(MainActivity.this,WifiServerConnectActivity.class);  
//                startActivity(intent);				
			}
			else if(v == remoteCotBtn){
//				Intent intent = new Intent(MainActivity.this,WiFiConfigActivity.class);  
//                startActivity(intent);				
			}
			else if(v == ledSWT){
				if(ledSWT.isChecked())
					ledIimageView.setImageDrawable(getResources().getDrawable(R.drawable.ledlight));
				else
					ledIimageView.setImageDrawable(getResources().getDrawable(R.drawable.ledclose));
			}
			else if(v == beepSWT){
				if(beepSWT.isChecked())
					beepIimageView.setImageDrawable(getResources().getDrawable(R.drawable.beepopen));
				else
					beepIimageView.setImageDrawable(getResources().getDrawable(R.drawable.beepclose));
			}
			else if(v == tempSWT){
				if(tempSWT.isChecked())
					temperatureTV.setText("25.0" + "°Ê");
				else
					temperatureTV.setText("85.0" + "°Ê");;				
			}
		}
	}
}
