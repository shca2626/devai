package T4;

import K.u;
import M.C0521s;
import M.d0;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import h5.i;
import h5.j;
import j$.util.Base64;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.webrtc.PeerConnection;

/* loaded from: classes.dex */
public class c implements j.c {

    /* renamed from: o, reason: collision with root package name */
    public static final String f8282o = a.a();

    /* renamed from: l, reason: collision with root package name */
    public final Context f8283l;

    /* renamed from: m, reason: collision with root package name */
    public Activity f8284m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8285n;

    public c(Context context, Activity activity) {
        this.f8283l = context;
        this.f8284m = activity;
    }

    public final C0521s.b a(String str, String str2, String str3, String str4, String str5, int i7) {
        C0521s.b bVar = new C0521s.b(this.f8283l, str);
        if (str3 != null) {
            bVar.c(g(str3));
        }
        if (str5 != null) {
            bVar.e(str5);
        }
        if (str2 != null) {
            p(i7, str2, bVar);
        }
        if (str4 != null) {
            bVar.i(str4);
        }
        return bVar;
    }

    public final void b(i iVar) {
        try {
            List list = (List) iVar.b();
            String str = (String) list.get(0);
            IconCompat iconCompatD = IconCompat.d(this.f8283l, d(this.f8283l, (String) list.get(1)));
            List<C0521s> listD = d0.d(this.f8283l);
            ArrayList arrayList = new ArrayList();
            boolean z7 = true;
            for (C0521s c0521s : listD) {
                String strB = c0521s.b();
                if (strB.equals(str)) {
                    try {
                        C0521s.b bVarA = a(strB, null, null, (String) c0521s.i(), (String) c0521s.f(), 0);
                        bVarA.b(iconCompatD).c(c0521s.c());
                        arrayList.add(bVarA.a());
                        z7 = false;
                    } catch (Exception e7) {
                        e = e7;
                        Log.e(f8282o, e.toString());
                        return;
                    }
                } else {
                    arrayList.add(c0521s);
                }
            }
            if (z7) {
                Log.e(f8282o, "ID did not match any shortcut");
                return;
            }
            try {
                d0.q(this.f8283l, arrayList);
                c("Shortcut Icon Changed.");
            } catch (Exception e8) {
                Log.e(f8282o, e8.toString());
            }
        } catch (Exception e9) {
            e = e9;
        }
    }

    public void c(String str) {
        if (this.f8285n) {
            Log.d(f8282o, str);
        }
    }

    public final Icon d(Context context, String str) throws IOException {
        AssetFileDescriptor assetFileDescriptorOpenFd;
        Bitmap bitmapDecodeStream = null;
        try {
            assetFileDescriptorOpenFd = context.getAssets().openFd(U4.a.e().c().k(str));
        } catch (IOException e7) {
            e7.printStackTrace();
            assetFileDescriptorOpenFd = null;
        }
        try {
            bitmapDecodeStream = BitmapFactory.decodeStream(assetFileDescriptorOpenFd.createInputStream());
        } catch (IOException e8) {
            e8.printStackTrace();
        }
        return Icon.createWithAdaptiveBitmap(bitmapDecodeStream);
    }

    public final Icon e(Context context, String str) {
        try {
            byte[] bArrDecode = Base64.getDecoder().decode(str);
            return Icon.createWithAdaptiveBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        } catch (Exception e7) {
            e7.printStackTrace();
            return null;
        }
    }

    public final Map f() {
        HashMap map = new HashMap();
        map.put("maxHeight", Integer.valueOf(d0.f(this.f8283l)));
        map.put("maxWidth", Integer.valueOf(d0.g(this.f8283l)));
        return map;
    }

    public final Intent g(String str) {
        return this.f8283l.getPackageManager().getLaunchIntentForPackage(this.f8283l.getPackageName()).setAction("android.intent.action.RUN").putExtra("flutter_shortcuts_new", str).addFlags(268435456).addFlags(PeerConnection.PORTALLOCATOR_ENABLE_ANY_ADDRESS_PORTS);
    }

    public final void h(j.d dVar) {
        Activity activity = this.f8284m;
        if (activity == null) {
            dVar.error("flutter_shortcuts_new_no_activity", "There is no activity available when launching action", null);
            return;
        }
        Intent intent = activity.getIntent();
        String stringExtra = intent.getStringExtra("flutter_shortcuts_new");
        if (stringExtra != null && !stringExtra.isEmpty()) {
            d0.o(this.f8283l, stringExtra);
            intent.removeExtra("flutter_shortcuts_new");
        }
        dVar.success(stringExtra);
        c("Launch Action: " + stringExtra);
    }

    public final int i() {
        return d0.h(this.f8283l);
    }

    public final void j(i iVar) {
        this.f8285n = Boolean.parseBoolean((String) ((Map) ((List) iVar.b()).get(0)).get("debug"));
        c("Flutter Shortcuts Initialized");
    }

    public final int k(Context context, String str) {
        if (str == null) {
            return 0;
        }
        String packageName = context.getPackageName();
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(str, "drawable", packageName);
        return identifier == 0 ? resources.getIdentifier(str, "mipmap", packageName) : identifier;
    }

    public final void l(i iVar) {
        try {
            d0.l(this.f8283l, (C0521s) x((List) iVar.b()).get(0));
            c("Shortcut pushed");
        } catch (Exception e7) {
            Log.e(f8282o, e7.toString());
        }
    }

    public final void m(i iVar) {
        try {
            d0.a(this.f8283l, x((List) iVar.b()));
            c("Shortcuts pushed");
        } catch (Exception e7) {
            Log.e(f8282o, e7.toString());
        }
    }

    public void n(Activity activity) {
        this.f8284m = activity;
    }

    public final void o(int i7, String str, u.c cVar) {
        if (i7 == 0) {
            u(cVar, str);
        } else if (i7 == 1) {
            s(cVar, str);
        } else {
            if (i7 != 2) {
                return;
            }
            q(cVar, str);
        }
    }

    @Override // h5.j.c
    public void onMethodCall(i iVar, j.d dVar) throws NumberFormatException {
        if (Build.VERSION.SDK_INT < 25) {
            dVar.success(null);
        }
        String str = iVar.f16895a;
        str.getClass();
        switch (str) {
            case "getLaunchAction":
                h(dVar);
                break;
            case "pushShortcutItems":
                m(iVar);
                break;
            case "getMaxShortcutLimit":
                dVar.success(Integer.valueOf(i()));
                break;
            case "clearShortcutItems":
                d0.m(this.f8283l);
                c("Removed all shortcuts.");
                break;
            case "updateShortcutItems":
                z(iVar);
                break;
            case "updateShortcutItem":
                y(iVar);
                break;
            case "changeShortcutItemIcon":
                b(iVar);
                break;
            case "initialize":
                j(iVar);
                break;
            case "setShortcutItems":
                w(iVar);
                break;
            case "getIconProperties":
                dVar.success(f());
                break;
            case "pushShortcutItem":
                l(iVar);
                dVar.success(null);
                break;
            default:
                dVar.notImplemented();
                break;
        }
    }

    public final void p(int i7, String str, C0521s.b bVar) {
        if (i7 == 0) {
            v(bVar, str);
        } else if (i7 == 1) {
            t(bVar, str);
        } else {
            if (i7 != 2) {
                return;
            }
            r(bVar, str);
        }
    }

    public final void q(u.c cVar, String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            Context context = this.f8283l;
            cVar.c(IconCompat.d(context, e(context, str)));
        }
    }

    public final void r(C0521s.b bVar, String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            Context context = this.f8283l;
            bVar.b(IconCompat.d(context, e(context, str)));
        }
    }

    public final void s(u.c cVar, String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            Context context = this.f8283l;
            cVar.c(IconCompat.d(context, d(context, str)));
        }
    }

    public final void t(C0521s.b bVar, String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            Context context = this.f8283l;
            bVar.b(IconCompat.d(context, d(context, str)));
        }
    }

    public final void u(u.c cVar, String str) {
        int iK = k(this.f8283l, str);
        if (iK <= 0 || Build.VERSION.SDK_INT < 25) {
            return;
        }
        Context context = this.f8283l;
        cVar.c(IconCompat.d(context, Icon.createWithResource(context, iK)));
    }

    public final void v(C0521s.b bVar, String str) {
        int iK = k(this.f8283l, str);
        if (iK <= 0 || Build.VERSION.SDK_INT < 25) {
            return;
        }
        Context context = this.f8283l;
        bVar.b(IconCompat.d(context, Icon.createWithResource(context, iK)));
    }

    public final void w(i iVar) {
        try {
            d0.p(this.f8283l, x((List) iVar.b()));
            c("Shortcuts created");
        } catch (Exception e7) {
            Log.e(f8282o, e7.toString());
        }
    }

    public final List x(List list) throws NumberFormatException {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            String str = (String) map.get("id");
            String str2 = (String) map.get("icon");
            String str3 = (String) map.get("action");
            String str4 = (String) map.get("shortLabel");
            String str5 = (String) map.get("LongLabel");
            boolean zBooleanValue = ((Boolean) map.get("isImportant")).booleanValue();
            boolean zBooleanValue2 = ((Boolean) map.get("isBot")).booleanValue();
            boolean zBooleanValue3 = ((Boolean) map.get("conversationShortcut")).booleanValue();
            String str6 = (String) map.get("shortcutIconType");
            Objects.requireNonNull(str6);
            int i7 = Integer.parseInt(str6);
            C0521s.b bVarA = a(str, str2, str3, str4, str5, i7);
            if (zBooleanValue3) {
                u.c cVarB = new u.c().e(str).f(str4).d(zBooleanValue).b(zBooleanValue2);
                o(i7, str2, cVarB);
                bVarA.f(true).g(cVarB.a());
            }
            arrayList.add(bVarA.a());
        }
        return arrayList;
    }

    public final void y(i iVar) throws NumberFormatException {
        Map map = (Map) ((List) iVar.b()).get(0);
        String str = (String) map.get("id");
        String str2 = (String) map.get("icon");
        String str3 = (String) map.get("action");
        String str4 = (String) map.get("shortLabel");
        String str5 = (String) map.get("LongLabel");
        String str6 = (String) map.get("shortcutIconType");
        Objects.requireNonNull(str6);
        int i7 = Integer.parseInt(str6);
        boolean zBooleanValue = ((Boolean) map.get("isImportant")).booleanValue();
        boolean zBooleanValue2 = ((Boolean) map.get("isBot")).booleanValue();
        boolean zBooleanValue3 = ((Boolean) map.get("conversationShortcut")).booleanValue();
        List<C0521s> listD = d0.d(this.f8283l);
        ArrayList arrayList = new ArrayList();
        boolean z7 = true;
        for (C0521s c0521s : listD) {
            if (c0521s.b().equals(str)) {
                C0521s.b bVarA = a(str, str2, str3, str4, str5, i7);
                if (zBooleanValue3) {
                    u.c cVarB = new u.c().e(str).f(str4).d(zBooleanValue).b(zBooleanValue2);
                    o(i7, str2, cVarB);
                    bVarA.f(true).g(cVarB.a());
                }
                arrayList.add(bVarA.a());
                z7 = false;
            } else {
                arrayList.add(c0521s);
            }
        }
        if (z7) {
            Log.e(f8282o, "ID did not match any shortcut");
            return;
        }
        try {
            d0.q(this.f8283l, arrayList);
            c("Shortcut updated");
        } catch (Exception e7) {
            Log.e(f8282o, e7.toString());
        }
    }

    public final void z(i iVar) {
        boolean zQ;
        try {
            zQ = d0.q(this.f8283l, x((List) iVar.b()));
        } catch (Exception e7) {
            Log.e(f8282o, e7.toString());
            zQ = false;
        }
        if (zQ) {
            c("Shortcuts updated");
        } else {
            c("Unable to update shortcuts");
        }
    }
}
