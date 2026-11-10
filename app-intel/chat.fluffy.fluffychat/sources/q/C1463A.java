package q;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* renamed from: q.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1463A {

    /* renamed from: a, reason: collision with root package name */
    public TextView f21036a;

    /* renamed from: b, reason: collision with root package name */
    public TextClassifier f21037b;

    /* renamed from: q.A$a */
    public static final class a {
        public static TextClassifier a(TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
    }

    public C1463A(TextView textView) {
        this.f21036a = (TextView) Y.h.j(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f21037b;
        return textClassifier == null ? a.a(this.f21036a) : textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f21037b = textClassifier;
    }
}
