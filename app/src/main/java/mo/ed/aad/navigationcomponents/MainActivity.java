package mo.ed.aad.navigationcomponents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.navigation.NavDeepLinkBuilder;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Intent;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Notification
    private static final int NOTIFICATION_ID = 1;
    private static final String CHANNEL_ID = "channel_01";
    private static final String CHANNEL_NAME = "channel_name";
    private static final String CHANNEL_DESCRIPTION = "channel_description";


    private NotificationManager mNotificationManager;
    private Uri mSoundUri;
    private NotificationChannel mChannel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNotification();
    }

    private void initNotification() {
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mSoundUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getApplicationContext().getPackageName() + "/" + R.raw.notification);

        // Android O requires a Notification Channel.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
            mChannel.enableLights(true);
            mChannel.enableVibration(true);
            mChannel.setDescription(CHANNEL_DESCRIPTION);

            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();
            mChannel.setSound(mSoundUri, audioAttributes);

            if (mNotificationManager != null) {
                mNotificationManager.createNotificationChannel(mChannel);
            }

            // TODO: 5/6/20 create arguments for the notification
            Bundle args = new BoatFragmentArgs.Builder(3).build().toBundle();

// TODO: 5/6/20 pendingIntent as NavDeepLinkBuilder for Navigation Components
            PendingIntent fullScreenPendingIntent = new NavDeepLinkBuilder(this)
                    .setGraph(R.navigation.nav_graph)
                    .setDestination(R.id.boatFragment)
                    .setArguments(args)
                    .createPendingIntent();

            NotificationCompat.Builder notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setContentTitle("New On Sale!")
                    .setOngoing(true)
                    .setPriority(Notification.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_CALL)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                    .setWhen(System.currentTimeMillis())
                    .setContentIntent(fullScreenPendingIntent);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                notification.setChannelId("channel 0");
            }

            mNotificationManager.notify(0,notification.build());
        }

    }
}