package f4;

import M5.g;
import M5.m;
import android.content.Context;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.File;

/* renamed from: f4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1054a implements InterfaceC1058e {

    /* renamed from: a, reason: collision with root package name */
    public final String f15843a;

    /* JADX WARN: Multi-variable type inference failed */
    public C1054a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // f4.InterfaceC1058e
    public File a(Context context, File file, String str, boolean z7) {
        m.e(context, "context");
        m.e(file, "videoFile");
        m.e(str, "fileName");
        if (this.f15843a != null) {
            str = this.f15843a + JsonPointer.SEPARATOR + str;
        }
        if (!new File(context.getFilesDir() + JsonPointer.SEPARATOR + str).exists()) {
            File parentFile = new File(context.getFilesDir() + JsonPointer.SEPARATOR + str).getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
        }
        return new File(context.getFilesDir(), str);
    }

    public C1054a(String str) {
        this.f15843a = str;
    }

    public /* synthetic */ C1054a(String str, int i7, g gVar) {
        this((i7 & 1) != 0 ? null : str);
    }
}
