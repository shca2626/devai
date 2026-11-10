package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;

/* loaded from: classes.dex */
public final class JsonReadContext extends JsonStreamContext {
    protected JsonReadContext _child;
    protected int _columnNr;
    protected String _currentName;
    protected Object _currentValue;
    protected DupDetector _dups;
    protected int _lineNr;
    protected final JsonReadContext _parent;

    public JsonReadContext(JsonReadContext jsonReadContext, DupDetector dupDetector, int i7, int i8, int i9) {
        this._parent = jsonReadContext;
        this._dups = dupDetector;
        this._type = i7;
        this._lineNr = i8;
        this._columnNr = i9;
        this._index = -1;
    }

    private void _checkDup(DupDetector dupDetector, String str) throws JsonParseException {
        if (dupDetector.isDup(str)) {
            Object source = dupDetector.getSource();
            throw new JsonParseException(source instanceof JsonParser ? (JsonParser) source : null, "Duplicate field '" + str + "'");
        }
    }

    public static JsonReadContext createRootContext(int i7, int i8, DupDetector dupDetector) {
        return new JsonReadContext(null, dupDetector, 0, i7, i8);
    }

    public JsonReadContext clearAndGetParent() {
        this._currentValue = null;
        return this._parent;
    }

    public JsonReadContext createChildArrayContext(int i7, int i8) {
        JsonReadContext jsonReadContext = this._child;
        if (jsonReadContext != null) {
            jsonReadContext.reset(1, i7, i8);
            return jsonReadContext;
        }
        DupDetector dupDetector = this._dups;
        JsonReadContext jsonReadContext2 = new JsonReadContext(this, dupDetector == null ? null : dupDetector.child(), 1, i7, i8);
        this._child = jsonReadContext2;
        return jsonReadContext2;
    }

    public JsonReadContext createChildObjectContext(int i7, int i8) {
        JsonReadContext jsonReadContext = this._child;
        if (jsonReadContext != null) {
            jsonReadContext.reset(2, i7, i8);
            return jsonReadContext;
        }
        DupDetector dupDetector = this._dups;
        JsonReadContext jsonReadContext2 = new JsonReadContext(this, dupDetector == null ? null : dupDetector.child(), 2, i7, i8);
        this._child = jsonReadContext2;
        return jsonReadContext2;
    }

    public boolean expectComma() {
        int i7 = this._index + 1;
        this._index = i7;
        return this._type != 0 && i7 > 0;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public String getCurrentName() {
        return this._currentName;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public Object getCurrentValue() {
        return this._currentValue;
    }

    public DupDetector getDupDetector() {
        return this._dups;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public JsonLocation getStartLocation(Object obj) {
        return new JsonLocation(obj, -1L, this._lineNr, this._columnNr);
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public boolean hasCurrentName() {
        return this._currentName != null;
    }

    public void reset(int i7, int i8, int i9) {
        this._type = i7;
        this._index = -1;
        this._lineNr = i8;
        this._columnNr = i9;
        this._currentName = null;
        this._currentValue = null;
        DupDetector dupDetector = this._dups;
        if (dupDetector != null) {
            dupDetector.reset();
        }
    }

    public void setCurrentName(String str) throws JsonParseException {
        this._currentName = str;
        DupDetector dupDetector = this._dups;
        if (dupDetector != null) {
            _checkDup(dupDetector, str);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public void setCurrentValue(Object obj) {
        this._currentValue = obj;
    }

    public JsonReadContext withDupDetector(DupDetector dupDetector) {
        this._dups = dupDetector;
        return this;
    }

    public static JsonReadContext createRootContext(DupDetector dupDetector) {
        return new JsonReadContext(null, dupDetector, 0, 1, 0);
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public JsonReadContext getParent() {
        return this._parent;
    }
}
