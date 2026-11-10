package com.fasterxml.jackson.core.sym;

/* loaded from: classes.dex */
public abstract class Name {
    protected final int _hashCode;
    protected final String _name;

    public Name(String str, int i7) {
        this._name = str;
        this._hashCode = i7;
    }

    public abstract boolean equals(int i7);

    public abstract boolean equals(int i7, int i8);

    public abstract boolean equals(int i7, int i8, int i9);

    public boolean equals(Object obj) {
        return obj == this;
    }

    public abstract boolean equals(int[] iArr, int i7);

    public String getName() {
        return this._name;
    }

    public final int hashCode() {
        return this._hashCode;
    }

    public String toString() {
        return this._name;
    }
}
