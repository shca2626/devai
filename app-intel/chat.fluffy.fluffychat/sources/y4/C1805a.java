package y4;

import M5.g;
import M5.m;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.webrtc.MediaStreamTrack;
import y5.AbstractC1817l;
import y5.C1813h;
import z5.C1863G;
import z5.C1877k;
import z5.C1878l;
import z5.C1882p;

/* renamed from: y4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1805a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0294a f24000a = new C0294a(null);

    /* renamed from: y4.a$a, reason: collision with other inner class name */
    public static final class C0294a {
        public /* synthetic */ C0294a(g gVar) {
            this();
        }

        public final AudioDeviceInfo a(Context context, Map map) {
            m.e(context, "context");
            Object obj = null;
            if (map == null) {
                return null;
            }
            Iterator it = e(context).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (m.a(String.valueOf(((AudioDeviceInfo) next).getId()), map.get("id"))) {
                    obj = next;
                    break;
                }
            }
            return (AudioDeviceInfo) obj;
        }

        public final Map b(AudioDeviceInfo audioDeviceInfo) {
            C1813h c1813hA = AbstractC1817l.a("id", String.valueOf(audioDeviceInfo.getId()));
            C1813h c1813hA2 = AbstractC1817l.a("label", audioDeviceInfo.getProductName());
            C1813h c1813hA3 = AbstractC1817l.a("type", g(audioDeviceInfo.getType()));
            int[] sampleRates = audioDeviceInfo.getSampleRates();
            m.d(sampleRates, "getSampleRates(...)");
            return C1863G.k(c1813hA, c1813hA2, c1813hA3, AbstractC1817l.a("sampleRates", C1878l.N(sampleRates)));
        }

        public final List c(List list) {
            m.e(list, "devices");
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                AudioDeviceInfo audioDeviceInfo = (AudioDeviceInfo) obj;
                if (audioDeviceInfo.isSource() && audioDeviceInfo.getType() != 18 && audioDeviceInfo.getType() != 25 && audioDeviceInfo.getType() != 28) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }

        public final AudioDeviceInfo d() throws IllegalStateException {
            AudioRecord audioRecord;
            int minBufferSize = AudioRecord.getMinBufferSize(8000, 16, 2);
            AudioDeviceInfo routedDevice = null;
            if (minBufferSize <= 0) {
                return null;
            }
            try {
                audioRecord = new AudioRecord(0, 8000, 16, 2, minBufferSize);
            } catch (Exception unused) {
            }
            if (audioRecord.getState() != 1) {
                audioRecord.release();
                return null;
            }
            try {
                audioRecord.startRecording();
                routedDevice = audioRecord.getRoutedDevice();
            } catch (Exception unused2) {
            } catch (Throwable th) {
                try {
                    audioRecord.stop();
                } catch (Exception unused3) {
                }
                audioRecord.release();
                throw th;
            }
            try {
                audioRecord.stop();
            } catch (Exception unused4) {
            }
            audioRecord.release();
            return routedDevice;
        }

        public final List e(Context context) {
            Object systemService = context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            m.c(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            AudioDeviceInfo[] devices = ((AudioManager) systemService).getDevices(1);
            m.b(devices);
            return c(C1877k.d(devices));
        }

        public final List f(Context context) {
            m.e(context, "context");
            List listE = e(context);
            ArrayList arrayList = new ArrayList(C1882p.o(listE, 10));
            Iterator it = listE.iterator();
            while (it.hasNext()) {
                arrayList.add(C1805a.f24000a.b((AudioDeviceInfo) it.next()));
            }
            return arrayList;
        }

        public final String g(int i7) {
            if (i7 == 3) {
                return "wiredHeadset";
            }
            if (i7 == 15) {
                return "builtIn";
            }
            if (i7 == 19) {
                return "lineIn";
            }
            if (i7 == 22) {
                return "usb";
            }
            if (i7 == 26 || i7 == 27) {
                return "bluetoothLe";
            }
            if (i7 == 29) {
                return "hdmi";
            }
            if (i7 == 30) {
                return "bluetoothLe";
            }
            switch (i7) {
                case 5:
                case 6:
                    return "lineIn";
                case 7:
                    return "bluetoothSco";
                case 8:
                    return "bluetoothA2dp";
                case 9:
                case 10:
                    return "hdmi";
                case 11:
                case 12:
                    return "usb";
                default:
                    return "unknown";
            }
        }

        public C0294a() {
        }
    }
}
