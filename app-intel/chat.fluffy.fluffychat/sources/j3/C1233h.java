package j3;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* renamed from: j3.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1233h {

    /* renamed from: a, reason: collision with root package name */
    public final String f18716a;

    /* renamed from: j3.h$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final C1233h f18717a;

        /* renamed from: b, reason: collision with root package name */
        public final String f18718b;

        public /* synthetic */ a(C1233h c1233h, String str, AbstractC1232g abstractC1232g) {
            this(c1233h, str);
        }

        public Appendable a(Appendable appendable, Iterator it) throws IOException {
            o.q(appendable);
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                appendable.append(this.f18717a.i(entry.getKey()));
                appendable.append(this.f18718b);
                appendable.append(this.f18717a.i(entry.getValue()));
                while (it.hasNext()) {
                    appendable.append(this.f18717a.f18716a);
                    Map.Entry entry2 = (Map.Entry) it.next();
                    appendable.append(this.f18717a.i(entry2.getKey()));
                    appendable.append(this.f18718b);
                    appendable.append(this.f18717a.i(entry2.getValue()));
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

        public a(C1233h c1233h, String str) {
            this.f18717a = c1233h;
            this.f18718b = (String) o.q(str);
        }
    }

    public C1233h(String str) {
        this.f18716a = (String) o.q(str);
    }

    public static C1233h g(char c7) {
        return new C1233h(String.valueOf(c7));
    }

    public static C1233h h(String str) {
        return new C1233h(str);
    }

    public Appendable b(Appendable appendable, Iterator it) throws IOException {
        o.q(appendable);
        if (it.hasNext()) {
            appendable.append(i(it.next()));
            while (it.hasNext()) {
                appendable.append(this.f18716a);
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
