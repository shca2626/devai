package h0;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/* renamed from: h0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1125a {

    /* renamed from: a, reason: collision with root package name */
    public static final C1125a f16576a = new C1125a();

    public final boolean a(File file, File file2) throws IOException {
        M5.m.e(file, "srcFile");
        M5.m.e(file2, "dstFile");
        try {
            Files.move(file.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
