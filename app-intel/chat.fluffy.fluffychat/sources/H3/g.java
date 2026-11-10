package H3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3416a = "g";

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f3417b = Pattern.compile(",");

    public static Map a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null || extras.isEmpty()) {
            return null;
        }
        EnumMap enumMap = new EnumMap(D3.e.class);
        for (D3.e eVar : D3.e.values()) {
            if (eVar != D3.e.CHARACTER_SET && eVar != D3.e.NEED_RESULT_POINT_CALLBACK && eVar != D3.e.POSSIBLE_FORMATS) {
                String strName = eVar.name();
                if (extras.containsKey(strName)) {
                    if (eVar.d().equals(Void.class)) {
                        enumMap.put((EnumMap) eVar, (D3.e) Boolean.TRUE);
                    } else {
                        Object obj = extras.get(strName);
                        if (eVar.d().isInstance(obj)) {
                            enumMap.put((EnumMap) eVar, (D3.e) obj);
                        } else {
                            Log.w(f3416a, "Ignoring hint " + eVar + " because it is not assignable from " + obj);
                        }
                    }
                }
            }
        }
        Log.i(f3416a, "Hints from the Intent: " + enumMap);
        return enumMap;
    }
}
