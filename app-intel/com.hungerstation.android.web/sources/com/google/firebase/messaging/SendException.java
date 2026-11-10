package com.google.firebase.messaging;

import java.util.Locale;

/* loaded from: classes8.dex */
public final class SendException extends Exception {

    /* renamed from: b, reason: collision with root package name */
    private final int f24300b;

    SendException(String str) {
        super(str);
        this.f24300b = a(str);
    }

    private int a(String str) {
        if (str == null) {
            return 0;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        lowerCase.hashCode();
        switch (lowerCase) {
        }
        return 0;
    }
}
