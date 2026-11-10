package org.webrtc;

/* loaded from: classes3.dex */
public class Size {
    public int height;
    public int width;

    public Size(int i7, int i8) {
        this.width = i7;
        this.height = i8;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.width == size.width && this.height == size.height;
    }

    public int hashCode() {
        return (this.width * 65537) + 1 + this.height;
    }

    public String toString() {
        return this.width + "x" + this.height;
    }
}
