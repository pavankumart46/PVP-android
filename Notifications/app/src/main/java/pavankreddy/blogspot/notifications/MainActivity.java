

package pavankreddy.blogspot.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationManager notificationManager;
    private static final String NOTIFICATION_CHANNEL_ID = "mynotification";
    private static int NOTIFICATION_ID = 43;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }

    public void sendNotification(View view)
    {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel nc = new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                    "New Noti Channel",NotificationManager.IMPORTANCE_HIGH);
            nc.enableLights(true);
            nc.setLightColor(Color.RED);
            nc.setDescription("This is created for demonstration");
            nc.enableVibration(true);
            notificationManager.createNotificationChannel(nc);
        }

        NotificationCompat.Builder notification =
                new NotificationCompat.Builder(this,NOTIFICATION_CHANNEL_ID);
        notification.setSmallIcon(R.drawable.nt_icon);
        notification.setContentTitle("Test Notification");
        notification.setContentText("This is a sample descriptive text for notification");
        notification.setPriority(NotificationCompat.PRIORITY_HIGH);
        notification.setDefaults(NotificationCompat.DEFAULT_ALL);

        //Make the notification intractable.
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this,54,intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);
        notification.setAutoCancel(true);
        notification.addAction(R.drawable.nt_icon,"ACTION - 1",pendingIntent);
        notification.addAction(R.drawable.nt_icon,"ACTION - 2",pendingIntent);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.abc);
        notification.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));
        /*Notification notificationCompat = notification.build();*/
        notificationManager.notify(NOTIFICATION_ID,notification.build());

    }

    public void cancelNotification(View view)
    {
        notificationManager.cancel(NOTIFICATION_ID);
    }
}
