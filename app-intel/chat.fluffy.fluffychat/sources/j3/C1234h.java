package j3;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* renamed from: j3.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1234h {

    /* renamed from: a, reason: collision with root package name */
    public final String f18717a;

    /* renamed from: j3.h$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final C1234h f18718a;

        /* renamed from: b, reason: collision with root package name */
        public final String f18719b;

        public /* synthetic */ a(C1234h c1234h, String str, AbstractC1233g abstractC1233g) {
            this(c1234h, str);
        }

        public Appendable a(Appendable appendable, Iterator it) throws IOException {
            o.q(appendable);
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                appendable.append(this.f18718a.i(entry.getKey()));
                appendable.append(this.f18719b);
                appendable.append(this.f18718a.i(entry.getValue()));
                while (it.hasNext()) {
                    appendable.append(this.f18718a.f18717a);
                    Map.Entry entry2 = (Map.Entry) it.next();
                    appendable.append(this.f18718a.i(entry2.getKey()));
                    appendable.append(this.f18719b);
                    appendable.append(this.f18718a.i(entry2.getValue()));
                }
            }
            return appendable;
        }

        public StringBuilder b(StringBuilder sb, Iterable iterable) {
            return c(sb, iterable.iterator());
        }

        public StringBuilder c(StringBuilder sb, Iterator it) {
            try {
                a(sb, it);
                return sb;
            } catch (IOException e7) {
                throw new AssertionError(e7);
            }
        }

        public a(C1234h c1234h, String str) {
            this.f18718a = c1234h;
            this.f18719b = (String) o.q(str);
        }
    }

    public C1234h(String str) {
        this.f18717a = (String) o.q(str);
    }

    public static C1234h g(char c7) {
        return new C1234h(String.valueOf(c7));
    }

    public static C1234h h(String str) {
        return new C1234h(str);
    }

    public Appendable b(Appendable appendable, Iterator it) throws IOException {
        o.q(appendable);
        if (it.hasNext()) {
            appendable.append(i(it.next()));
            while (it.hasNext()) {
                appendable.append(this.f18717a);
                appendable.append(i(it.next()));
            }
        }
        return appendable;
    }

    public final StringBuilder c(StringBuilder sb, Iterable iterable) {
        return d(sb, iterable.iterator());
    }

    public final StringBuilder d(StringBuilder sb, Iterator it) {
        try {
            b(sb, it);
            return sb;
        } catch (IOException e7) {
            throw new AssertionError(e7);
        }
    }

    public final String e(Iterable iterable) {
        return f(iterable.iterator());
    }

    public final String f(Iterator it) {
        return d(new StringBuilder(), it).toString();
    }

    public CharSequence i(Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public a j(String str) {
        return new a(this, str, null);
    }
}
