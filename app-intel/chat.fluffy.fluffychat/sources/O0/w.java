package O0;

import java.io.IOException;

/* loaded from: classes.dex */
public final class w extends IOException {
    public w(String str) {
        super("Unable to bind a sample queue to TrackGroup with MIME type " + str + ".");
    }
}
