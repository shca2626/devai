package u3;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: u3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class EnumC1645b implements InterfaceC1646c {

    /* renamed from: l, reason: collision with root package name */
    public static final EnumC1645b f22792l = new a("IDENTITY", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final EnumC1645b f22793m = new EnumC1645b("UPPER_CAMEL_CASE", 1) { // from class: u3.b.b
        {
            a aVar = null;
        }

        @Override // u3.InterfaceC1646c
        public String d(Field field) {
            return EnumC1645b.h(field.getName());
        }
    };

    /* renamed from: n, reason: collision with root package name */
    public static final EnumC1645b f22794n = new EnumC1645b("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: u3.b.c
        {
            a aVar = null;
        }

        @Override // u3.InterfaceC1646c
        public String d(Field field) {
            return EnumC1645b.h(EnumC1645b.f(field.getName(), ' '));
        }
    };

    /* renamed from: o, reason: collision with root package name */
    public static final EnumC1645b f22795o = new EnumC1645b("UPPER_CASE_WITH_UNDERSCORES", 3) { // from class: u3.b.d
        {
            a aVar = null;
        }

        @Override // u3.InterfaceC1646c
        public String d(Field field) {
            return EnumC1645b.f(field.getName(), '_').toUpperCase(Locale.ENGLISH);
        }
    };

    /* renamed from: p, reason: collision with root package name */
    public static final EnumC1645b f22796p = new EnumC1645b("LOWER_CASE_WITH_UNDERSCORES", 4) { // from class: u3.b.e
        {
            a aVar = null;
        }

        @Override // u3.InterfaceC1646c
        public String d(Field field) {
            return EnumC1645b.f(field.getName(), '_').toLowerCase(Locale.ENGLISH);
        }
    };

    /* renamed from: q, reason: collision with root package name */
    public static final EnumC1645b f22797q = new EnumC1645b("LOWER_CASE_WITH_DASHES", 5) { // from class: u3.b.f
        {
            a aVar = null;
        }

        @Override // u3.InterfaceC1646c
        public String d(Field field) {
            return EnumC1645b.f(field.getName(), '-').toLowerCase(Locale.ENGLISH);
        }
    };

    /* renamed from: r, reason: collision with root package name */
    public static final EnumC1645b f22798r = new EnumC1645b("LOWER_CASE_WITH_DOTS", 6) { // from class: u3.b.g
        {
            a aVar = null;
        }

        @Override // u3.InterfaceC1646c
        public String d(Field field) {
            return EnumC1645b.f(field.getName(), '.').toLowerCase(Locale.ENGLISH);
        }
    };

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ EnumC1645b[] f22799s = e();

    /* renamed from: u3.b$a */
    public enum a extends EnumC1645b {
        public a(String str, int i7) {
            super(str, i7, null);
        }

        @Override // u3.InterfaceC1646c
        public String d(Field field) {
            return field.getName();
        }
    }

    public EnumC1645b(String str, int i7) {
    }

    public static /* synthetic */ EnumC1645b[] e() {
        return new EnumC1645b[]{f22792l, f22793m, f22794n, f22795o, f22796p, f22797q, f22798r};
    }

    public static String f(String str, char c7) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(c7);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String h(String str) {
        int length = str.length();
        int i7 = 0;
        while (true) {
            if (i7 >= length) {
                break;
            }
            char cCharAt = str.charAt(i7);
            if (!Character.isLetter(cCharAt)) {
                i7++;
            } else if (!Character.isUpperCase(cCharAt)) {
                char upperCase = Character.toUpperCase(cCharAt);
                if (i7 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i7) + upperCase + str.substring(i7 + 1);
            }
        }
        return str;
    }

    public static EnumC1645b valueOf(String str) {
        return (EnumC1645b) Enum.valueOf(EnumC1645b.class, str);
    }

    public static EnumC1645b[] values() {
        return (EnumC1645b[]) f22799s.clone();
    }

    public /* synthetic */ EnumC1645b(String str, int i7, a aVar) {
        this(str, i7);
    }
}
