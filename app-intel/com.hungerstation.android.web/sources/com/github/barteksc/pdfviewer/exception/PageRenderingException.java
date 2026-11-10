package com.github.barteksc.pdfviewer.exception;

/* loaded from: classes8.dex */
public class PageRenderingException extends Exception {

    /* renamed from: b, reason: collision with root package name */
    private final int f20003b;

    public PageRenderingException(int i12, Throwable th2) {
        super(th2);
        this.f20003b = i12;
    }

    public int b() {
        return this.f20003b;
    }
}
