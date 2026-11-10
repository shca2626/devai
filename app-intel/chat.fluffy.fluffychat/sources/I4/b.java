package I4;

import M5.m;

/* loaded from: classes.dex */
public abstract class b {

    public static final class a extends b {

        /* renamed from: a, reason: collision with root package name */
        public final String f4271a;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // I4.b
        public String a() {
            return this.f4271a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && m.a(this.f4271a, ((a) obj).f4271a);
        }

        public int hashCode() {
            return this.f4271a.hashCode();
        }

        public String toString() {
            return "BluetoothHeadset(name=" + this.f4271a + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(null);
            m.e(str, "name");
            this.f4271a = str;
        }

        public /* synthetic */ a(String str, int i7, M5.g gVar) {
            this((i7 & 1) != 0 ? "Bluetooth" : str);
        }
    }

    /* renamed from: I4.b$b, reason: collision with other inner class name */
    public static final class C0041b extends b {

        /* renamed from: a, reason: collision with root package name */
        public final String f4272a;

        /* JADX WARN: Multi-variable type inference failed */
        public C0041b() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // I4.b
        public String a() {
            return this.f4272a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0041b) && m.a(this.f4272a, ((C0041b) obj).f4272a);
        }

        public int hashCode() {
            return this.f4272a.hashCode();
        }

        public String toString() {
            return "Earpiece(name=" + this.f4272a + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0041b(String str) {
            super(null);
            m.e(str, "name");
            this.f4272a = str;
        }

        public /* synthetic */ C0041b(String str, int i7, M5.g gVar) {
            this((i7 & 1) != 0 ? "Earpiece" : str);
        }
    }

    public static final class c extends b {

        /* renamed from: a, reason: collision with root package name */
        public final String f4273a;

        /* JADX WARN: Multi-variable type inference failed */
        public c() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // I4.b
        public String a() {
            return this.f4273a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && m.a(this.f4273a, ((c) obj).f4273a);
        }

        public int hashCode() {
            return this.f4273a.hashCode();
        }

        public String toString() {
            return "Speakerphone(name=" + this.f4273a + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(null);
            m.e(str, "name");
            this.f4273a = str;
        }

        public /* synthetic */ c(String str, int i7, M5.g gVar) {
            this((i7 & 1) != 0 ? "Speakerphone" : str);
        }
    }

    public static final class d extends b {

        /* renamed from: a, reason: collision with root package name */
        public final String f4274a;

        /* JADX WARN: Multi-variable type inference failed */
        public d() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // I4.b
        public String a() {
            return this.f4274a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && m.a(this.f4274a, ((d) obj).f4274a);
        }

        public int hashCode() {
            return this.f4274a.hashCode();
        }

        public String toString() {
            return "WiredHeadset(name=" + this.f4274a + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(null);
            m.e(str, "name");
            this.f4274a = str;
        }

        public /* synthetic */ d(String str, int i7, M5.g gVar) {
            this((i7 & 1) != 0 ? "Wired Headset" : str);
        }
    }

    public /* synthetic */ b(M5.g gVar) {
        this();
    }

    public abstract String a();

    public b() {
    }
}
