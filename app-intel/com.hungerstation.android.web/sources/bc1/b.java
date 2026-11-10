package bc1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f13428a;

    /* renamed from: b, reason: collision with root package name */
    private OutputStream f13429b;

    /* renamed from: c, reason: collision with root package name */
    private PrintWriter f13430c;

    public b(HttpURLConnection httpURLConnection) {
        String str = "--" + System.currentTimeMillis();
        this.f13428a = str;
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setChunkedStreamingMode(1048576);
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + str);
        this.f13429b = httpURLConnection.getOutputStream();
        this.f13430c = new PrintWriter((Writer) new OutputStreamWriter(this.f13429b, "UTF-8"), true);
    }

    public void a() {
        this.f13430c.append((CharSequence) "\r\n").flush();
        this.f13430c.append((CharSequence) "--").append((CharSequence) this.f13428a).append((CharSequence) "--").append((CharSequence) "\r\n");
        this.f13430c.close();
    }

    public void b(String str, String str2) {
        this.f13430c.append((CharSequence) "--").append((CharSequence) this.f13428a).append((CharSequence) "\r\n");
        this.f13430c.append((CharSequence) "Content-Disposition: form-data; name=\"").append((CharSequence) str).append((CharSequence) "\"").append((CharSequence) "\r\n");
        this.f13430c.append((CharSequence) "\r\n");
        this.f13430c.append((CharSequence) str2).append((CharSequence) "\r\n");
        this.f13430c.flush();
    }

    public void c(String str, String str2, String str3, String str4) throws IOException {
        this.f13430c.append((CharSequence) "--").append((CharSequence) this.f13428a).append((CharSequence) "\r\n").append((CharSequence) "Content-Disposition: file; name=\"").append((CharSequence) str).append((CharSequence) "\"; filename=\"").append((CharSequence) str3).append((CharSequence) "\"").append((CharSequence) "\r\n").append((CharSequence) "Content-Type: ").append((CharSequence) str4).append((CharSequence) "\r\n").append((CharSequence) "\r\n").flush();
        FileInputStream fileInputStream = new FileInputStream(str2);
        try {
            byte[] bArr = new byte[1048576];
            while (true) {
                int i12 = fileInputStream.read(bArr);
                if (i12 == -1) {
                    this.f13429b.flush();
                    this.f13430c.flush();
                    fileInputStream.close();
                    return;
                }
                this.f13429b.write(bArr, 0, i12);
            }
        } catch (Throwable th2) {
            fileInputStream.close();
            throw th2;
        }
    }
}
