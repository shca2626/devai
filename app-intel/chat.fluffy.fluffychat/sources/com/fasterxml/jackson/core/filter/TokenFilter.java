package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.JsonParser;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class TokenFilter {
    public static final TokenFilter INCLUDE_ALL = new TokenFilter();

    public boolean _includeScalar() {
        return true;
    }

    public void filterFinishArray() {
    }

    public void filterFinishObject() {
    }

    public TokenFilter filterStartArray() {
        return this;
    }

    public TokenFilter filterStartObject() {
        return this;
    }

    public boolean includeBinary() {
        return _includeScalar();
    }

    public boolean includeBoolean(boolean z7) {
        return _includeScalar();
    }

    public TokenFilter includeElement(int i7) {
        return this;
    }

    public boolean includeEmbeddedValue(Object obj) {
        return _includeScalar();
    }

    public boolean includeNull() {
        return _includeScalar();
    }

    public boolean includeNumber(int i7) {
        return _includeScalar();
    }

    public TokenFilter includeProperty(String str) {
        return this;
    }

    public boolean includeRawValue() {
        return _includeScalar();
    }

    public TokenFilter includeRootValue(int i7) {
        return this;
    }

    public boolean includeString(String str) {
        return _includeScalar();
    }

    public boolean includeValue(JsonParser jsonParser) {
        return _includeScalar();
    }

    public String toString() {
        return this == INCLUDE_ALL ? "TokenFilter.INCLUDE_ALL" : super.toString();
    }

    public boolean includeNumber(long j7) {
        return _includeScalar();
    }

    public boolean includeString(Reader reader, int i7) {
        return _includeScalar();
    }

    public boolean includeNumber(float f7) {
        return _includeScalar();
    }

    public boolean includeNumber(double d7) {
        return _includeScalar();
    }

    public boolean includeNumber(BigDecimal bigDecimal) {
        return _includeScalar();
    }

    public boolean includeNumber(BigInteger bigInteger) {
        return _includeScalar();
    }
}
