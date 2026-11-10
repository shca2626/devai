package I4;

import M5.m;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4275a;

    /* renamed from: b, reason: collision with root package name */
    public final J4.b f4276b;

    /* renamed from: c, reason: collision with root package name */
    public final AudioManager f4277c;

    /* renamed from: d, reason: collision with root package name */
    public final J4.a f4278d;

    /* renamed from: e, reason: collision with root package name */
    public final e f4279e;

    /* renamed from: f, reason: collision with root package name */
    public final AudioManager.OnAudioFocusChangeListener f4280f;

    /* renamed from: g, reason: collision with root package name */
    public int f4281g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4282h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4283i;

    /* renamed from: j, reason: collision with root package name */
    public AudioFocusRequest f4284j;

    /* renamed from: k, reason: collision with root package name */
    public int f4285k;

    /* renamed from: l, reason: collision with root package name */
    public int f4286l;

    /* renamed from: m, reason: collision with root package name */
    public int f4287m;

    /* renamed from: n, reason: collision with root package name */
    public int f4288n;

    /* renamed from: o, reason: collision with root package name */
    public int f4289o;

    public c(Context context, J4.b bVar, AudioManager audioManager, J4.a aVar, e eVar, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        m.e(context, "context");
        m.e(bVar, "logger");
        m.e(audioManager, "audioManager");
        m.e(aVar, JsonPOJOBuilder.DEFAULT_BUILD_METHOD);
        m.e(eVar, "audioFocusRequest");
        m.e(onAudioFocusChangeListener, "audioFocusChangeListener");
        this.f4275a = context;
        this.f4276b = bVar;
        this.f4277c = audioManager;
        this.f4278d = aVar;
        this.f4279e = eVar;
        this.f4280f = onAudioFocusChangeListener;
        this.f4285k = 3;
        this.f4286l = 2;
        this.f4288n = 2;
        this.f4289o = 1;
    }

    public final void a() {
        this.f4281g = this.f4277c.getMode();
        this.f4282h = this.f4277c.isMicrophoneMute();
        this.f4283i = this.f4277c.isSpeakerphoneOn();
    }

    public final void b() {
        this.f4277c.clearCommunicationDevice();
    }

    public final void c(boolean z7) {
        AudioManager audioManager = this.f4277c;
        if (z7) {
            audioManager.startBluetoothSco();
        } else {
            audioManager.stopBluetoothSco();
        }
    }

    public final void d(boolean z7) {
        this.f4277c.setSpeakerphoneOn(z7);
    }

    public final int e() {
        return this.f4285k;
    }

    public final boolean f() {
        boolean zHasSystemFeature = this.f4275a.getPackageManager().hasSystemFeature("android.hardware.telephony");
        if (zHasSystemFeature) {
            this.f4276b.b("AudioDeviceManager", "Earpiece available");
        }
        return zHasSystemFeature;
    }

    public final void g(boolean z7) {
        this.f4277c.setMicrophoneMute(z7);
    }

    public final void h() {
        this.f4277c.setMode(this.f4281g);
        g(this.f4282h);
        d(this.f4283i);
        if (this.f4278d.a() < 26) {
            this.f4277c.abandonAudioFocus(this.f4280f);
            return;
        }
        AudioFocusRequest audioFocusRequest = this.f4284j;
        if (audioFocusRequest != null) {
            this.f4277c.abandonAudioFocusRequest(audioFocusRequest);
        }
        this.f4284j = null;
    }

    public final void i(int i7) {
        this.f4289o = i7;
    }

    public final void j(int i7) {
        this.f4288n = i7;
    }

    public final void k() {
        if (this.f4278d.a() >= 26) {
            AudioFocusRequest audioFocusRequestA = this.f4279e.a(this.f4280f, this.f4286l, this.f4288n, this.f4289o);
            this.f4284j = audioFocusRequestA;
            if (audioFocusRequestA != null) {
                this.f4277c.requestAudioFocus(audioFocusRequestA);
            }
        } else {
            this.f4277c.requestAudioFocus(this.f4280f, this.f4287m, this.f4286l);
        }
        this.f4277c.setMode(this.f4285k);
    }

    public final void l(int i7) {
        this.f4285k = i7;
    }

    public final void m(int i7) {
        this.f4287m = i7;
    }

    public final boolean n(AudioDeviceInfo audioDeviceInfo) {
        m.e(audioDeviceInfo, "device");
        return this.f4277c.setCommunicationDevice(audioDeviceInfo);
    }

    public final void o(int i7) {
        this.f4286l = i7;
    }

    public /* synthetic */ c(Context context, J4.b bVar, AudioManager audioManager, J4.a aVar, e eVar, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, int i7, M5.g gVar) {
        this(context, bVar, audioManager, (i7 & 8) != 0 ? new J4.a() : aVar, (i7 & 16) != 0 ? new e() : eVar, onAudioFocusChangeListener);
    }
}
