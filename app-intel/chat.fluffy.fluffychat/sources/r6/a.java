package r6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import v6.A;
import v6.o;
import v6.y;

/* loaded from: classes3.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f22342a = new C0264a();

    /* renamed from: r6.a$a, reason: collision with other inner class name */
    public class C0264a implements a {
        @Override // r6.a
        public A a(File file) {
            return o.k(file);
        }

        @Override // r6.a
        public y b(File file) {
            try {
                return o.f(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return o.f(file);
            }
        }

        @Override // r6.a
        public void c(File file) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("not a readable directory: " + file);
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    c(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete " + file2);
                }
            }
        }

        @Override // r6.a
        public boolean d(File file) {
            return file.exists();
        }

        @Override // r6.a
        public void e(File file, File file2) throws IOException {
            f(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }

        @Override // r6.a
        public void f(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // r6.a
        public y g(File file) {
            try {
                return o.a(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return o.a(file);
            }
        }

        @Override // r6.a
        public long h(File file) {
            return file.length();
        }
    }

    A a(File file);

    y b(File file);

    void c(File file);

    boolean d(File file);

    void e(File file, File file2);

    void f(File file);

    y g(File file);

    long h(File file);
}
