package com.facebook.stetho.json.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes8.dex */
public @interface JsonProperty {
    boolean required() default false;
}
