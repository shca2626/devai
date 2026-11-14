package v5;

import org.webrtc.AudioTrack;
import org.webrtc.AudioTrackSink;

/* renamed from: v5.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1710s implements InterfaceC1708q {

    /* renamed from: a, reason: collision with root package name */
    public AudioTrack f23138a;

    public C1710s(AudioTrack audioTrack) {
        M5.m.e(audioTrack, "audioTrack");
        this.f23138a = audioTrack;
    }

    @Override // v5.InterfaceC1708q
    public void a(AudioTrackSink audioTrackSink) {
        M5.m.e(audioTrackSink, "sink");
        AudioTrack audioTrack = this.f23138a;
        if (audioTrack != null) {
            audioTrack.removeSink(audioTrackSink);
        }
    }

    @Override // v5.InterfaceC1708q
    public void b(AudioTrackSink audioTrackSink) {
        AudioTrack audioTrack = this.f23138a;
        if (audioTrack != null) {
            audioTrack.addSink(audioTrackSink);
        }
    }

    @Override // v5.InterfaceC1708q
    public String id() {
        String strId;
        AudioTrack audioTrack = this.f23138a;
        return (audioTrack == null || (strId = audioTrack.id()) == null) ? "" : strId;
    }
}
