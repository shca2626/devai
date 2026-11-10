package F2;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class y {
    public static Double a(Bundle bundle, String... strArr) {
        if (bundle == null) {
            return null;
        }
        for (String str : strArr) {
            if (bundle.containsKey(str)) {
                Object obj = bundle.get(str);
                if (obj instanceof Number) {
                    double dDoubleValue = ((Number) obj).doubleValue();
                    if (!Double.isNaN(dDoubleValue) && !Double.isInfinite(dDoubleValue)) {
                        return Double.valueOf(dDoubleValue);
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public static boolean b(Location location) {
        return Build.VERSION.SDK_INT >= 31 ? location.isMock() : location.isFromMockProvider();
    }

    public static Map c(Location location) {
        if (location == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("latitude", Double.valueOf(location.getLatitude()));
        map.put("longitude", Double.valueOf(location.getLongitude()));
        map.put("timestamp", Long.valueOf(location.getTime()));
        map.put("is_mocked", Boolean.valueOf(b(location)));
        if (location.hasAltitude()) {
            map.put("altitude", Double.valueOf(location.getAltitude()));
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 26 && location.hasVerticalAccuracy()) {
            map.put("altitude_accuracy", Float.valueOf(location.getVerticalAccuracyMeters()));
        }
        if (location.hasAccuracy()) {
            map.put("accuracy", Double.valueOf(location.getAccuracy()));
        }
        if (location.hasBearing()) {
            map.put("heading", Double.valueOf(location.getBearing()));
        }
        if (i7 >= 26 && location.hasBearingAccuracy()) {
            map.put("heading_accuracy", Float.valueOf(location.getBearingAccuracyDegrees()));
        }
        if (location.hasSpeed()) {
            map.put("speed", Double.valueOf(location.getSpeed()));
        }
        if (i7 >= 26 && location.hasSpeedAccuracy()) {
            map.put("speed_accuracy", Double.valueOf(location.getSpeedAccuracyMetersPerSecond()));
        }
        if (location.getExtras() != null) {
            if (location.getExtras().containsKey("geolocator_mslAltitude")) {
                map.put("altitude", Double.valueOf(location.getExtras().getDouble("geolocator_mslAltitude")));
            }
            if (location.getExtras().containsKey("geolocator_mslSatelliteCount")) {
                map.put("gnss_satellite_count", Double.valueOf(location.getExtras().getDouble("geolocator_mslSatelliteCount")));
            }
            if (location.getExtras().containsKey("geolocator_mslSatellitesUsedInFix")) {
                map.put("gnss_satellites_used_in_fix", Double.valueOf(location.getExtras().getDouble("geolocator_mslSatellitesUsedInFix")));
            }
            if (i7 >= 34 && location.hasMslAltitude()) {
                map.put("altitude", Double.valueOf(location.getMslAltitudeMeters()));
                if (location.hasMslAltitudeAccuracy()) {
                    map.put("altitude_accuracy", Float.valueOf(location.getMslAltitudeAccuracyMeters()));
                }
            }
            Double dA = a(location.getExtras(), "geolocator_verticalSpeed", "vertical_speed", "verticalSpeed", "vVel");
            if (dA != null) {
                map.put("vertical_speed", dA);
            }
            Double dA2 = a(location.getExtras(), "geolocator_verticalSpeedAccuracy", "vertical_speed_accuracy", "verticalSpeedAccuracy");
            if (dA2 != null && dA2.doubleValue() >= 0.0d) {
                map.put("vertical_speed_accuracy", dA2);
            }
        }
        return map;
    }
}
