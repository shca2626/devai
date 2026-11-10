package V4;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import g5.f;
import io.flutter.plugin.editing.l;
import java.util.HashSet;
import java.util.Map;

/* loaded from: classes.dex */
public class P implements l.a, f.b {

    /* renamed from: a, reason: collision with root package name */
    public final d[] f8710a;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f8711b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    public final e f8712c;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f8713a = 0;

        public Character a(int i7) {
            char c7 = (char) i7;
            if ((Integer.MIN_VALUE & i7) != 0) {
                int i8 = i7 & Integer.MAX_VALUE;
                int i9 = this.f8713a;
                if (i9 != 0) {
                    this.f8713a = KeyCharacterMap.getDeadChar(i9, i8);
                } else {
                    this.f8713a = i8;
                }
            } else {
                int i10 = this.f8713a;
                if (i10 != 0) {
                    int deadChar = KeyCharacterMap.getDeadChar(i10, i7);
                    if (deadChar > 0) {
                        c7 = (char) deadChar;
                    }
                    this.f8713a = 0;
                }
            }
            return Character.valueOf(c7);
        }
    }

    public class c {

        /* renamed from: a, reason: collision with root package name */
        public final KeyEvent f8714a;

        /* renamed from: b, reason: collision with root package name */
        public int f8715b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f8716c = false;

        public class a implements d.a {

            /* renamed from: a, reason: collision with root package name */
            public boolean f8718a;

            public a() {
                this.f8718a = false;
            }

            @Override // V4.P.d.a
            public void a(boolean z7) {
                if (this.f8718a) {
                    throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
                }
                this.f8718a = true;
                c cVar = c.this;
                int i7 = cVar.f8715b - 1;
                cVar.f8715b = i7;
                boolean z8 = z7 | cVar.f8716c;
                cVar.f8716c = z8;
                if (i7 != 0 || z8) {
                    return;
                }
                P.this.e(cVar.f8714a);
            }
        }

        public c(KeyEvent keyEvent) {
            this.f8715b = P.this.f8710a.length;
            this.f8714a = keyEvent;
        }

        public d.a a() {
            return new a();
        }
    }

    public interface d {

        public interface a {
            void a(boolean z7);
        }

        void a(KeyEvent keyEvent, a aVar);
    }

    public interface e {
        void b(KeyEvent keyEvent);

        boolean c(KeyEvent keyEvent);

        h5.b getBinaryMessenger();
    }

    public P(e eVar) {
        this.f8712c = eVar;
        this.f8710a = new d[]{new O(eVar.getBinaryMessenger()), new J(new g5.e(eVar.getBinaryMessenger()))};
        new g5.f(eVar.getBinaryMessenger()).b(this);
    }

    @Override // io.flutter.plugin.editing.l.a
    public boolean a(KeyEvent keyEvent) {
        if (this.f8711b.remove(keyEvent)) {
            return false;
        }
        if (this.f8710a.length <= 0) {
            e(keyEvent);
            return true;
        }
        c cVar = new c(keyEvent);
        for (d dVar : this.f8710a) {
            dVar.a(keyEvent, cVar.a());
        }
        return true;
    }

    @Override // g5.f.b
    public Map b() {
        return ((O) this.f8710a[0]).h();
    }

    public void d() {
        int size = this.f8711b.size();
        if (size > 0) {
            U4.b.g("KeyboardManager", "A KeyboardManager was destroyed with " + size + " unhandled redispatch event(s).");
        }
    }

    public final void e(KeyEvent keyEvent) {
        e eVar = this.f8712c;
        if (eVar == null || eVar.c(keyEvent)) {
            return;
        }
        this.f8711b.add(keyEvent);
        this.f8712c.b(keyEvent);
        if (this.f8711b.remove(keyEvent)) {
            U4.b.g("KeyboardManager", "A redispatched key event was consumed before reaching KeyboardManager");
        }
    }
}
