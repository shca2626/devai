package J5;

import M5.m;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class e extends IOException {

    /* renamed from: l, reason: collision with root package name */
    public final File f4802l;

    /* renamed from: m, reason: collision with root package name */
    public final File f4803m;

    /* renamed from: n, reason: collision with root package name */
    public final String f4804n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(File file, File file2, String str) {
        super(c.b(file, file2, str));
        m.e(file, "file");
        this.f4802l = file;
        this.f4803m = file2;
        this.f4804n = str;
    }
}
