package a0;

import android.view.accessibility.AccessibilityManager;

/* renamed from: a0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0746c {

    /* renamed from: a0.c$a */
    public interface a {
        void onTouchExplorationStateChanged(boolean z7);
    }

    /* renamed from: a0.c$b */
    public static final class b implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final a f10482a;

        public b(a aVar) {
            this.f10482a = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f10482a.equals(((b) obj).f10482a);
            }
            return false;
        }

        public int hashCode() {
            return this.f10482a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z7) {
            this.f10482a.onTouchExplorationStateChanged(z7);
        }
    }

    public static boolean a(AccessibilityManager accessibilityManager, a aVar) {
        return accessibilityManager.addTouchExplorationStateChangeListener(new b(aVar));
    }

    public static boolean b(AccessibilityManager accessibilityManager, a aVar) {
        return accessibilityManager.removeTouchExplorationStateChangeListener(new b(aVar));
    }
}
