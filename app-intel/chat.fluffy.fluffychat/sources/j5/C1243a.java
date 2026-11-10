package j5;

import android.view.PointerIcon;
import g5.i;
import java.util.HashMap;

/* renamed from: j5.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1243a {

    /* renamed from: c, reason: collision with root package name */
    public static HashMap f18777c;

    /* renamed from: a, reason: collision with root package name */
    public final c f18778a;

    /* renamed from: b, reason: collision with root package name */
    public final i f18779b;

    /* renamed from: j5.a$a, reason: collision with other inner class name */
    public class C0211a implements i.b {
        public C0211a() {
        }

        @Override // g5.i.b
        public void a(String str) {
            C1243a.this.f18778a.setPointerIcon(C1243a.this.d(str));
        }
    }

    /* renamed from: j5.a$b */
    public class b extends HashMap {
        public b() {
            put("alias", 1010);
            put("allScroll", 1013);
            put("basic", 1000);
            put("cell", 1006);
            put("click", 1002);
            put("contextMenu", 1001);
            put("copy", 1011);
            put("forbidden", 1012);
            put("grab", 1020);
            put("grabbing", 1021);
            put("help", 1003);
            put("move", 1013);
            put("none", 0);
            put("noDrop", 1012);
            put("precise", 1007);
            put("text", 1008);
            put("resizeColumn", 1014);
            put("resizeDown", 1015);
            put("resizeUpLeft", 1016);
            put("resizeDownRight", 1017);
            put("resizeLeft", 1014);
            put("resizeLeftRight", 1014);
            put("resizeRight", 1014);
            put("resizeRow", 1015);
            put("resizeUp", 1015);
            put("resizeUpDown", 1015);
            put("resizeUpLeft", 1017);
            put("resizeUpRight", 1016);
            put("resizeUpLeftDownRight", 1017);
            put("resizeUpRightDownLeft", 1016);
            put("verticalText", 1009);
            put("wait", 1004);
            put("zoomIn", 1018);
            put("zoomOut", 1019);
        }
    }

    /* renamed from: j5.a$c */
    public interface c {
        PointerIcon a(int i7);

        void setPointerIcon(PointerIcon pointerIcon);
    }

    public C1243a(c cVar, i iVar) {
        this.f18778a = cVar;
        this.f18779b = iVar;
        iVar.b(new C0211a());
    }

    public void c() {
        this.f18779b.b(null);
    }

    public final PointerIcon d(String str) {
        if (f18777c == null) {
            f18777c = new b();
        }
        return this.f18778a.a(((Integer) f18777c.getOrDefault(str, 1000)).intValue());
    }
}
