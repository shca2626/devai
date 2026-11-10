package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class JsonParserSequence extends JsonParserDelegate {
    protected final boolean _checkForExistingToken;
    protected boolean _hasToken;
    protected int _nextParserIndex;
    protected final JsonParser[] _parsers;

    @Deprecated
    public JsonParserSequence(JsonParser[] jsonParserArr) {
        this(false, jsonParserArr);
    }

    public static JsonParserSequence createFlattened(boolean z7, JsonParser jsonParser, JsonParser jsonParser2) {
        boolean z8 = jsonParser instanceof JsonParserSequence;
        if (!z8 && !(jsonParser2 instanceof JsonParserSequence)) {
            return new JsonParserSequence(z7, new JsonParser[]{jsonParser, jsonParser2});
        }
        ArrayList arrayList = new ArrayList();
        if (z8) {
            ((JsonParserSequence) jsonParser).addFlattenedActiveParsers(arrayList);
        } else {
            arrayList.add(jsonParser);
        }
        if (jsonParser2 instanceof JsonParserSequence) {
            ((JsonParserSequence) jsonParser2).addFlattenedActiveParsers(arrayList);
        } else {
            arrayList.add(jsonParser2);
        }
        return new JsonParserSequence(z7, (JsonParser[]) arrayList.toArray(new JsonParser[arrayList.size()]));
    }

    public void addFlattenedActiveParsers(List<JsonParser> list) {
        int length = this._parsers.length;
        for (int i7 = this._nextParserIndex - 1; i7 < length; i7++) {
            JsonParser jsonParser = this._parsers[i7];
            if (jsonParser instanceof JsonParserSequence) {
                ((JsonParserSequence) jsonParser).addFlattenedActiveParsers(list);
            } else {
                list.add(jsonParser);
            }
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        do {
            this.delegate.close();
        } while (switchToNext());
    }

    public int containedParsersCount() {
        return this._parsers.length;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonToken nextToken() {
        JsonParser jsonParser = this.delegate;
        if (jsonParser == null) {
            return null;
        }
        if (this._hasToken) {
            this._hasToken = false;
            return jsonParser.currentToken();
        }
        JsonToken jsonTokenNextToken = jsonParser.nextToken();
        return jsonTokenNextToken == null ? switchAndReturnNext() : jsonTokenNextToken;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonParser skipChildren() {
        if (this.delegate.currentToken() == JsonToken.START_OBJECT || this.delegate.currentToken() == JsonToken.START_ARRAY) {
            int i7 = 1;
            while (true) {
                JsonToken jsonTokenNextToken = nextToken();
                if (jsonTokenNextToken == null) {
                    break;
                }
                if (!jsonTokenNextToken.isStructStart()) {
                    if (jsonTokenNextToken.isStructEnd() && i7 - 1 == 0) {
                        break;
                    }
                } else {
                    i7++;
                }
            }
        }
        return this;
    }

    public JsonToken switchAndReturnNext() {
        JsonToken jsonTokenNextToken;
        do {
            int i7 = this._nextParserIndex;
            JsonParser[] jsonParserArr = this._parsers;
            if (i7 >= jsonParserArr.length) {
                return null;
            }
            this._nextParserIndex = i7 + 1;
            JsonParser jsonParser = jsonParserArr[i7];
            this.delegate = jsonParser;
            if (this._checkForExistingToken && jsonParser.hasCurrentToken()) {
                return this.delegate.getCurrentToken();
            }
            jsonTokenNextToken = this.delegate.nextToken();
        } while (jsonTokenNextToken == null);
        return jsonTokenNextToken;
    }

    public boolean switchToNext() {
        int i7 = this._nextParserIndex;
        JsonParser[] jsonParserArr = this._parsers;
        if (i7 >= jsonParserArr.length) {
            return false;
        }
        this._nextParserIndex = i7 + 1;
        this.delegate = jsonParserArr[i7];
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonParserSequence(boolean z7, JsonParser[] jsonParserArr) {
        super(jsonParserArr[0]);
        boolean z8 = false;
        this._checkForExistingToken = z7;
        if (z7 && this.delegate.hasCurrentToken()) {
            z8 = true;
        }
        this._hasToken = z8;
        this._parsers = jsonParserArr;
        this._nextParserIndex = 1;
    }

    @Deprecated
    public static JsonParserSequence createFlattened(JsonParser jsonParser, JsonParser jsonParser2) {
        return createFlattened(false, jsonParser, jsonParser2);
    }
}
