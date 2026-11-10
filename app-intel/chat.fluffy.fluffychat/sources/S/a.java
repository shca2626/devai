package S;

import android.location.Location;
import android.location.LocationListener;
import java.util.List;

/* loaded from: classes.dex */
public interface a extends LocationListener {
    @Override // android.location.LocationListener
    default void onLocationChanged(List list) {
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            onLocationChanged((Location) list.get(i7));
        }
    }

    @Override // android.location.LocationListener
    default void onFlushComplete(int i7) {
    }
}
