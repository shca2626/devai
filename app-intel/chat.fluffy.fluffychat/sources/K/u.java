package K;

import android.app.Person;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f4980a;

    /* renamed from: b, reason: collision with root package name */
    public IconCompat f4981b;

    /* renamed from: c, reason: collision with root package name */
    public String f4982c;

    /* renamed from: d, reason: collision with root package name */
    public String f4983d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4984e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4985f;

    public static class a {
        public static u a(PersistableBundle persistableBundle) {
            return new c().f(persistableBundle.getString("name")).g(persistableBundle.getString("uri")).e(persistableBundle.getString("key")).b(persistableBundle.getBoolean("isBot")).d(persistableBundle.getBoolean("isImportant")).a();
        }

        public static PersistableBundle b(u uVar) {
            PersistableBundle persistableBundle = new PersistableBundle();
            CharSequence charSequence = uVar.f4980a;
            persistableBundle.putString("name", charSequence != null ? charSequence.toString() : null);
            persistableBundle.putString("uri", uVar.f4982c);
            persistableBundle.putString("key", uVar.f4983d);
            persistableBundle.putBoolean("isBot", uVar.f4984e);
            persistableBundle.putBoolean("isImportant", uVar.f4985f);
            return persistableBundle;
        }
    }

    public static class b {
        public static u a(Person person) {
            return new c().f(person.getName()).c(person.getIcon() != null ? IconCompat.e(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        public static Person b(u uVar) {
            return new Person.Builder().setName(uVar.f()).setIcon(uVar.d() != null ? uVar.d().z() : null).setUri(uVar.g()).setKey(uVar.e()).setBot(uVar.h()).setImportant(uVar.i()).build();
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public CharSequence f4986a;

        /* renamed from: b, reason: collision with root package name */
        public IconCompat f4987b;

        /* renamed from: c, reason: collision with root package name */
        public String f4988c;

        /* renamed from: d, reason: collision with root package name */
        public String f4989d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f4990e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f4991f;

        public u a() {
            return new u(this);
        }

        public c b(boolean z7) {
            this.f4990e = z7;
            return this;
        }

        public c c(IconCompat iconCompat) {
            this.f4987b = iconCompat;
            return this;
        }

        public c d(boolean z7) {
            this.f4991f = z7;
            return this;
        }

        public c e(String str) {
            this.f4989d = str;
            return this;
        }

        public c f(CharSequence charSequence) {
            this.f4986a = charSequence;
            return this;
        }

        public c g(String str) {
            this.f4988c = str;
            return this;
        }
    }

    public u(c cVar) {
        this.f4980a = cVar.f4986a;
        this.f4981b = cVar.f4987b;
        this.f4982c = cVar.f4988c;
        this.f4983d = cVar.f4989d;
        this.f4984e = cVar.f4990e;
        this.f4985f = cVar.f4991f;
    }

    public static u a(Person person) {
        return b.a(person);
    }

    public static u b(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("icon");
        return new c().f(bundle.getCharSequence("name")).c(bundle2 != null ? IconCompat.c(bundle2) : null).g(bundle.getString("uri")).e(bundle.getString("key")).b(bundle.getBoolean("isBot")).d(bundle.getBoolean("isImportant")).a();
    }

    public static u c(PersistableBundle persistableBundle) {
        return a.a(persistableBundle);
    }

    public IconCompat d() {
        return this.f4981b;
    }

    public String e() {
        return this.f4983d;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        String strE = e();
        String strE2 = uVar.e();
        return (strE == null && strE2 == null) ? Objects.equals(Objects.toString(f()), Objects.toString(uVar.f())) && Objects.equals(g(), uVar.g()) && Boolean.valueOf(h()).equals(Boolean.valueOf(uVar.h())) && Boolean.valueOf(i()).equals(Boolean.valueOf(uVar.i())) : Objects.equals(strE, strE2);
    }

    public CharSequence f() {
        return this.f4980a;
    }

    public String g() {
        return this.f4982c;
    }

    public boolean h() {
        return this.f4984e;
    }

    public int hashCode() {
        String strE = e();
        return strE != null ? strE.hashCode() : Objects.hash(f(), g(), Boolean.valueOf(h()), Boolean.valueOf(i()));
    }

    public boolean i() {
        return this.f4985f;
    }

    public String j() {
        String str = this.f4982c;
        if (str != null) {
            return str;
        }
        if (this.f4980a == null) {
            return "";
        }
        return "name:" + ((Object) this.f4980a);
    }

    public Person k() {
        return b.b(this);
    }

    public Bundle l() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f4980a);
        IconCompat iconCompat = this.f4981b;
        bundle.putBundle("icon", iconCompat != null ? iconCompat.y() : null);
        bundle.putString("uri", this.f4982c);
        bundle.putString("key", this.f4983d);
        bundle.putBoolean("isBot", this.f4984e);
        bundle.putBoolean("isImportant", this.f4985f);
        return bundle;
    }

    public PersistableBundle m() {
        return a.b(this);
    }
}
