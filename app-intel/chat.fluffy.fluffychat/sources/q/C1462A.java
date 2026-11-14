package q;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* renamed from: q.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1462A {

    /* renamed from: a, reason: collision with root package name */
    public TextView f21042a;

    /* renamed from: b, reason: collision with root package name */
    public TextClassifier f21043b;

    /* renamed from: q.A$a */
    public static final class a {
        public static TextClassifier a(TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
    }

    public C1462A(TextView textView) {
        this.f21042a = (TextView) Y.h.j(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f21043b;
        return textClassifier == null ? a.a(this.f21042a) : textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f21043b = textClassifier;
    }
}
