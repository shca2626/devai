package v5;

import com.cloudwebrtc.webrtc.audio.LocalAudioTrack;
import org.webrtc.AudioTrackSink;

/* renamed from: v5.r, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1709r implements InterfaceC1708q {

    /* renamed from: a, reason: collision with root package name */
    public LocalAudioTrack f23137a;

    public C1709r(LocalAudioTrack localAudioTrack) {
        M5.m.e(localAudioTrack, "localAudioTrack");
        this.f23137a = localAudioTrack;
    }

    @Override // v5.InterfaceC1708q
    public void a(AudioTrackSink audioTrackSink) {
        M5.m.e(audioTrackSink, "sink");
        LocalAudioTrack localAudioTrack = this.f23137a;
        if (localAudioTrack != null) {
            localAudioTrack.removeSink(audioTrackSink);
        }
    }

    @Override // v5.InterfaceC1708q
    public void b(AudioTrackSink audioTrackSink) {
        LocalAudioTrack localAudioTrack = this.f23137a;
        if (localAudioTrack != null) {
            localAudioTrack.addSink(audioTrackSink);
        }
    }

    @Override // v5.InterfaceC1708q
    public String id() {
        String strId;
        LocalAudioTrack localAudioTrack = this.f23137a;
        return (localAudioTrack == null || (strId = localAudioTrack.id()) == null) ? "" : strId;
    }
}
