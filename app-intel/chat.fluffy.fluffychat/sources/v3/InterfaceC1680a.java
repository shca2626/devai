package v3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* renamed from: v3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public @interface InterfaceC1680a {
    boolean deserialize() default true;

    boolean serialize() default true;
}
