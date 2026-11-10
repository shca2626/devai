package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

/* loaded from: classes7.dex */
public interface CognitoIdentityProviderContinuation<T> {
    void continueTask();

    T getParameters();
}
