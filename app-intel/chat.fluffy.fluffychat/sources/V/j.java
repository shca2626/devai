package V;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class j implements i {

    /* renamed from: a, reason: collision with root package name */
    public final LocaleList f8489a;

    public j(Object obj) {
        this.f8489a = (LocaleList) obj;
    }

    @Override // V.i
    public String a() {
        return this.f8489a.toLanguageTags();
    }

    @Override // V.i
    public Object b() {
        return this.f8489a;
    }

    public boolean equals(Object obj) {
        return this.f8489a.equals(((i) obj).b());
    }

    @Override // V.i
    public Locale get(int i7) {
        return this.f8489a.get(i7);
    }

    public int hashCode() {
        return this.f8489a.hashCode();
    }

    @Override // V.i
    public boolean isEmpty() {
        return this.f8489a.isEmpty();
    }

    @Override // V.i
    public int size() {
        return this.f8489a.size();
    }

    public String toString() {
        return this.f8489a.toString();
    }
}
