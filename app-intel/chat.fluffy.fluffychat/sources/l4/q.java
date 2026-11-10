package l4;

import android.graphics.Rect;
import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import k4.s;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final String f19661a = "q";

    public class a implements Comparator {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ s f19662l;

        public a(s sVar) {
            this.f19662l = sVar;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(s sVar, s sVar2) {
            return Float.compare(q.this.c(sVar2, this.f19662l), q.this.c(sVar, this.f19662l));
        }
    }

    public List a(List list, s sVar) {
        if (sVar == null) {
            return list;
        }
        Collections.sort(list, new a(sVar));
        return list;
    }

    public s b(List list, s sVar) {
        List listA = a(list, sVar);
        String str = f19661a;
        Log.i(str, "Viewfinder size: " + sVar);
        Log.i(str, "Preview in order of preference: " + listA);
        return (s) listA.get(0);
    }

    public float c(s sVar, s sVar2) {
        return 0.5f;
    }

    public abstract Rect d(s sVar, s sVar2);
}
