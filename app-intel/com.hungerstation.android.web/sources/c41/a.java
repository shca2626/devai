package c41;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

/* loaded from: classes4.dex */
public class a extends PasswordTransformationMethod {

    /* renamed from: c41.a$a, reason: collision with other inner class name */
    private static class C0318a implements CharSequence {

        /* renamed from: b, reason: collision with root package name */
        private CharSequence f16439b;

        public C0318a(CharSequence charSequence) {
            this.f16439b = charSequence;
        }

        @Override // java.lang.CharSequence
        public char charAt(int i12) {
            return '*';
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.f16439b.length();
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i12, int i13) {
            return this.f16439b.subSequence(i12, i13);
        }
    }

    @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        return new C0318a(charSequence);
    }
}
