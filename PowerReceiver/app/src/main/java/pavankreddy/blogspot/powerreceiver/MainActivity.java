package pavankreddy.blogspot.powerreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

   CustomBroadcastReceiver customBroadcastReceiver;
   ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view);
        // Set up your Receiver to receive ACTION_POWER_CONNECTED and ACTION_POWER_DISCONNECTED
        // and Register your receiver

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        customBroadcastReceiver = new CustomBroadcastReceiver(imageView);

        this.registerReceiver(customBroadcastReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(customBroadcastReceiver);
    }
}
