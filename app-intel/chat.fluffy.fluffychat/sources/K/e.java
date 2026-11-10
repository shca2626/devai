package K;

import android.app.AlarmManager;
import android.app.PendingIntent;

/* loaded from: classes.dex */
public abstract class e {
    public static void a(AlarmManager alarmManager, long j7, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(j7, pendingIntent), pendingIntent2);
    }

    public static void b(AlarmManager alarmManager, int i7, long j7, PendingIntent pendingIntent) {
        alarmManager.setAndAllowWhileIdle(i7, j7, pendingIntent);
    }

    public static void c(AlarmManager alarmManager, int i7, long j7, PendingIntent pendingIntent) {
        alarmManager.setExact(i7, j7, pendingIntent);
    }

    public static void d(AlarmManager alarmManager, int i7, long j7, PendingIntent pendingIntent) {
        alarmManager.setExactAndAllowWhileIdle(i7, j7, pendingIntent);
    }
}
