package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* renamed from: androidx.datastore.preferences.protobuf.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0791v extends IOException {

    /* renamed from: l, reason: collision with root package name */
    public K f12251l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12252m;

    /* renamed from: androidx.datastore.preferences.protobuf.v$a */
    public static class a extends C0791v {
        public a(String str) {
            super(str);
        }
    }

    public C0791v(String str) {
        super(str);
        this.f12251l = null;
    }

    public static C0791v b() {
        return new C0791v("Protocol message end-group tag did not match expected tag.");
    }

    public static C0791v c() {
        return new C0791v("Protocol message contained an invalid tag (zero).");
    }

    public static C0791v d() {
        return new C0791v("Protocol message had invalid UTF-8.");
    }

    public static a e() {
        return new a("Protocol message tag had invalid wire type.");
    }

    public static C0791v f() {
        return new C0791v("CodedInputStream encountered a malformed varint.");
    }

    public static C0791v g() {
        return new C0791v("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static C0791v h() {
        return new C0791v("Failed to parse the message.");
    }

    public static C0791v i() {
        return new C0791v("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    public static C0791v l() {
        return new C0791v("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static C0791v m() {
        return new C0791v("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public boolean a() {
        return this.f12252m;
    }

    public void j() {
        this.f12252m = true;
    }

    public C0791v k(K k7) {
        this.f12251l = k7;
        return this;
    }

    public C0791v(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.f12251l = null;
    }
}
