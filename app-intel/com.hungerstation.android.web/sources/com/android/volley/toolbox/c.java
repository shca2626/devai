package com.android.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    protected static final Comparator<byte[]> f18274e = new a();

    /* renamed from: a, reason: collision with root package name */
    private final List<byte[]> f18275a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List<byte[]> f18276b = new ArrayList(64);

    /* renamed from: c, reason: collision with root package name */
    private int f18277c = 0;

    /* renamed from: d, reason: collision with root package name */
    private final int f18278d;

    class a implements Comparator<byte[]> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public c(int i12) {
        this.f18278d = i12;
    }

    private synchronized void c() {
        while (this.f18277c > this.f18278d) {
            byte[] bArrRemove = this.f18275a.remove(0);
            this.f18276b.remove(bArrRemove);
            this.f18277c -= bArrRemove.length;
        }
    }

    public synchronized byte[] a(int i12) {
        for (int i13 = 0; i13 < this.f18276b.size(); i13++) {
            byte[] bArr = this.f18276b.get(i13);
            if (bArr.length >= i12) {
                this.f18277c -= bArr.length;
                this.f18276b.remove(i13);
                this.f18275a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i12];
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f18278d) {
                this.f18275a.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.f18276b, bArr, f18274e);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.f18276b.add(iBinarySearch, bArr);
                this.f18277c += bArr.length;
                c();
            }
        }
    }
}
