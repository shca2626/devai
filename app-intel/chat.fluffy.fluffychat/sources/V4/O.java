package V4;

import V4.K;
import V4.P;
import V4.Q;
import android.view.KeyEvent;
import h5.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class O implements P.d {

    /* renamed from: a, reason: collision with root package name */
    public final h5.b f8705a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f8706b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f8707c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final P.b f8708d = new P.b();

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8709a;

        static {
            int[] iArr = new int[K.b.values().length];
            f8709a = iArr;
            try {
                iArr[K.b.kDown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8709a[K.b.kUp.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8709a[K.b.kRepeat.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public O(h5.b bVar) {
        this.f8705a = bVar;
        for (Q.e eVar : Q.a()) {
            this.f8707c.put(Long.valueOf(eVar.f8729c), eVar);
        }
    }

    public static /* synthetic */ void b(O o7, Q.c cVar, long j7, KeyEvent keyEvent) {
        o7.getClass();
        o7.n(false, Long.valueOf(cVar.f8724b), Long.valueOf(j7), keyEvent.getEventTime());
    }

    public static /* synthetic */ void c(O o7, Q.c cVar, long j7, KeyEvent keyEvent) {
        o7.getClass();
        o7.n(false, Long.valueOf(cVar.f8724b), Long.valueOf(j7), keyEvent.getEventTime());
    }

    public static /* synthetic */ void d(P.d.a aVar, ByteBuffer byteBuffer) {
        Boolean boolValueOf = Boolean.FALSE;
        if (byteBuffer != null) {
            byteBuffer.rewind();
            if (byteBuffer.capacity() != 0) {
                boolValueOf = Boolean.valueOf(byteBuffer.get() != 0);
            }
        } else {
            U4.b.g("KeyEmbedderResponder", "A null reply was received when sending a key event to the framework.");
        }
        aVar.a(boolValueOf.booleanValue());
    }

    public static K.b e(KeyEvent keyEvent) {
        boolean z7 = keyEvent.getRepeatCount() > 0;
        int action = keyEvent.getAction();
        if (action == 0) {
            return z7 ? K.b.kRepeat : K.b.kDown;
        }
        if (action == 1) {
            return K.b.kUp;
        }
        throw new AssertionError("Unexpected event type");
    }

    public static long j(long j7, long j8) {
        return (j7 & 4294967295L) | j8;
    }

    @Override // V4.P.d
    public void a(KeyEvent keyEvent, P.d.a aVar) {
        if (i(keyEvent, aVar)) {
            return;
        }
        n(true, 0L, 0L, 0L);
        aVar.a(true);
    }

    public final Long f(KeyEvent keyEvent) {
        Long l7 = (Long) Q.f8721b.get(Long.valueOf(keyEvent.getKeyCode()));
        return l7 != null ? l7 : Long.valueOf(j(keyEvent.getKeyCode(), 73014444032L));
    }

    public final Long g(KeyEvent keyEvent) {
        long scanCode = keyEvent.getScanCode();
        if (scanCode == 0) {
            return Long.valueOf(j(keyEvent.getKeyCode(), 73014444032L));
        }
        Long l7 = (Long) Q.f8720a.get(Long.valueOf(scanCode));
        return l7 != null ? l7 : Long.valueOf(j(keyEvent.getScanCode(), 73014444032L));
    }

    public Map h() {
        return Collections.unmodifiableMap(this.f8706b);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013d A[LOOP:2: B:70:0x013b->B:71:0x013d, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(android.view.KeyEvent r16, V4.P.d.a r17) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: V4.O.i(android.view.KeyEvent, V4.P$d$a):boolean");
    }

    public final void k(K k7, final P.d.a aVar) {
        this.f8705a.d("flutter/keydata", k7.a(), aVar == null ? null : new b.InterfaceC0193b() { // from class: V4.L
            @Override // h5.b.InterfaceC0193b
            public final void a(ByteBuffer byteBuffer) {
                O.d(aVar, byteBuffer);
            }
        });
    }

    public void l(Q.d dVar, boolean z7, long j7, final long j8, final KeyEvent keyEvent, ArrayList arrayList) {
        Q.c[] cVarArr = dVar.f8726b;
        boolean[] zArr = new boolean[cVarArr.length];
        Boolean[] boolArr = new Boolean[cVarArr.length];
        int i7 = 0;
        boolean z8 = false;
        while (true) {
            Q.c[] cVarArr2 = dVar.f8726b;
            boolean z9 = true;
            if (i7 >= cVarArr2.length) {
                break;
            }
            final Q.c cVar = cVarArr2[i7];
            boolean zContainsKey = this.f8706b.containsKey(Long.valueOf(cVar.f8723a));
            zArr[i7] = zContainsKey;
            if (cVar.f8724b == j7) {
                int i8 = a.f8709a[e(keyEvent).ordinal()];
                if (i8 != 1) {
                    if (i8 == 2) {
                        boolArr[i7] = Boolean.valueOf(zArr[i7]);
                    } else if (i8 == 3) {
                        if (!z7) {
                            arrayList.add(new Runnable() { // from class: V4.N
                                @Override // java.lang.Runnable
                                public final void run() {
                                    O.b(this.f8701l, cVar, j8, keyEvent);
                                }
                            });
                        }
                        boolArr[i7] = Boolean.valueOf(zArr[i7]);
                    }
                    i7++;
                } else {
                    boolArr[i7] = Boolean.FALSE;
                    if (!z7) {
                        arrayList.add(new Runnable() { // from class: V4.M
                            @Override // java.lang.Runnable
                            public final void run() {
                                O.c(this.f8697l, cVar, j8, keyEvent);
                            }
                        });
                    }
                }
            } else if (!z8 && !zContainsKey) {
                z9 = false;
            }
            z8 = z9;
            i7++;
        }
        boolean z10 = keyEvent.getDeviceId() == -1;
        if (z7) {
            for (int i9 = 0; i9 < dVar.f8726b.length; i9++) {
                if (boolArr[i9] == null) {
                    if (z8 || z10) {
                        boolArr[i9] = Boolean.valueOf(zArr[i9]);
                    } else {
                        boolArr[i9] = Boolean.TRUE;
                        z8 = true;
                    }
                }
            }
            if (!z8 && !z10) {
                boolArr[0] = Boolean.TRUE;
            }
        } else {
            for (int i10 = 0; i10 < dVar.f8726b.length; i10++) {
                if (boolArr[i10] == null) {
                    boolArr[i10] = Boolean.FALSE;
                }
            }
        }
        for (int i11 = 0; i11 < dVar.f8726b.length; i11++) {
            if (zArr[i11] != boolArr[i11].booleanValue()) {
                Q.c cVar2 = dVar.f8726b[i11];
                n(boolArr[i11].booleanValue(), Long.valueOf(cVar2.f8724b), Long.valueOf(cVar2.f8723a), keyEvent.getEventTime());
            }
        }
    }

    public void m(Q.e eVar, boolean z7, long j7, KeyEvent keyEvent) {
        if (eVar.f8729c == j7 || eVar.f8730d == z7) {
            return;
        }
        boolean zContainsKey = this.f8706b.containsKey(Long.valueOf(eVar.f8728b));
        boolean z8 = !zContainsKey;
        if (!zContainsKey) {
            eVar.f8730d = !eVar.f8730d;
        }
        n(z8, Long.valueOf(eVar.f8729c), Long.valueOf(eVar.f8728b), keyEvent.getEventTime());
        if (zContainsKey) {
            eVar.f8730d = !eVar.f8730d;
        }
        n(zContainsKey, Long.valueOf(eVar.f8729c), Long.valueOf(eVar.f8728b), keyEvent.getEventTime());
    }

    public final void n(boolean z7, Long l7, Long l8, long j7) {
        K k7 = new K();
        k7.f8677a = j7;
        k7.f8678b = z7 ? K.b.kDown : K.b.kUp;
        k7.f8680d = l7.longValue();
        k7.f8679c = l8.longValue();
        k7.f8683g = null;
        k7.f8681e = true;
        k7.f8682f = K.a.kKeyboard;
        if (l8.longValue() != 0 && l7.longValue() != 0) {
            if (!z7) {
                l7 = null;
            }
            o(l8, l7);
        }
        k(k7, null);
    }

    public void o(Long l7, Long l8) {
        if (l8 != null) {
            if (((Long) this.f8706b.put(l7, l8)) != null) {
                throw new AssertionError("The key was not empty");
            }
        } else if (((Long) this.f8706b.remove(l7)) == null) {
            throw new AssertionError("The key was empty");
        }
    }
}
