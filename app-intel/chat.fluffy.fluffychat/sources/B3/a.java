package B3;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Objects;
import w3.AbstractC1737G;
import w3.v;

/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Class f1132a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f1133b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1134c;

    public a() {
        Type typeE = e();
        this.f1133b = typeE;
        this.f1132a = v.k(typeE);
        this.f1134c = typeE.hashCode();
    }

    public static a a(Class cls) {
        return new a(cls);
    }

    public static a b(Type type) {
        return new a(type);
    }

    public static boolean f() {
        return !Objects.equals(System.getProperty("gson.allowCapturingTypeVariables"), "true");
    }

    public static void g(Type type) {
        if (type instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type;
            throw new IllegalArgumentException("TypeToken type argument must not contain a type variable; captured type variable " + typeVariable.getName() + " declared by " + typeVariable.getGenericDeclaration() + "\nSee " + AbstractC1737G.a("typetoken-type-variable"));
        }
        if (type instanceof GenericArrayType) {
            g(((GenericArrayType) type).getGenericComponentType());
            return;
        }
        int i7 = 0;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType != null) {
                g(ownerType);
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            while (i7 < length) {
                g(actualTypeArguments[i7]);
                i7++;
            }
            return;
        }
        if (!(type instanceof WildcardType)) {
            if (type == null) {
                throw new IllegalArgumentException("TypeToken captured `null` as type argument; probably a compiler / runtime bug");
            }
            return;
        }
        WildcardType wildcardType = (WildcardType) type;
        for (Type type2 : wildcardType.getLowerBounds()) {
            g(type2);
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        int length2 = upperBounds.length;
        while (i7 < length2) {
            g(upperBounds[i7]);
            i7++;
        }
    }

    public final Class c() {
        return this.f1132a;
    }

    public final Type d() {
        return this.f1133b;
    }

    public final Type e() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == a.class) {
                Type typeB = v.b(parameterizedType.getActualTypeArguments()[0]);
                if (f()) {
                    g(typeB);
                }
                return typeB;
            }
        } else if (genericSuperclass == a.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.\nSee " + AbstractC1737G.a("type-token-raw"));
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && v.f(this.f1133b, ((a) obj).f1133b);
    }

    public final int hashCode() {
        return this.f1134c;
    }

    public final String toString() {
        return v.u(this.f1133b);
    }

    public a(Type type) {
        Objects.requireNonNull(type);
        Type typeB = v.b(type);
        this.f1133b = typeB;
        this.f1132a = v.k(typeB);
        this.f1134c = typeB.hashCode();
    }
}
