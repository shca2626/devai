package androidx.profileinstaller;

import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f10724a = {48, Framer.STDOUT_FRAME_PREFIX, 53, 0};

    /* renamed from: b, reason: collision with root package name */
    static final byte[] f10725b = {48, Framer.STDOUT_FRAME_PREFIX, 48, 0};

    /* renamed from: c, reason: collision with root package name */
    static final byte[] f10726c = {48, 48, 57, 0};

    /* renamed from: d, reason: collision with root package name */
    static final byte[] f10727d = {48, 48, 53, 0};

    /* renamed from: e, reason: collision with root package name */
    static final byte[] f10728e = {48, 48, Framer.STDOUT_FRAME_PREFIX, 0};

    /* renamed from: f, reason: collision with root package name */
    static final byte[] f10729f = {48, 48, Framer.STDOUT_FRAME_PREFIX, 0};

    /* renamed from: g, reason: collision with root package name */
    static final byte[] f10730g = {48, 48, Framer.STDERR_FRAME_PREFIX, 0};

    static String a(byte[] bArr) {
        return (Arrays.equals(bArr, f10728e) || Arrays.equals(bArr, f10727d)) ? ":" : "!";
    }
}
