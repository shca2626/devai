package K5;

import M5.d;
import M5.m;
import M5.x;

/* loaded from: classes.dex */
public abstract class a {
    public static final Class a(T5.b bVar) {
        m.e(bVar, "<this>");
        Class clsD = ((d) bVar).d();
        m.c(clsD, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return clsD;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Class b(T5.b bVar) {
        m.e(bVar, "<this>");
        Class clsD = ((d) bVar).d();
        if (!clsD.isPrimitive()) {
            m.c(clsD, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return clsD;
        }
        String name = clsD.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    clsD = Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    clsD = Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    clsD = Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    clsD = Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    clsD = Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    clsD = Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    clsD = Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    clsD = Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    clsD = Short.class;
                    break;
                }
                break;
        }
        m.c(clsD, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return clsD;
    }

    public static final T5.b c(Class cls) {
        m.e(cls, "<this>");
        return x.b(cls);
    }
}
