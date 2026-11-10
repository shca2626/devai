package J5;

import M5.m;
import java.io.File;

/* loaded from: classes.dex */
public final class j extends e {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(File file, File file2, String str) {
        super(file, file2, str);
        m.e(file, "file");
    }

    public /* synthetic */ j(File file, File file2, String str, int i7, M5.g gVar) {
        this(file, (i7 & 2) != 0 ? null : file2, (i7 & 4) != 0 ? null : str);
    }
}
