package h5;

import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes.dex */
public final class e implements h {

    /* renamed from: a, reason: collision with root package name */
    public static final e f16893a = new e();

    @Override // h5.h
    public ByteBuffer a(Object obj) throws JSONException {
        if (obj == null) {
            return null;
        }
        Object objA = g.a(obj);
        return objA instanceof String ? q.f16913b.a(JSONObject.quote((String) objA)) : q.f16913b.a(objA.toString());
    }

    @Override // h5.h
    public Object b(ByteBuffer byteBuffer) throws JSONException {
        if (byteBuffer == null) {
            return null;
        }
        try {
            JSONTokener jSONTokener = new JSONTokener(q.f16913b.b(byteBuffer));
            Object objNextValue = jSONTokener.nextValue();
            if (jSONTokener.more()) {
                throw new IllegalArgumentException("Invalid JSON");
            }
            return objNextValue;
        } catch (JSONException e7) {
            throw new IllegalArgumentException("Invalid JSON", e7);
        }
    }
}
