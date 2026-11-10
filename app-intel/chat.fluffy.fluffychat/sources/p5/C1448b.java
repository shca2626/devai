package p5;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: p5.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1448b implements J {
    @Override // p5.J
    public String a(List list) throws IOException {
        M5.m.e(list, "list");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(list);
        objectOutputStream.flush();
        String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        M5.m.d(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    @Override // p5.J
    public List b(String str) throws ClassNotFoundException, IOException {
        M5.m.e(str, "listString");
        Object object = new O(new ByteArrayInputStream(Base64.decode(str, 0))).readObject();
        M5.m.c(object, "null cannot be cast to non-null type kotlin.collections.List<*>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : (List) object) {
            if (obj instanceof String) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
