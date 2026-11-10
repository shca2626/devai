package org.webrtc;

/* loaded from: classes3.dex */
public class MediaStreamTrack {
    public static final String AUDIO_TRACK_KIND = "audio";
    public static final String VIDEO_TRACK_KIND = "video";
    private long nativeTrack;

    public enum MediaType {
        MEDIA_TYPE_AUDIO(0),
        MEDIA_TYPE_VIDEO(1);

        private final int nativeIndex;

        MediaType(int i7) {
            this.nativeIndex = i7;
        }

        @CalledByNative
        public static MediaType fromNativeIndex(int i7) {
            for (MediaType mediaType : values()) {
                if (mediaType.getNative() == i7) {
                    return mediaType;
                }
            }
            throw new IllegalArgumentException("Unknown native media type: " + i7);
        }

        @CalledByNative
        public int getNative() {
            return this.nativeIndex;
        }
    }

    public enum State {
        LIVE,
        ENDED;

        @CalledByNative
        public static State fromNativeIndex(int i7) {
            return values()[i7];
        }
    }

    public MediaStreamTrack(long j7) {
        if (j7 == 0) {
            throw new IllegalArgumentException("nativeTrack may not be null");
        }
        this.nativeTrack = j7;
    }

    private void checkMediaStreamTrackExists() {
        if (this.nativeTrack == 0) {
            throw new IllegalStateException("MediaStreamTrack has been disposed.");
        }
    }

    public static MediaStreamTrack createMediaStreamTrack(long j7) {
        if (j7 == 0) {
            return null;
        }
        String strNativeGetKind = nativeGetKind(j7);
        if (strNativeGetKind.equals(AUDIO_TRACK_KIND)) {
            return new AudioTrack(j7);
        }
        if (strNativeGetKind.equals(VIDEO_TRACK_KIND)) {
            return new VideoTrack(j7);
        }
        return null;
    }

    private static native boolean nativeGetEnabled(long j7);

    private static native String nativeGetId(long j7);

    private static native String nativeGetKind(long j7);

    private static native State nativeGetState(long j7);

    private static native boolean nativeSetEnabled(long j7, boolean z7);

    public void dispose() {
        checkMediaStreamTrackExists();
        JniCommon.nativeReleaseRef(this.nativeTrack);
        this.nativeTrack = 0L;
    }

    public boolean enabled() {
        checkMediaStreamTrackExists();
        return nativeGetEnabled(this.nativeTrack);
    }

    public long getNativeMediaStreamTrack() {
        checkMediaStreamTrackExists();
        return this.nativeTrack;
    }

    public String id() {
        checkMediaStreamTrackExists();
        return nativeGetId(this.nativeTrack);
    }

    public boolean isDisposed() {
        return this.nativeTrack == 0;
    }

    public String kind() {
        checkMediaStreamTrackExists();
        return nativeGetKind(this.nativeTrack);
    }

    public boolean setEnabled(boolean z7) {
        checkMediaStreamTrackExists();
        return nativeSetEnabled(this.nativeTrack, z7);
    }

    public State state() {
        checkMediaStreamTrackExists();
        return nativeGetState(this.nativeTrack);
    }
}
