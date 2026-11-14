package g5;

import android.view.KeyEvent;
import h5.C1145a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final C1145a f16319a;

    public interface a {
        void a(boolean z7);
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final KeyEvent f16320a;

        /* renamed from: b, reason: collision with root package name */
        public final Character f16321b;

        public b(KeyEvent keyEvent, Character ch) {
            this.f16320a = keyEvent;
            this.f16321b = ch;
        }
    }

    public e(h5.b bVar) {
        this.f16319a = new C1145a(bVar, "flutter/keyevent", h5.e.f16893a);
    }

    public static /* synthetic */ void a(a aVar, Object obj) throws JSONException {
        boolean z7 = false;
        if (obj != null) {
            try {
                z7 = ((JSONObject) obj).getBoolean("handled");
            } catch (JSONException e7) {
                U4.b.b("KeyEventChannel", "Unable to unpack JSON message: " + e7);
            }
        }
        aVar.a(z7);
    }

    public static C1145a.e b(final a aVar) {
        return new C1145a.e() { // from class: g5.d
            @Override // h5.C1145a.e
            public final void a(Object obj) throws JSONException {
                e.a(aVar, obj);
            }
        };
    }

    public final Map c(b bVar, boolean z7) {
        HashMap map = new HashMap();
        map.put("type", z7 ? "keyup" : "keydown");
        map.put("keymap", "android");
        map.put("flags", Integer.valueOf(bVar.f16320a.getFlags()));
        map.put("plainCodePoint", Integer.valueOf(bVar.f16320a.getUnicodeChar(0)));
        map.put("codePoint", Integer.valueOf(bVar.f16320a.getUnicodeChar()));
        map.put("keyCode", Integer.valueOf(bVar.f16320a.getKeyCode()));
        map.put("scanCode", Integer.valueOf(bVar.f16320a.getScanCode()));
        map.put("metaState", Integer.valueOf(bVar.f16320a.getMetaState()));
        Character ch = bVar.f16321b;
        if (ch != null) {
            map.put("character", ch.toString());
        }
        map.put("source", Integer.valueOf(bVar.f16320a.getSource()));
        map.put("deviceId", Integer.valueOf(bVar.f16320a.getDeviceId()));
        map.put("repeatCount", Integer.valueOf(bVar.f16320a.getRepeatCount()));
        return map;
    }

    public void d(b bVar, boolean z7, a aVar) {
        this.f16319a.d(c(bVar, z7), b(aVar));
    }
}
