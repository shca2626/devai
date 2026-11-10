package H3;

import android.content.Intent;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f3407a = Pattern.compile(",");

    /* renamed from: b, reason: collision with root package name */
    public static final Set f3408b;

    /* renamed from: c, reason: collision with root package name */
    public static final Set f3409c;

    /* renamed from: d, reason: collision with root package name */
    public static final Set f3410d;

    /* renamed from: e, reason: collision with root package name */
    public static final Set f3411e;

    /* renamed from: f, reason: collision with root package name */
    public static final Set f3412f;

    /* renamed from: g, reason: collision with root package name */
    public static final Set f3413g;

    /* renamed from: h, reason: collision with root package name */
    public static final Set f3414h;

    /* renamed from: i, reason: collision with root package name */
    public static final Map f3415i;

    static {
        EnumSet enumSetOf = EnumSet.of(D3.a.QR_CODE);
        f3411e = enumSetOf;
        EnumSet enumSetOf2 = EnumSet.of(D3.a.DATA_MATRIX);
        f3412f = enumSetOf2;
        EnumSet enumSetOf3 = EnumSet.of(D3.a.AZTEC);
        f3413g = enumSetOf3;
        EnumSet enumSetOf4 = EnumSet.of(D3.a.PDF_417);
        f3414h = enumSetOf4;
        EnumSet enumSetOf5 = EnumSet.of(D3.a.UPC_A, D3.a.UPC_E, D3.a.EAN_13, D3.a.EAN_8, D3.a.RSS_14, D3.a.RSS_EXPANDED);
        f3408b = enumSetOf5;
        EnumSet enumSetOf6 = EnumSet.of(D3.a.CODE_39, D3.a.CODE_93, D3.a.CODE_128, D3.a.ITF, D3.a.CODABAR);
        f3409c = enumSetOf6;
        EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) enumSetOf5);
        f3410d = enumSetCopyOf;
        enumSetCopyOf.addAll(enumSetOf6);
        HashMap map = new HashMap();
        f3415i = map;
        map.put("ONE_D_MODE", enumSetCopyOf);
        map.put("PRODUCT_MODE", enumSetOf5);
        map.put("QR_CODE_MODE", enumSetOf);
        map.put("DATA_MATRIX_MODE", enumSetOf2);
        map.put("AZTEC_MODE", enumSetOf3);
        map.put("PDF417_MODE", enumSetOf4);
    }

    public static Set a(Intent intent) {
        String stringExtra = intent.getStringExtra("SCAN_FORMATS");
        return b(stringExtra != null ? Arrays.asList(f3407a.split(stringExtra)) : null, intent.getStringExtra("SCAN_MODE"));
    }

    public static Set b(Iterable iterable, String str) {
        if (iterable != null) {
            EnumSet enumSetNoneOf = EnumSet.noneOf(D3.a.class);
            try {
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    enumSetNoneOf.add(D3.a.valueOf((String) it.next()));
                }
                return enumSetNoneOf;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str != null) {
            return (Set) f3415i.get(str);
        }
        return null;
    }
}
