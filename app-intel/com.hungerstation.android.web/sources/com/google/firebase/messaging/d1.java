package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class d1 {

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f24341a;

    /* renamed from: b, reason: collision with root package name */
    private final String f24342b;

    /* renamed from: c, reason: collision with root package name */
    private final String f24343c;

    /* renamed from: e, reason: collision with root package name */
    private final Executor f24345e;

    /* renamed from: d, reason: collision with root package name */
    final ArrayDeque<String> f24344d = new ArrayDeque<>();

    /* renamed from: f, reason: collision with root package name */
    private boolean f24346f = false;

    private d1(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f24341a = sharedPreferences;
        this.f24342b = str;
        this.f24343c = str2;
        this.f24345e = executor;
    }

    private boolean c(boolean z12) {
        if (z12 && !this.f24346f) {
            j();
        }
        return z12;
    }

    static d1 d(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        d1 d1Var = new d1(sharedPreferences, str, str2, executor);
        d1Var.e();
        return d1Var;
    }

    private void e() {
        synchronized (this.f24344d) {
            try {
                this.f24344d.clear();
                String string = this.f24341a.getString(this.f24342b, "");
                if (!TextUtils.isEmpty(string) && string.contains(this.f24343c)) {
                    String[] strArrSplit = string.split(this.f24343c, -1);
                    int length = strArrSplit.length;
                    for (String str : strArrSplit) {
                        if (!TextUtils.isEmpty(str)) {
                            this.f24344d.add(str);
                        }
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        synchronized (this.f24344d) {
            this.f24341a.edit().putString(this.f24342b, h()).commit();
        }
    }

    private void j() {
        this.f24345e.execute(new Runnable() { // from class: com.google.firebase.messaging.c1
            @Override // java.lang.Runnable
            public final void run() {
                this.f24335b.i();
            }
        });
    }

    public boolean b(String str) {
        boolean zC;
        if (TextUtils.isEmpty(str) || str.contains(this.f24343c)) {
            return false;
        }
        synchronized (this.f24344d) {
            zC = c(this.f24344d.add(str));
        }
        return zC;
    }

    public String f() {
        String strPeek;
        synchronized (this.f24344d) {
            strPeek = this.f24344d.peek();
        }
        return strPeek;
    }

    public boolean g(Object obj) {
        boolean zC;
        synchronized (this.f24344d) {
            zC = c(this.f24344d.remove(obj));
        }
        return zC;
    }

    public String h() {
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = this.f24344d.iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            sb2.append(this.f24343c);
        }
        return sb2.toString();
    }
}
