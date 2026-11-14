package R0;

import R0.C0581s;
import android.media.LoudnessCodecController;
import android.media.LoudnessCodecController$OnLoudnessCodecUpdateListener;
import android.media.MediaCodec;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: R0.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0581s {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f7844a;

    /* renamed from: b, reason: collision with root package name */
    public final b f7845b;

    /* renamed from: c, reason: collision with root package name */
    public LoudnessCodecController f7846c;

    /* renamed from: R0.s$a */
    public class a implements LoudnessCodecController$OnLoudnessCodecUpdateListener {
        public a() {
        }

        public Bundle onLoudnessCodecUpdate(MediaCodec mediaCodec, Bundle bundle) {
            return C0581s.this.f7845b.a(bundle);
        }
    }

    /* renamed from: R0.s$b */
    public interface b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7848a = new b() { // from class: R0.t
            @Override // R0.C0581s.b
            public final Bundle a(Bundle bundle) {
                return C0581s.b.b(bundle);
            }
        };

        static /* synthetic */ Bundle b(Bundle bundle) {
            return bundle;
        }

        Bundle a(Bundle bundle);
    }

    public C0581s() {
        this(b.f7848a);
    }

    public void b(MediaCodec mediaCodec) {
        LoudnessCodecController loudnessCodecController = this.f7846c;
        if (loudnessCodecController == null || loudnessCodecController.addMediaCodec(mediaCodec)) {
            j3.o.v(this.f7844a.add(mediaCodec));
        }
    }

    public void c() {
        this.f7844a.clear();
        LoudnessCodecController loudnessCodecController = this.f7846c;
        if (loudnessCodecController != null) {
            loudnessCodecController.close();
        }
    }

    public void d(MediaCodec mediaCodec) {
        LoudnessCodecController loudnessCodecController;
        if (!this.f7844a.remove(mediaCodec) || (loudnessCodecController = this.f7846c) == null) {
            return;
        }
        loudnessCodecController.removeMediaCodec(mediaCodec);
    }

    public void e(int i7) {
        LoudnessCodecController loudnessCodecController = this.f7846c;
        if (loudnessCodecController != null) {
            loudnessCodecController.close();
            this.f7846c = null;
        }
        LoudnessCodecController loudnessCodecControllerCreate = LoudnessCodecController.create(i7, p3.c.a(), new a());
        this.f7846c = loudnessCodecControllerCreate;
        Iterator it = this.f7844a.iterator();
        while (it.hasNext()) {
            if (!loudnessCodecControllerCreate.addMediaCodec((MediaCodec) it.next())) {
                it.remove();
            }
        }
    }

    public C0581s(b bVar) {
        this.f7844a = new HashSet();
        this.f7845b = bVar;
    }
}
