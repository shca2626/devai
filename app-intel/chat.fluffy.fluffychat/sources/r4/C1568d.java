package r4;

import M5.m;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import java.util.HashSet;
import java.util.Iterator;
import org.webrtc.MediaStreamTrack;
import y4.C1805a;
import z5.C1877k;
import z5.C1889w;

/* renamed from: r4.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1568d extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final Context f22160a;

    /* renamed from: b, reason: collision with root package name */
    public final IntentFilter f22161b;

    /* renamed from: c, reason: collision with root package name */
    public final AudioManager f22162c;

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC1569e f22163d;

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f22164e;

    /* renamed from: f, reason: collision with root package name */
    public AudioDeviceCallback f22165f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f22166g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f22167h;

    /* renamed from: r4.d$a */
    public static final class a extends AudioDeviceCallback {
        public a() {
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            m.e(audioDeviceInfoArr, "addedDevices");
            C1568d.this.f22164e.addAll(C1805a.f24000a.c(C1877k.d(audioDeviceInfoArr)));
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            m.e(audioDeviceInfoArr, "removedDevices");
            C1568d.this.f22164e.removeAll(C1889w.b0(C1805a.f24000a.c(C1877k.d(audioDeviceInfoArr))));
            HashSet hashSet = C1568d.this.f22164e;
            if (hashSet == null || !hashSet.isEmpty()) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    if (((AudioDeviceInfo) it.next()).getType() == 7) {
                        return;
                    }
                }
            }
            if (C1568d.this.f22162c.isBluetoothScoAvailableOffCall()) {
                C1568d.this.g();
            }
        }
    }

    public C1568d(Context context) {
        m.e(context, "context");
        this.f22160a = context;
        IntentFilter intentFilter = new IntentFilter();
        this.f22161b = intentFilter;
        Object systemService = context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        m.c(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.f22162c = (AudioManager) systemService;
        this.f22164e = new HashSet();
        intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
    }

    public final void d(InterfaceC1569e interfaceC1569e) {
        HashSet hashSet = this.f22164e;
        if (hashSet == null || !hashSet.isEmpty()) {
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((AudioDeviceInfo) it.next()).getType() == 7) {
                    if (this.f22162c.isBluetoothScoAvailableOffCall()) {
                        f(interfaceC1569e);
                        return;
                    }
                }
            }
        }
        interfaceC1569e.c();
    }

    public final void e(InterfaceC1569e interfaceC1569e) {
        m.e(interfaceC1569e, "listener");
        this.f22160a.registerReceiver(this, this.f22161b);
        this.f22166g = true;
        this.f22163d = interfaceC1569e;
        a aVar = new a();
        this.f22165f = aVar;
        this.f22162c.registerAudioDeviceCallback(aVar, null);
        HashSet hashSet = this.f22164e;
        C1805a.C0294a c0294a = C1805a.f24000a;
        AudioDeviceInfo[] devices = this.f22162c.getDevices(1);
        m.d(devices, "getDevices(...)");
        hashSet.addAll(c0294a.c(C1877k.d(devices)));
        d(interfaceC1569e);
    }

    public final void f(InterfaceC1569e interfaceC1569e) {
        if (this.f22162c.isBluetoothScoAvailableOffCall()) {
            if (Build.VERSION.SDK_INT < 31) {
                if (this.f22162c.isBluetoothScoOn()) {
                    return;
                }
                this.f22162c.startBluetoothSco();
                return;
            }
            for (AudioDeviceInfo audioDeviceInfo : this.f22162c.getAvailableCommunicationDevices()) {
                if (audioDeviceInfo.getType() == 7) {
                    this.f22162c.setCommunicationDevice(audioDeviceInfo);
                    this.f22167h = true;
                    if (interfaceC1569e != null) {
                        interfaceC1569e.a();
                        return;
                    }
                    return;
                }
            }
            this.f22167h = true;
            if (interfaceC1569e != null) {
                interfaceC1569e.c();
            }
        }
    }

    public final void g() {
        if (Build.VERSION.SDK_INT >= 31) {
            this.f22162c.clearCommunicationDevice();
        } else if (this.f22162c.isBluetoothScoOn()) {
            this.f22162c.stopBluetoothSco();
        }
    }

    public final void h() {
        g();
        AudioDeviceCallback audioDeviceCallback = this.f22165f;
        if (audioDeviceCallback != null) {
            this.f22162c.unregisterAudioDeviceCallback(audioDeviceCallback);
            this.f22165f = null;
        }
        this.f22163d = null;
        this.f22167h = false;
        if (this.f22166g) {
            this.f22160a.unregisterReceiver(this);
            this.f22166g = false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        m.e(context, "context");
        m.e(intent, "intent");
        int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
        if (intExtra == 0) {
            InterfaceC1569e interfaceC1569e = this.f22163d;
            if (interfaceC1569e != null) {
                interfaceC1569e.b();
                return;
            }
            return;
        }
        if (intExtra == 1 && !this.f22167h) {
            this.f22167h = true;
            InterfaceC1569e interfaceC1569e2 = this.f22163d;
            if (interfaceC1569e2 != null) {
                interfaceC1569e2.a();
            }
        }
    }
}
