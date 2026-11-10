package com.cloudwebrtc.webrtc.utils;

import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public class ConstraintsArray {
    private final ArrayList<Object> mArray;

    public ConstraintsArray() {
        this.mArray = new ArrayList<>();
    }

    public ConstraintsArray getArray(int i7) {
        return new ConstraintsArray((ArrayList) this.mArray.get(i7));
    }

    public boolean getBoolean(int i7) {
        return ((Boolean) this.mArray.get(i7)).booleanValue();
    }

    public Byte[] getByte(int i7) {
        return (Byte[]) this.mArray.get(i7);
    }

    public double getDouble(int i7) {
        return ((Double) this.mArray.get(i7)).doubleValue();
    }

    public int getInt(int i7) {
        return ((Integer) this.mArray.get(i7)).intValue();
    }

    public ConstraintsMap getMap(int i7) {
        return new ConstraintsMap((Map) this.mArray.get(i7));
    }

    public String getString(int i7) {
        return (String) this.mArray.get(i7);
    }

    public ObjectType getType(int i7) {
        Object obj = this.mArray.get(i7);
        return obj == null ? ObjectType.Null : obj instanceof Boolean ? ObjectType.Boolean : ((obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer)) ? ObjectType.Number : obj instanceof String ? ObjectType.String : obj instanceof ArrayList ? ObjectType.Array : obj instanceof Map ? ObjectType.Map : obj instanceof Byte ? ObjectType.Byte : ObjectType.Null;
    }

    public boolean isNull(int i7) {
        return this.mArray.get(i7) == null;
    }

    public void pushArray(ConstraintsArray constraintsArray) {
        this.mArray.add(constraintsArray.toArrayList());
    }

    public void pushBoolean(boolean z7) {
        this.mArray.add(Boolean.valueOf(z7));
    }

    public void pushByte(byte[] bArr) {
        this.mArray.add(bArr);
    }

    public void pushDouble(double d7) {
        this.mArray.add(Double.valueOf(d7));
    }

    public void pushInt(int i7) {
        this.mArray.add(Integer.valueOf(i7));
    }

    public void pushMap(ConstraintsMap constraintsMap) {
        this.mArray.add(constraintsMap.toMap());
    }

    public void pushNull() {
        this.mArray.add(null);
    }

    public void pushString(String str) {
        this.mArray.add(str);
    }

    public int size() {
        return this.mArray.size();
    }

    public ArrayList<Object> toArrayList() {
        return this.mArray;
    }

    public ConstraintsArray(ArrayList<Object> arrayList) {
        this.mArray = arrayList;
    }
}
