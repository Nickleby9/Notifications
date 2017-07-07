package hilay.edu.notifications;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;

public class NotificationService extends IntentService {


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * Service name Used to name the worker thread, important only for debugging.
     */
    public NotificationService() {
        super("NotificationService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Intent contentIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Service title")
                .setContentText("Service text.....")
                .setSmallIcon(R.drawable.ic_note)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);
        Notification notification = builder.build();




        NotificationManagerCompat nm = NotificationManagerCompat.from(this);
        nm.notify(1, notification);
    }
}
