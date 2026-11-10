package C0;

import E0.AbstractC0315a;
import E0.AbstractC0332s;
import E0.C0324j;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Looper;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static AudioManager f1248a;

    /* renamed from: b, reason: collision with root package name */
    public static Context f1249b;

    public static /* synthetic */ void a(Context context, C0324j c0324j) {
        f1248a = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        c0324j.f();
    }

    public static int b(AudioManager audioManager, m mVar) {
        return Build.VERSION.SDK_INT >= 26 ? audioManager.abandonAudioFocusRequest(mVar.c()) : audioManager.abandonAudioFocus(mVar.f());
    }

    public static synchronized AudioManager c(Context context) {
        try {
            final Context applicationContext = context.getApplicationContext();
            if (f1249b != applicationContext) {
                f1248a = null;
            }
            AudioManager audioManager = f1248a;
            if (audioManager != null) {
                return audioManager;
            }
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper != null && looperMyLooper != Looper.getMainLooper()) {
                final C0324j c0324j = new C0324j();
                AbstractC0315a.a().execute(new Runnable() { // from class: C0.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.a(applicationContext, c0324j);
                    }
                });
                c0324j.b();
                return (AudioManager) j3.o.q(f1248a);
            }
            AudioManager audioManager2 = (AudioManager) applicationContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            f1248a = audioManager2;
            return (AudioManager) j3.o.q(audioManager2);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static int d(AudioManager audioManager, int i7) {
        return audioManager.getStreamMaxVolume(i7);
    }

    public static int e(AudioManager audioManager, int i7) {
        if (Build.VERSION.SDK_INT >= 28) {
            return audioManager.getStreamMinVolume(i7);
        }
        return 0;
    }

    public static int f(AudioManager audioManager, int i7) {
        try {
            return audioManager.getStreamVolume(i7);
        } catch (RuntimeException e7) {
            AbstractC0332s.i("AudioManagerCompat", "Could not retrieve stream volume for stream type " + i7, e7);
            return audioManager.getStreamMaxVolume(i7);
        }
    }

    public static boolean g(AudioManager audioManager, int i7) {
        return audioManager.isStreamMute(i7);
    }

    public static int h(AudioManager audioManager, m mVar) {
        return Build.VERSION.SDK_INT >= 26 ? audioManager.requestAudioFocus(mVar.c()) : audioManager.requestAudioFocus(mVar.f(), mVar.b().b(), mVar.e());
    }
}
