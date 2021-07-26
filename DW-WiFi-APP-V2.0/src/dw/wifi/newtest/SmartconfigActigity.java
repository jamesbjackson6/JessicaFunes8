package dw.wifi.newtest;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import dw.wifi.main.R;
public class SmartconfigActigity extends Activity {
	public static final int InputType_PASSWORD_VISIBLE = InputType.TYPE_CLASS_TEXT
	        | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD;
    public static final int InputType_PAssWORD_NORMAL = InputType.TYPE_CLASS_TEXT
        | InputType.TYPE_TEXT_VARIATION_PASSWORD;
//	private IOTApDBManager mIOTApDBManager;
    
    private WifiManager mWifiManager;
    private LocalBroadcastManager mBraodcastManager;
//    
	private TextView mSsidTV;
    private EditText mPasswordEdT;
	private CheckBox mShowPwdCB, mActivateCB;
	private Button mActivateBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_smartcfg);
		
		mActivateBtn = (Button)findViewById(R.id.activateBtn);
		
		mShowPwdCB = (CheckBox)findViewById(R.id.show_password);
		mActivateCB = (CheckBox)findViewById(R.id.activate);
        mShowPwdCB.setOnCheckedChangeListener(new CheckBoxChanged());
        mActivateCB.setOnCheckedChangeListener(new CheckBoxChanged());
//		mIOTApDBManager = IOTApDBManager.getInstance();
//        mWifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
//        mUser = BEspUser.getBuilder().getInstance();
//        
//        String ssid = EspBaseApiUtil.getWifiConnectedSsid();
//        if (ssid == null)
//        {
//            ssid = "";
//        }
        mSsidTV = (TextView)findViewById(R.id.ssid);
        mSsidTV.setText("113550500");
//        
//        final String bssid = getConnectionBssid();
        mPasswordEdT = (EditText)findViewById(R.id.password);
//        String password = getCurrentWifiPassword(bssid);
//        mPasswordEdT.setText("113550500");
//		
        if (mShowPwdCB.isChecked())
        {
            mPasswordEdT.setInputType(InputType_PASSWORD_VISIBLE);
        }
        else
        {
            mPasswordEdT.setInputType(InputType_PAssWORD_NORMAL);
        }
        if (mActivateCB.isChecked())
        {
        	mActivateBtn.setEnabled(true);
        }
        else
        {
        	mActivateBtn.setEnabled(false);
        }
	}
	private class CheckBoxChanged implements OnCheckedChangeListener{
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
	    {
	        if (buttonView == mShowPwdCB)
	        {
	            if (isChecked)
	            {
	                mPasswordEdT.setInputType(InputType_PASSWORD_VISIBLE);
	            }
	            else
	            {
	                mPasswordEdT.setInputType(InputType_PAssWORD_NORMAL);
	            }
	        }
	        if (buttonView == mActivateCB)
	        {
	            if (isChecked)
	            {
	            	mActivateBtn.setEnabled(true);
	            }
	            else
	            {
	            	mActivateBtn.setEnabled(false);
	            }
	        }
	    }
	}
	private String getConnectionBssid()
    {
        WifiInfo wifiInfo = mWifiManager.getConnectionInfo();
        if (wifiInfo != null)
        {
            return wifiInfo.getBSSID();
        }
        
        return null;
    }
	private String getCurrentWifiPassword(String currentBssid)
    {
//        List<ApDB> apDBList = mIOTApDBManager.getAllApDBList();
//        for (ApDB ap : apDBList)
//        {
//            if (ap.getBssid().equals(currentBssid))
//            {
//                return ap.getPassword();
//            }
//        }
        
        return "";
    }
}
