package org.webrtc;

import com.fasterxml.jackson.core.JsonFactory;
import java.util.Map;

/* loaded from: classes3.dex */
public class RTCStats {
    private final String id;
    private final Map<String, Object> members;
    private final long timestampUs;
    private final String type;

    public RTCStats(long j7, String str, String str2, Map<String, Object> map) {
        this.timestampUs = j7;
        this.type = str;
        this.id = str2;
        this.members = map;
    }

    private static void appendValue(StringBuilder sb, Object obj) {
        if (!(obj instanceof Object[])) {
            if (!(obj instanceof String)) {
                sb.append(obj);
                return;
            }
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            sb.append(obj);
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            return;
        }
        Object[] objArr = (Object[]) obj;
        sb.append('[');
        for (int i7 = 0; i7 < objArr.length; i7++) {
            if (i7 != 0) {
                sb.append(", ");
            }
            appendValue(sb, objArr[i7]);
        }
        sb.append(']');
    }

    @CalledByNative
    public static RTCStats create(long j7, String str, String str2, Map map) {
        return new RTCStats(j7, str, str2, map);
    }

    public String getId() {
        return this.id;
    }

    public Map<String, Object> getMembers() {
        return this.members;
    }

    public double getTimestampUs() {
        return this.timestampUs;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ timestampUs: ");
        sb.append(this.timestampUs);
        sb.append(", type: ");
        sb.append(this.type);
        sb.append(", id: ");
        sb.append(this.id);
        for (Map.Entry<String, Object> entry : this.members.entrySet()) {
            sb.append(", ");
            sb.append(entry.getKey());
            sb.append(": ");
            appendValue(sb, entry.getValue());
        }
        sb.append(" }");
        return sb.toString();
    }
}
