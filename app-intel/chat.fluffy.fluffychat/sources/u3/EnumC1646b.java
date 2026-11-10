package u3;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: u3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class EnumC1646b implements InterfaceC1647c {

    /* renamed from: l, reason: collision with root package name */
    public static final EnumC1646b f22786l = new a("IDENTITY", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final EnumC1646b f22787m = new EnumC1646b("UPPER_CAMEL_CASE", 1) { // from class: u3.b.b
        {
            a aVar = null;
        }

        @Override // u3.InterfaceC1647c
        public String d(Field field) {
            return EnumC1646b.h(field.getName());
        }
    };

    /* renamed from: n, reason: collision with root package name */
    public static final EnumC1646b f22788n = new EnumC1646b("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: u3.b.c
        {
            a aVar = null;
        }

        @Override // u3.InterfaceC1647c
        public String d(Field field) {
            return EnumC1646b.h(EnumC1646b.f(field.getName(), ' '));
        }
    };

    /* renamed from: o, reason: collision with root package name */
    public static final EnumC1646b f22789o = new EnumC1646b("UPPER_CASE_WITH_UNDERSCORES", 3) { // from class: u3.b.d
        {
            a aVar = null;
        }

        @Override // u3.InterfaceC1647c
        public String d(Field field) {
            return EnumC1646b.f(field.getName(), '_').toUpperCase(Locale.ENGLISH);
        }
    };

    /* renamed from: p, reason: collision with root package name */
    public static final EnumC1646b f22790p = new EnumC1646b("LOWER_CASE_WITH_UNDERSCORES", 4) { // from class: u3.b.e
        {
            a aVar = null;
        }

        @Override // u3.InterfaceC1647c
        public String d(Field field) {
            return EnumC1646b.f(field.getName(), '_').toLowerCase(Locale.ENGLISH);
        }
    };

    /* renamed from: q, reason: collision with root package name */
    public static final EnumC1646b f22791q = new EnumC1646b("LOWER_CASE_WITH_DASHES", 5) { // from class: u3.b.f
        {
            a aVar = null;
        }

        @Override // u3.InterfaceC1647c
        public String d(Field field) {
            return EnumC1646b.f(field.getName(), '-').toLowerCase(Locale.ENGLISH);
        }
    };

    /* renamed from: r, reason: collision with root package name */
    public static final EnumC1646b f22792r = new EnumC1646b("LOWER_CASE_WITH_DOTS", 6) { // from class: u3.b.g
        {
            a aVar = null;
        }

        @Override // u3.InterfaceC1647c
        public String d(Field field) {
            return EnumC1646b.f(field.getName(), '.').toLowerCase(Locale.ENGLISH);
        }
    };

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ EnumC1646b[] f22793s = e();

    /* renamed from: u3.b$a */
    public enum a extends EnumC1646b {
        public a(String str, int i7) {
            super(str, i7, null);
        }

        @Override // u3.InterfaceC1647c
        public String d(Field field) {
            return field.getName();
        }
    }

    public EnumC1646b(String str, int i7) {
    }

    public static /* synthetic */ EnumC1646b[] e() {
        return new EnumC1646b[]{f22786l, f22787m, f22788n, f22789o, f22790p, f22791q, f22792r};
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

    public static EnumC1646b valueOf(String str) {
        return (EnumC1646b) Enum.valueOf(EnumC1646b.class, str);
    }

    public static EnumC1646b[] values() {
        return (EnumC1646b[]) f22793s.clone();
    }

    public /* synthetic */ EnumC1646b(String str, int i7, a aVar) {
        this(str, i7);
    }
}
