package n0;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* renamed from: n0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1340f {

    /* renamed from: a, reason: collision with root package name */
    public final b f19850a;

    /* renamed from: n0.f$a */
    public static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f19851a;

        /* renamed from: b, reason: collision with root package name */
        public final C1338d f19852b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f19853c = true;

        public a(TextView textView) {
            this.f19851a = textView;
            this.f19852b = new C1338d(textView);
        }

        @Override // n0.C1340f.b
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return !this.f19853c ? h(inputFilterArr) : f(inputFilterArr);
        }

        @Override // n0.C1340f.b
        public boolean b() {
            return this.f19853c;
        }

        @Override // n0.C1340f.b
        public void c(boolean z7) {
            if (z7) {
                l();
            }
        }

        @Override // n0.C1340f.b
        public void d(boolean z7) {
            this.f19853c = z7;
            l();
            k();
        }

        @Override // n0.C1340f.b
        public TransformationMethod e(TransformationMethod transformationMethod) {
            return this.f19853c ? m(transformationMethod) : j(transformationMethod);
        }

        public final InputFilter[] f(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f19852b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f19852b;
            return inputFilterArr2;
        }

        public final SparseArray g(InputFilter[] inputFilterArr) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i7 = 0; i7 < inputFilterArr.length; i7++) {
                InputFilter inputFilter = inputFilterArr[i7];
                if (inputFilter instanceof C1338d) {
                    sparseArray.put(i7, inputFilter);
                }
            }
            return sparseArray;
        }

        public final InputFilter[] h(InputFilter[] inputFilterArr) {
            SparseArray sparseArrayG = g(inputFilterArr);
            if (sparseArrayG.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArrayG.size()];
            int i7 = 0;
            for (int i8 = 0; i8 < length; i8++) {
                if (sparseArrayG.indexOfKey(i8) < 0) {
                    inputFilterArr2[i7] = inputFilterArr[i8];
                    i7++;
                }
            }
            return inputFilterArr2;
        }

        public void i(boolean z7) {
            this.f19853c = z7;
        }

        public final TransformationMethod j(TransformationMethod transformationMethod) {
            return transformationMethod instanceof C1342h ? ((C1342h) transformationMethod).a() : transformationMethod;
        }

        public final void k() {
            this.f19851a.setFilters(a(this.f19851a.getFilters()));
        }

        public void l() {
            this.f19851a.setTransformationMethod(e(this.f19851a.getTransformationMethod()));
        }

        public final TransformationMethod m(TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof C1342h) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new C1342h(transformationMethod);
        }
    }

    /* renamed from: n0.f$b */
    public static class b {
        public abstract InputFilter[] a(InputFilter[] inputFilterArr);

        public abstract boolean b();

        public abstract void c(boolean z7);

        public abstract void d(boolean z7);

        public abstract TransformationMethod e(TransformationMethod transformationMethod);
    }

    /* renamed from: n0.f$c */
    public static class c extends b {

        /* renamed from: a, reason: collision with root package name */
        public final a f19854a;

        public c(TextView textView) {
            this.f19854a = new a(textView);
        }

        @Override // n0.C1340f.b
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return f() ? inputFilterArr : this.f19854a.a(inputFilterArr);
        }

        @Override // n0.C1340f.b
        public boolean b() {
            return this.f19854a.b();
        }

        @Override // n0.C1340f.b
        public void c(boolean z7) {
            if (f()) {
                return;
            }
            this.f19854a.c(z7);
        }

        @Override // n0.C1340f.b
        public void d(boolean z7) {
            if (f()) {
                this.f19854a.i(z7);
            } else {
                this.f19854a.d(z7);
            }
        }

        @Override // n0.C1340f.b
        public TransformationMethod e(TransformationMethod transformationMethod) {
            return f() ? transformationMethod : this.f19854a.e(transformationMethod);
        }

        public final boolean f() {
            return !androidx.emoji2.text.c.h();
        }
    }

    public C1340f(TextView textView, boolean z7) {
        Y.h.k(textView, "textView cannot be null");
        if (z7) {
            this.f19850a = new a(textView);
        } else {
            this.f19850a = new c(textView);
        }
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f19850a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f19850a.b();
    }

    public void c(boolean z7) {
        this.f19850a.c(z7);
    }

    public void d(boolean z7) {
        this.f19850a.d(z7);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.f19850a.e(transformationMethod);
    }
}
