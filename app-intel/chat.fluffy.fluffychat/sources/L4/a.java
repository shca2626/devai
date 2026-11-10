package L4;

import I4.b;
import L4.h;
import M5.m;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Set;
import y5.C1811f;
import z5.C1889w;

/* loaded from: classes.dex */
public final class a extends AudioDeviceCallback implements h {

    /* renamed from: a, reason: collision with root package name */
    public final AudioManager f5477a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f5478b;

    /* renamed from: c, reason: collision with root package name */
    public h.a f5479c;

    public a(AudioManager audioManager, Handler handler) {
        m.e(audioManager, "audioManager");
        m.e(handler, "handler");
        this.f5477a = audioManager;
        this.f5478b = handler;
    }

    @Override // L4.h
    public boolean a(h.a aVar) {
        m.e(aVar, "listener");
        this.f5479c = aVar;
        this.f5477a.registerAudioDeviceCallback(this, this.f5478b);
        return true;
    }

    @Override // L4.h
    public boolean b(I4.b bVar) {
        m.e(bVar, "audioDevice");
        AudioDeviceInfo[] devices = this.f5477a.getDevices(2);
        m.d(devices, "getDevices(...)");
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            m.b(audioDeviceInfo);
            if (d(audioDeviceInfo, bVar)) {
                return true;
            }
        }
        return false;
    }

    public final I4.b c(AudioDeviceInfo audioDeviceInfo) {
        m.e(audioDeviceInfo, "<this>");
        if (audioDeviceInfo.getType() == 7 || audioDeviceInfo.getType() == 8) {
            return new b.a(audioDeviceInfo.getProductName().toString());
        }
        if (Build.VERSION.SDK_INT >= 31 && (audioDeviceInfo.getType() == 26 || audioDeviceInfo.getType() == 27)) {
            return new b.a(audioDeviceInfo.getProductName().toString());
        }
        if (audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 22) {
            return new b.d(null, 1, null);
        }
        if (audioDeviceInfo.getType() == 1) {
            return new b.C0041b(null, 1, null);
        }
        if (audioDeviceInfo.getType() == 2) {
            return new b.c(null, 1, null);
        }
        return null;
    }

    public final boolean d(AudioDeviceInfo audioDeviceInfo, I4.b bVar) {
        m.e(audioDeviceInfo, "<this>");
        m.e(bVar, "audioDevice");
        if (bVar instanceof b.a) {
            if (audioDeviceInfo.getType() == 7 || audioDeviceInfo.getType() == 8) {
                return true;
            }
            return Build.VERSION.SDK_INT >= 31 && (audioDeviceInfo.getType() == 26 || audioDeviceInfo.getType() == 27);
        }
        if (bVar instanceof b.C0041b) {
            return audioDeviceInfo.getType() == 1;
        }
        if (bVar instanceof b.c) {
            return audioDeviceInfo.getType() == 2;
        }
        if (!(bVar instanceof b.d)) {
            throw new C1811f();
        }
        if (audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 4) {
            return true;
        }
        return Build.VERSION.SDK_INT >= 26 && audioDeviceInfo.getType() == 22;
    }

    @Override // android.media.AudioDeviceCallback
    public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        super.onAudioDevicesAdded(audioDeviceInfoArr);
        if (audioDeviceInfoArr != null) {
            ArrayList arrayList = new ArrayList();
            for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                I4.b bVarC = c(audioDeviceInfo);
                if (bVarC != null) {
                    arrayList.add(bVarC);
                }
            }
            Set<I4.b> setB0 = C1889w.b0(arrayList);
            if (setB0 != null) {
                for (I4.b bVar : setB0) {
                    h.a aVar = this.f5479c;
                    if (aVar != null) {
                        aVar.b(bVar);
                    }
                }
            }
        }
    }

    @Override // android.media.AudioDeviceCallback
    public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        super.onAudioDevicesRemoved(audioDeviceInfoArr);
        if (audioDeviceInfoArr != null) {
            ArrayList arrayList = new ArrayList();
            for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                I4.b bVarC = c(audioDeviceInfo);
                if (bVarC != null) {
                    arrayList.add(bVarC);
                }
            }
            Set<I4.b> setB0 = C1889w.b0(arrayList);
            if (setB0 != null) {
                for (I4.b bVar : setB0) {
                    h.a aVar = this.f5479c;
                    if (aVar != null) {
                        aVar.a(bVar);
                    }
                }
            }
        }
    }

    @Override // L4.h
    public boolean stop() {
        this.f5477a.unregisterAudioDeviceCallback(this);
        this.f5479c = null;
        return true;
    }
}
