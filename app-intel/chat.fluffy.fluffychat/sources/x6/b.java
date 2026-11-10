package x6;

import M5.g;
import M5.m;
import android.R;
import android.app.Activity;
import android.content.ClipData;
import android.net.Uri;
import android.util.Log;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import c5.InterfaceC0910a;
import d5.InterfaceC0998a;
import d5.InterfaceC1000c;
import h5.i;
import h5.j;
import java.util.ArrayList;
import z5.C1881o;

/* loaded from: classes3.dex */
public final class b implements InterfaceC0910a, j.c, InterfaceC0998a {

    /* renamed from: p, reason: collision with root package name */
    public static final a f23771p = new a(null);

    /* renamed from: l, reason: collision with root package name */
    public j f23772l;

    /* renamed from: m, reason: collision with root package name */
    public View f23773m;

    /* renamed from: n, reason: collision with root package name */
    public Activity f23774n;

    /* renamed from: o, reason: collision with root package name */
    public final View.OnDragListener f23775o = new View.OnDragListener() { // from class: x6.a
        @Override // android.view.View.OnDragListener
        public final boolean onDrag(View view, DragEvent dragEvent) {
            return b.b(this.f23770a, view, dragEvent);
        }
    };

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        public a() {
        }
    }

    public static final boolean b(b bVar, View view, DragEvent dragEvent) {
        j jVar = bVar.f23772l;
        if (jVar == null) {
            return false;
        }
        int action = dragEvent.getAction();
        if (action == 2) {
            jVar.c("updated", C1881o.l(Float.valueOf(dragEvent.getX()), Float.valueOf(dragEvent.getY())));
            return true;
        }
        if (action == 3) {
            m.b(dragEvent);
            Activity activity = bVar.f23774n;
            m.b(activity);
            bVar.c(dragEvent, jVar, activity);
            return true;
        }
        if (action == 5) {
            jVar.c("entered", C1881o.l(Float.valueOf(dragEvent.getX()), Float.valueOf(dragEvent.getY())));
            return true;
        }
        if (action != 6) {
            return true;
        }
        jVar.c("exited", null);
        return true;
    }

    public final void c(DragEvent dragEvent, j jVar, Activity activity) {
        Uri uri;
        DragAndDropPermissions dragAndDropPermissionsRequestDragAndDropPermissions = activity.requestDragAndDropPermissions(dragEvent);
        if (dragAndDropPermissionsRequestDragAndDropPermissions == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int itemCount = dragEvent.getClipData().getItemCount();
        for (int i7 = 0; i7 < itemCount; i7++) {
            ClipData.Item itemAt = dragEvent.getClipData().getItemAt(i7);
            if (itemAt != null && (uri = itemAt.getUri()) != null) {
                String string = uri.toString();
                m.d(string, "toString(...)");
                arrayList.add(string);
            }
        }
        dragAndDropPermissionsRequestDragAndDropPermissions.release();
        jVar.c("performOperation", arrayList);
    }

    @Override // d5.InterfaceC0998a
    public void onAttachedToActivity(InterfaceC1000c interfaceC1000c) {
        m.e(interfaceC1000c, "binding");
        ViewGroup viewGroup = (ViewGroup) interfaceC1000c.getActivity().findViewById(R.id.content);
        if (viewGroup == null) {
            Log.e("DesktopDropPlugin", "onAttachedToActivity: can not find android.R.id.content");
            return;
        }
        viewGroup.setOnDragListener(this.f23775o);
        this.f23773m = viewGroup;
        this.f23774n = interfaceC1000c.getActivity();
    }

    @Override // c5.InterfaceC0910a
    public void onAttachedToEngine(InterfaceC0910a.b bVar) {
        m.e(bVar, "flutterPluginBinding");
        j jVar = new j(bVar.b(), "desktop_drop");
        this.f23772l = jVar;
        jVar.e(this);
    }

    @Override // d5.InterfaceC0998a
    public void onDetachedFromActivity() {
        View view = this.f23773m;
        if (view != null) {
            view.setOnDragListener(null);
        }
        this.f23774n = null;
    }

    @Override // c5.InterfaceC0910a
    public void onDetachedFromEngine(InterfaceC0910a.b bVar) {
        m.e(bVar, "binding");
        j jVar = this.f23772l;
        if (jVar != null) {
            jVar.e(null);
        }
    }

    @Override // h5.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        m.e(iVar, "call");
        m.e(dVar, "result");
        dVar.notImplemented();
    }

    @Override // d5.InterfaceC0998a
    public void onReattachedToActivityForConfigChanges(InterfaceC1000c interfaceC1000c) {
        m.e(interfaceC1000c, "binding");
    }

    @Override // d5.InterfaceC0998a
    public void onDetachedFromActivityForConfigChanges() {
    }
}
