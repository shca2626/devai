package r5;

/* loaded from: classes.dex */
public abstract class L implements InterfaceC1591v {

    /* renamed from: a, reason: collision with root package name */
    public static final a f22208a = new a(null);

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final void a(h5.b bVar, L l7, String str) {
            M5.m.e(bVar, "messenger");
            M5.m.e(l7, "streamHandler");
            M5.m.e(str, "instanceName");
            String str2 = "dev.flutter.pigeon.video_player_android.VideoEventChannel.videoEvents";
            if (str.length() > 0) {
                str2 = "dev.flutter.pigeon.video_player_android.VideoEventChannel.videoEvents." + str;
            }
            new h5.c(bVar, str2, AbstractC1589t.a()).d(new C1592w(l7));
        }

        public a() {
        }
    }

    @Override // r5.InterfaceC1591v
    public void a(Object obj, C1570A c1570a) {
        M5.m.e(c1570a, "sink");
    }

    @Override // r5.InterfaceC1591v
    public void onCancel(Object obj) {
    }
}
