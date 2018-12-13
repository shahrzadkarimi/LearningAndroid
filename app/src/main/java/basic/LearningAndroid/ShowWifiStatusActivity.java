package basic.LearningAndroid;

import android.app.Activity;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ShowWifiStatusActivity extends AppCompatActivity {

    TextView status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_wifi_status);
        status=findViewById(R.id.status);
        findViewById(R.id.showWifiStatus).setOnClickListener(V->
        {
            startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
        });
    }


}
