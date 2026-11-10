package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;

/* loaded from: classes.dex */
public class TokenFilterContext extends JsonStreamContext {
    protected TokenFilterContext _child;
    protected String _currentName;
    protected TokenFilter _filter;
    protected boolean _needToHandleName;
    protected final TokenFilterContext _parent;
    protected boolean _startHandled;

    public TokenFilterContext(int i7, TokenFilterContext tokenFilterContext, TokenFilter tokenFilter, boolean z7) {
        this._type = i7;
        this._parent = tokenFilterContext;
        this._filter = tokenFilter;
        this._index = -1;
        this._startHandled = z7;
        this._needToHandleName = false;
    }

    private void _writePath(JsonGenerator jsonGenerator) {
        TokenFilter tokenFilter = this._filter;
        if (tokenFilter == null || tokenFilter == TokenFilter.INCLUDE_ALL) {
            return;
        }
        TokenFilterContext tokenFilterContext = this._parent;
        if (tokenFilterContext != null) {
            tokenFilterContext._writePath(jsonGenerator);
        }
        if (this._startHandled) {
            if (this._needToHandleName) {
                this._needToHandleName = false;
                jsonGenerator.writeFieldName(this._currentName);
                return;
            }
            return;
        }
        this._startHandled = true;
        int i7 = this._type;
        if (i7 != 2) {
            if (i7 == 1) {
                jsonGenerator.writeStartArray();
            }
        } else {
            jsonGenerator.writeStartObject();
            if (this._needToHandleName) {
                this._needToHandleName = false;
                jsonGenerator.writeFieldName(this._currentName);
            }
        }
    }

    public static TokenFilterContext createRootContext(TokenFilter tokenFilter) {
        return new TokenFilterContext(0, null, tokenFilter, true);
    }

    public void appendDesc(StringBuilder sb) {
        TokenFilterContext tokenFilterContext = this._parent;
        if (tokenFilterContext != null) {
            tokenFilterContext.appendDesc(sb);
        }
        int i7 = this._type;
        if (i7 != 2) {
            if (i7 != 1) {
                sb.append("/");
                return;
            }
            sb.append('[');
            sb.append(getCurrentIndex());
            sb.append(']');
            return;
        }
        sb.append('{');
        if (this._currentName != null) {
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            sb.append(this._currentName);
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        } else {
            sb.append('?');
        }
        sb.append('}');
    }

    public TokenFilter checkValue(TokenFilter tokenFilter) {
        int i7 = this._type;
        if (i7 == 2) {
            return tokenFilter;
        }
        int i8 = this._index + 1;
        this._index = i8;
        return i7 == 1 ? tokenFilter.includeElement(i8) : tokenFilter.includeRootValue(i8);
    }

    public TokenFilterContext closeArray(JsonGenerator jsonGenerator) {
        if (this._startHandled) {
            jsonGenerator.writeEndArray();
        }
        TokenFilter tokenFilter = this._filter;
        if (tokenFilter != null && tokenFilter != TokenFilter.INCLUDE_ALL) {
            tokenFilter.filterFinishArray();
        }
        return this._parent;
    }

    public TokenFilterContext closeObject(JsonGenerator jsonGenerator) {
        if (this._startHandled) {
            jsonGenerator.writeEndObject();
        }
        TokenFilter tokenFilter = this._filter;
        if (tokenFilter != null && tokenFilter != TokenFilter.INCLUDE_ALL) {
            tokenFilter.filterFinishObject();
        }
        return this._parent;
    }

    public TokenFilterContext createChildArrayContext(TokenFilter tokenFilter, boolean z7) {
        TokenFilterContext tokenFilterContext = this._child;
        if (tokenFilterContext != null) {
            return tokenFilterContext.reset(1, tokenFilter, z7);
        }
        TokenFilterContext tokenFilterContext2 = new TokenFilterContext(1, this, tokenFilter, z7);
        this._child = tokenFilterContext2;
        return tokenFilterContext2;
    }

    public TokenFilterContext createChildObjectContext(TokenFilter tokenFilter, boolean z7) {
        TokenFilterContext tokenFilterContext = this._child;
        if (tokenFilterContext != null) {
            return tokenFilterContext.reset(2, tokenFilter, z7);
        }
        TokenFilterContext tokenFilterContext2 = new TokenFilterContext(2, this, tokenFilter, z7);
        this._child = tokenFilterContext2;
        return tokenFilterContext2;
    }

    public TokenFilterContext findChildOf(TokenFilterContext tokenFilterContext) {
        TokenFilterContext tokenFilterContext2 = this._parent;
        if (tokenFilterContext2 == tokenFilterContext) {
            return this;
        }
        while (tokenFilterContext2 != null) {
            TokenFilterContext tokenFilterContext3 = tokenFilterContext2._parent;
            if (tokenFilterContext3 == tokenFilterContext) {
                return tokenFilterContext2;
            }
            tokenFilterContext2 = tokenFilterContext3;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public final String getCurrentName() {
        return this._currentName;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public Object getCurrentValue() {
        return null;
    }

    public TokenFilter getFilter() {
        return this._filter;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public boolean hasCurrentName() {
        return this._currentName != null;
    }

    public boolean isStartHandled() {
        return this._startHandled;
    }

    public JsonToken nextTokenToRead() {
        if (!this._startHandled) {
            this._startHandled = true;
            return this._type == 2 ? JsonToken.START_OBJECT : JsonToken.START_ARRAY;
        }
        if (!this._needToHandleName || this._type != 2) {
            return null;
        }
        this._needToHandleName = false;
        return JsonToken.FIELD_NAME;
    }

    public TokenFilterContext reset(int i7, TokenFilter tokenFilter, boolean z7) {
        this._type = i7;
        this._filter = tokenFilter;
        this._index = -1;
        this._currentName = null;
        this._startHandled = z7;
        this._needToHandleName = false;
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public void setCurrentValue(Object obj) {
    }

    public TokenFilter setFieldName(String str) {
        this._currentName = str;
        this._needToHandleName = true;
        return this._filter;
    }

    public void skipParentChecks() {
        this._filter = null;
        for (TokenFilterContext tokenFilterContext = this._parent; tokenFilterContext != null; tokenFilterContext = tokenFilterContext._parent) {
            this._parent._filter = null;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        appendDesc(sb);
        return sb.toString();
    }

    public void writeImmediatePath(JsonGenerator jsonGenerator) {
        TokenFilter tokenFilter = this._filter;
        if (tokenFilter == null || tokenFilter == TokenFilter.INCLUDE_ALL) {
            return;
        }
        if (this._startHandled) {
            if (this._needToHandleName) {
                jsonGenerator.writeFieldName(this._currentName);
                return;
            }
            return;
        }
        this._startHandled = true;
        int i7 = this._type;
        if (i7 != 2) {
            if (i7 == 1) {
                jsonGenerator.writeStartArray();
            }
        } else {
            jsonGenerator.writeStartObject();
            if (this._needToHandleName) {
                jsonGenerator.writeFieldName(this._currentName);
            }
        }
    }

    public void writePath(JsonGenerator jsonGenerator) {
        TokenFilter tokenFilter = this._filter;
        if (tokenFilter == null || tokenFilter == TokenFilter.INCLUDE_ALL) {
            return;
        }
        TokenFilterContext tokenFilterContext = this._parent;
        if (tokenFilterContext != null) {
            tokenFilterContext._writePath(jsonGenerator);
        }
        if (this._startHandled) {
            if (this._needToHandleName) {
                jsonGenerator.writeFieldName(this._currentName);
                return;
            }
            return;
        }
        this._startHandled = true;
        int i7 = this._type;
        if (i7 == 2) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeFieldName(this._currentName);
        } else if (i7 == 1) {
            jsonGenerator.writeStartArray();
        }
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public final TokenFilterContext getParent() {
        return this._parent;
    }
}
