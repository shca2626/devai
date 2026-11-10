package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public abstract class AnnotatedWithParams extends AnnotatedMember {
    private static final long serialVersionUID = 1;
    protected final AnnotationMap[] _paramAnnotations;

    public AnnotatedWithParams(TypeResolutionContext typeResolutionContext, AnnotationMap annotationMap, AnnotationMap[] annotationMapArr) {
        super(typeResolutionContext, annotationMap);
        this._paramAnnotations = annotationMapArr;
    }

    public final void addOrOverrideParam(int i7, Annotation annotation) {
        AnnotationMap annotationMap = this._paramAnnotations[i7];
        if (annotationMap == null) {
            annotationMap = new AnnotationMap();
            this._paramAnnotations[i7] = annotationMap;
        }
        annotationMap.add(annotation);
    }

    public abstract Object call();

    public abstract Object call(Object[] objArr);

    public abstract Object call1(Object obj);

    public final int getAnnotationCount() {
        return this._annotations.size();
    }

    @Deprecated
    public abstract Type getGenericParameterType(int i7);

    public final AnnotatedParameter getParameter(int i7) {
        return new AnnotatedParameter(this, getParameterType(i7), this._typeContext, getParameterAnnotations(i7), i7);
    }

    public final AnnotationMap getParameterAnnotations(int i7) {
        AnnotationMap[] annotationMapArr = this._paramAnnotations;
        if (annotationMapArr == null || i7 < 0 || i7 >= annotationMapArr.length) {
            return null;
        }
        return annotationMapArr[i7];
    }

    public abstract int getParameterCount();

    public abstract JavaType getParameterType(int i7);

    public abstract Class<?> getRawParameterType(int i7);

    public AnnotatedParameter replaceParameterAnnotations(int i7, AnnotationMap annotationMap) {
        this._paramAnnotations[i7] = annotationMap;
        return getParameter(i7);
    }

    public AnnotatedWithParams(AnnotatedWithParams annotatedWithParams, AnnotationMap[] annotationMapArr) {
        super(annotatedWithParams);
        this._paramAnnotations = annotationMapArr;
    }
}
