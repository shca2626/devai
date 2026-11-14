package I0;

import android.media.MediaFormat;
import android.os.Bundle;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: I0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0360d {

    /* renamed from: b, reason: collision with root package name */
    public static final C0360d f3946b = new b().a();

    /* renamed from: a, reason: collision with root package name */
    public final Map f3947a;

    /* renamed from: I0.d$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Map f3948a;

        public C0360d a() {
            return new C0360d(this.f3948a);
        }

        public b b(String str) {
            this.f3948a.remove(str);
            return this;
        }

        public b c(String str, ByteBuffer byteBuffer) {
            if (byteBuffer == null) {
                this.f3948a.put(str, null);
                return this;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
            byteBufferAllocate.put(byteBuffer.duplicate());
            byteBufferAllocate.flip();
            this.f3948a.put(str, byteBufferAllocate);
            return this;
        }

        public b d(String str, float f7) {
            this.f3948a.put(str, Float.valueOf(f7));
            return this;
        }

        public b e(String str, int i7) {
            this.f3948a.put(str, Integer.valueOf(i7));
            return this;
        }

        public b f(String str, long j7) {
            this.f3948a.put(str, Long.valueOf(j7));
            return this;
        }

        public b g(String str, String str2) {
            this.f3948a.put(str, str2);
            return this;
        }

        public b() {
            this.f3948a = new HashMap();
        }

        public b(C0360d c0360d) {
            this.f3948a = new HashMap(c0360d.f3947a);
        }
    }

    public static b d(MediaFormat mediaFormat, Set set) {
        b bVar = new b();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (mediaFormat.containsKey(str)) {
                int valueTypeForKey = mediaFormat.getValueTypeForKey(str);
                if (valueTypeForKey == 1) {
                    bVar.e(str, mediaFormat.getInteger(str));
                } else if (valueTypeForKey == 2) {
                    bVar.f(str, mediaFormat.getLong(str));
                } else if (valueTypeForKey == 3) {
                    bVar.d(str, mediaFormat.getFloat(str));
                } else if (valueTypeForKey == 4) {
                    bVar.g(str, mediaFormat.getString(str));
                } else if (valueTypeForKey == 5) {
                    bVar.c(str, mediaFormat.getByteBuffer(str));
                }
            }
        }
        return bVar;
    }

    public void b(MediaFormat mediaFormat) {
        for (Map.Entry entry : this.f3947a.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                mediaFormat.setString(str, null);
            } else if (value instanceof Integer) {
                mediaFormat.setInteger(str, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                mediaFormat.setLong(str, ((Long) value).longValue());
            } else if (value instanceof Float) {
                mediaFormat.setFloat(str, ((Float) value).floatValue());
            } else if (value instanceof String) {
                mediaFormat.setString(str, (String) value);
            } else if (value instanceof ByteBuffer) {
                mediaFormat.setByteBuffer(str, (ByteBuffer) value);
            }
        }
    }

    public b c() {
        return new b();
    }

    public Set e() {
        return this.f3947a.keySet();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0360d) {
            return this.f3947a.equals(((C0360d) obj).f3947a);
        }
        return false;
    }

    public Bundle f() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.f3947a.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                if (value instanceof Integer) {
                    bundle.putInt(str, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    bundle.putLong(str, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    bundle.putFloat(str, ((Float) value).floatValue());
                } else if (value instanceof String) {
                    bundle.putString(str, (String) value);
                } else if (value instanceof ByteBuffer) {
                    ByteBuffer byteBuffer = (ByteBuffer) value;
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.duplicate().get(bArr);
                    bundle.putByteArray(str, bArr);
                }
            }
        }
        return bundle;
    }

    public int hashCode() {
        return this.f3947a.hashCode();
    }

    public C0360d(Map map) {
        this.f3947a = Collections.unmodifiableMap(map);
    }
}
