package com.cloudwebrtc.webrtc;

import com.cloudwebrtc.webrtc.utils.AnyThreadSink;
import com.cloudwebrtc.webrtc.utils.ConstraintsMap;
import h5.c;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.webrtc.DataChannel;

/* loaded from: classes.dex */
class DataChannelObserver implements DataChannel.Observer, c.d {
    private final DataChannel dataChannel;
    private final h5.c eventChannel;
    private c.b eventSink;
    private final String flutterId;
    private final ArrayList eventQueue = new ArrayList();
    private final Object eventLock = new Object();
    private volatile boolean disposed = false;

    /* renamed from: com.cloudwebrtc.webrtc.DataChannelObserver$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$webrtc$DataChannel$State;

        static {
            int[] iArr = new int[DataChannel.State.values().length];
            $SwitchMap$org$webrtc$DataChannel$State = iArr;
            try {
                iArr[DataChannel.State.CONNECTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$webrtc$DataChannel$State[DataChannel.State.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$webrtc$DataChannel$State[DataChannel.State.CLOSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$webrtc$DataChannel$State[DataChannel.State.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public DataChannelObserver(h5.b bVar, String str, String str2, DataChannel dataChannel) {
        this.flutterId = str2;
        this.dataChannel = dataChannel;
        h5.c cVar = new h5.c(bVar, "FlutterWebRTC/dataChannelEvent" + str + str2);
        this.eventChannel = cVar;
        cVar.d(this);
    }

    private String dataChannelStateString(DataChannel.State state) {
        int i7 = AnonymousClass1.$SwitchMap$org$webrtc$DataChannel$State[state.ordinal()];
        return i7 != 1 ? i7 != 2 ? i7 != 3 ? i7 != 4 ? "" : "closed" : "closing" : "open" : "connecting";
    }

    private void sendEvent(ConstraintsMap constraintsMap) {
        synchronized (this.eventLock) {
            try {
                c.b bVar = this.eventSink;
                if (bVar != null) {
                    bVar.success(constraintsMap.toMap());
                } else {
                    this.eventQueue.add(constraintsMap.toMap());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void dispose() {
        if (this.disposed) {
            return;
        }
        this.disposed = true;
        this.dataChannel.unregisterObserver();
        this.eventChannel.d(null);
        synchronized (this.eventLock) {
            this.eventSink = null;
            this.eventQueue.clear();
        }
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onBufferedAmountChange(long j7) {
        ConstraintsMap constraintsMap = new ConstraintsMap();
        constraintsMap.putString("event", "dataChannelBufferedAmountChange");
        constraintsMap.putInt("id", this.dataChannel.id());
        constraintsMap.putLong("bufferedAmount", this.dataChannel.bufferedAmount());
        constraintsMap.putLong("changedAmount", j7);
        sendEvent(constraintsMap);
    }

    @Override // h5.c.d
    public void onCancel(Object obj) {
        synchronized (this.eventLock) {
            this.eventSink = null;
        }
    }

    @Override // h5.c.d
    public void onListen(Object obj, c.b bVar) {
        synchronized (this.eventLock) {
            try {
                this.eventSink = new AnyThreadSink(bVar);
                ArrayList arrayList = this.eventQueue;
                int size = arrayList.size();
                int i7 = 0;
                while (i7 < size) {
                    Object obj2 = arrayList.get(i7);
                    i7++;
                    this.eventSink.success(obj2);
                }
                this.eventQueue.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onMessage(DataChannel.Buffer buffer) {
        byte[] bArrArray;
        ConstraintsMap constraintsMap = new ConstraintsMap();
        constraintsMap.putString("event", "dataChannelReceiveMessage");
        constraintsMap.putInt("id", this.dataChannel.id());
        if (buffer.data.hasArray()) {
            bArrArray = buffer.data.array();
        } else {
            bArrArray = new byte[buffer.data.remaining()];
            buffer.data.get(bArrArray);
        }
        if (buffer.binary) {
            constraintsMap.putString("type", "binary");
            constraintsMap.putByte("data", bArrArray);
        } else {
            constraintsMap.putString("type", "text");
            constraintsMap.putString("data", new String(bArrArray, StandardCharsets.UTF_8));
        }
        sendEvent(constraintsMap);
    }

    @Override // org.webrtc.DataChannel.Observer
    public void onStateChange() {
        ConstraintsMap constraintsMap = new ConstraintsMap();
        constraintsMap.putString("event", "dataChannelStateChanged");
        constraintsMap.putInt("id", this.dataChannel.id());
        constraintsMap.putString("state", dataChannelStateString(this.dataChannel.state()));
        sendEvent(constraintsMap);
    }
}
