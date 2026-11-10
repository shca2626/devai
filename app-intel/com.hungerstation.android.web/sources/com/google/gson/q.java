package com.google.gson;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: b, reason: collision with root package name */
    public static final q f25130b;

    /* renamed from: c, reason: collision with root package name */
    public static final q f25131c;

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ q[] f25132d;

    enum a extends q {
        a(String str, int i12) {
            super(str, i12, null);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        f25130b = aVar;
        q qVar = new q("STRING", 1) { // from class: com.google.gson.q.b
            {
                a aVar2 = null;
            }
        };
        f25131c = qVar;
        f25132d = new q[]{aVar, qVar};
    }

    private q(String str, int i12) {
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f25132d.clone();
    }

    /* synthetic */ q(String str, int i12, a aVar) {
        this(str, i12);
    }
}
