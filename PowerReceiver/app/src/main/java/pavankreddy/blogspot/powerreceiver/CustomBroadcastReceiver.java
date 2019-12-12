package pavankreddy.blogspot.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

public class CustomBroadcastReceiver extends BroadcastReceiver {

    ImageView imageView;

    public CustomBroadcastReceiver(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String toastMessage = "Unknown BroadCast";

        if(intent.getAction()!=null){

            switch (intent.getAction()){
                case Intent.ACTION_POWER_CONNECTED:
                    imageView.setImageResource(R.drawable.battery_charging);
                    toastMessage = "POWER CONNECTED, DEVICE CHARGING";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    imageView.setImageResource(R.drawable.battery_discharging);
                    toastMessage = "POWER DISCONNECTED, DEVICE NOT CHARGING";
                    break;
            }
        }


        Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
    }
}
