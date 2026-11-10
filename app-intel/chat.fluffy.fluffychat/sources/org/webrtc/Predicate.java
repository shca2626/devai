package org.webrtc;

/* loaded from: classes3.dex */
public interface Predicate<T> {
    default Predicate<T> and(final Predicate<? super T> predicate) {
        return new Predicate<T>(this) { // from class: org.webrtc.Predicate.2
            final /* synthetic */ Predicate this$0;

            {
                this.this$0 = this;
            }

            @Override // org.webrtc.Predicate
            public boolean test(T t7) {
                return this.this$0.test(t7) && predicate.test(t7);
            }
        };
    }

    default Predicate<T> negate() {
        return new Predicate<T>() { // from class: org.webrtc.Predicate.3
            @Override // org.webrtc.Predicate
            public boolean test(T t7) {
                return !Predicate.this.test(t7);
            }
        };
    }

    default Predicate<T> or(final Predicate<? super T> predicate) {
        return new Predicate<T>(this) { // from class: org.webrtc.Predicate.1
            final /* synthetic */ Predicate this$0;

            {
                this.this$0 = this;
            }

            @Override // org.webrtc.Predicate
            public boolean test(T t7) {
                return this.this$0.test(t7) || predicate.test(t7);
            }
        };
    }

    boolean test(T t7);
}
