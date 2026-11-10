package t1;

import B0.y;
import j3.AbstractC1229c;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p1.d;

/* renamed from: t1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1623a extends d {

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f22494c = Pattern.compile("(.+?)='(.*?)';", 32);

    /* renamed from: a, reason: collision with root package name */
    public final CharsetDecoder f22495a = StandardCharsets.UTF_8.newDecoder();

    /* renamed from: b, reason: collision with root package name */
    public final CharsetDecoder f22496b = StandardCharsets.ISO_8859_1.newDecoder();

    @Override // p1.d
    public y b(p1.b bVar, ByteBuffer byteBuffer) {
        String strC = c(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (strC == null) {
            return new y(new C1625c(bArr, null, null));
        }
        Matcher matcher = f22494c.matcher(strC);
        String str2 = null;
        for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            if (strGroup != null) {
                String strF = AbstractC1229c.f(strGroup);
                strF.getClass();
                if (strF.equals("streamurl")) {
                    str2 = strGroup2;
                } else if (strF.equals("streamtitle")) {
                    str = strGroup2;
                }
            }
        }
        return new y(new C1625c(bArr, str, str2));
    }

    public final String c(ByteBuffer byteBuffer) {
        try {
            return this.f22495a.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                String string = this.f22496b.decode(byteBuffer).toString();
                this.f22496b.reset();
                byteBuffer.rewind();
                return string;
            } catch (CharacterCodingException unused2) {
                this.f22496b.reset();
                byteBuffer.rewind();
                return null;
            } catch (Throwable th) {
                this.f22496b.reset();
                byteBuffer.rewind();
                throw th;
            }
        } finally {
            this.f22495a.reset();
            byteBuffer.rewind();
        }
    }
}
