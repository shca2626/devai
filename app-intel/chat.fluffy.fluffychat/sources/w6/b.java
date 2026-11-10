package w6;

import M5.m;
import v6.e;
import v6.h;

/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f23419a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Code restructure failed: missing block: B:115:0x010c, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x01ac, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005d, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x009d, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int c(byte[] r18, int r19) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w6.b.c(byte[], int):int");
    }

    public static final void d(h hVar, e eVar, int i7, int i8) {
        m.e(hVar, "<this>");
        m.e(eVar, "buffer");
        eVar.write(hVar.k(), i7, i8);
    }

    public static final int e(char c7) {
        if ('0' <= c7 && c7 < ':') {
            return c7 - '0';
        }
        if ('a' <= c7 && c7 < 'g') {
            return c7 - 'W';
        }
        if ('A' <= c7 && c7 < 'G') {
            return c7 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c7);
    }

    public static final char[] f() {
        return f23419a;
    }
}
