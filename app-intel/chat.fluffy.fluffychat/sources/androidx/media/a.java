package androidx.media;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media.AudioAttributesCompat;
import z0.AbstractC1829a;

/* loaded from: classes.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    public static final AudioAttributesCompat f12482g = new AudioAttributesCompat.a().d(1).a();

    /* renamed from: a, reason: collision with root package name */
    public final int f12483a;

    /* renamed from: b, reason: collision with root package name */
    public final AudioManager.OnAudioFocusChangeListener f12484b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f12485c;

    /* renamed from: d, reason: collision with root package name */
    public final AudioAttributesCompat f12486d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f12487e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f12488f;

    /* renamed from: androidx.media.a$a, reason: collision with other inner class name */
    public static class C0111a {
        public static AudioFocusRequest a(int i7, AudioAttributes audioAttributes, boolean z7, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
            return new AudioFocusRequest.Builder(i7).setAudioAttributes(audioAttributes).setWillPauseWhenDucked(z7).setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler).build();
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f12489a;

        /* renamed from: b, reason: collision with root package name */
        public AudioManager.OnAudioFocusChangeListener f12490b;

        /* renamed from: c, reason: collision with root package name */
        public Handler f12491c;

        /* renamed from: d, reason: collision with root package name */
        public AudioAttributesCompat f12492d = a.f12482g;

        /* renamed from: e, reason: collision with root package name */
        public boolean f12493e;

        public b(int i7) {
            d(i7);
        }

        public static boolean b(int i7) {
            return i7 == 1 || i7 == 2 || i7 == 3 || i7 == 4;
        }

        public a a() {
            if (this.f12490b != null) {
                return new a(this.f12489a, this.f12490b, this.f12491c, this.f12492d, this.f12493e);
            }
            throw new IllegalStateException("Can't build an AudioFocusRequestCompat instance without a listener");
        }

        public b c(AudioAttributesCompat audioAttributesCompat) {
            if (audioAttributesCompat == null) {
                throw new NullPointerException("Illegal null AudioAttributes");
            }
            this.f12492d = audioAttributesCompat;
            return this;
        }

        public b d(int i7) {
            if (b(i7)) {
                this.f12489a = i7;
                return this;
            }
            throw new IllegalArgumentException("Illegal audio focus gain type " + i7);
        }

        public b e(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
            return f(onAudioFocusChangeListener, new Handler(Looper.getMainLooper()));
        }

        public b f(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
            if (onAudioFocusChangeListener == null) {
                throw new IllegalArgumentException("OnAudioFocusChangeListener must not be null");
            }
            if (handler == null) {
                throw new IllegalArgumentException("Handler must not be null");
            }
            this.f12490b = onAudioFocusChangeListener;
            this.f12491c = handler;
            return this;
        }

        public b g(boolean z7) {
            this.f12493e = z7;
            return this;
        }
    }

    public static class c implements Handler.Callback, AudioManager.OnAudioFocusChangeListener {

        /* renamed from: l, reason: collision with root package name */
        public final Handler f12494l;

        /* renamed from: m, reason: collision with root package name */
        public final AudioManager.OnAudioFocusChangeListener f12495m;

        public c(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
            this.f12495m = onAudioFocusChangeListener;
            this.f12494l = new Handler(handler.getLooper(), this);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 2782386) {
                return false;
            }
            this.f12495m.onAudioFocusChange(message.arg1);
            return true;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i7) {
            Handler handler = this.f12494l;
            handler.sendMessage(Message.obtain(handler, 2782386, i7, 0));
        }
    }

    public a(int i7, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler, AudioAttributesCompat audioAttributesCompat, boolean z7) {
        this.f12483a = i7;
        this.f12485c = handler;
        this.f12486d = audioAttributesCompat;
        this.f12487e = z7;
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 26 || handler.getLooper() == Looper.getMainLooper()) {
            this.f12484b = onAudioFocusChangeListener;
        } else {
            this.f12484b = new c(onAudioFocusChangeListener, handler);
        }
        if (i8 >= 26) {
            this.f12488f = C0111a.a(i7, a(), z7, this.f12484b, handler);
        } else {
            this.f12488f = null;
        }
    }

    public AudioAttributes a() {
        AudioAttributesCompat audioAttributesCompat = this.f12486d;
        if (audioAttributesCompat != null) {
            return (AudioAttributes) audioAttributesCompat.d();
        }
        return null;
    }

    public AudioAttributesCompat b() {
        return this.f12486d;
    }

    public AudioFocusRequest c() {
        return AbstractC1829a.a(this.f12488f);
    }

    public int d() {
        return this.f12483a;
    }

    public AudioManager.OnAudioFocusChangeListener e() {
        return this.f12484b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f12483a == aVar.f12483a && this.f12487e == aVar.f12487e && Y.c.a(this.f12484b, aVar.f12484b) && Y.c.a(this.f12485c, aVar.f12485c) && Y.c.a(this.f12486d, aVar.f12486d);
    }

    public int hashCode() {
        return Y.c.b(Integer.valueOf(this.f12483a), this.f12484b, this.f12485c, this.f12486d, Boolean.valueOf(this.f12487e));
    }
}
