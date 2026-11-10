package com.facebook.stetho.inspector.helper;

import android.annotation.TargetApi;
import android.view.ViewDebug;

/* loaded from: classes8.dex */
public class IntegerFormatter {
    private static IntegerFormatter cachedFormatter;

    private static class IntegerFormatterWithHex extends IntegerFormatter {
        private IntegerFormatterWithHex() {
            super();
        }

        @Override // com.facebook.stetho.inspector.helper.IntegerFormatter
        @TargetApi(21)
        public String format(Integer num, ViewDebug.ExportedProperty exportedProperty) {
            if (exportedProperty == null || !exportedProperty.formatToHexString()) {
                return super.format(num, exportedProperty);
            }
            return "0x" + Integer.toHexString(num.intValue());
        }
    }

    public static IntegerFormatter getInstance() {
        if (cachedFormatter == null) {
            synchronized (IntegerFormatter.class) {
                try {
                    if (cachedFormatter == null) {
                        cachedFormatter = new IntegerFormatterWithHex();
                    }
                } finally {
                }
            }
        }
        return cachedFormatter;
    }

    public String format(Integer num, ViewDebug.ExportedProperty exportedProperty) {
        return String.valueOf(num);
    }

    private IntegerFormatter() {
    }
}
