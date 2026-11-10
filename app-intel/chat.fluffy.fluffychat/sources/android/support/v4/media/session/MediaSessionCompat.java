package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.util.Log;
import b2.InterfaceC0841c;

/* loaded from: classes.dex */
public abstract class MediaSessionCompat {

    @SuppressLint({"BanParcelableUsage"})
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();

        /* renamed from: l, reason: collision with root package name */
        public final MediaDescriptionCompat f10944l;

        /* renamed from: m, reason: collision with root package name */
        public final long f10945m;

        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public QueueItem[] newArray(int i7) {
                return new QueueItem[i7];
            }
        }

        public QueueItem(Parcel parcel) {
            this.f10944l = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f10945m = parcel.readLong();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f10944l + ", Id=" + this.f10945m + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            this.f10944l.writeToParcel(parcel, i7);
            parcel.writeLong(this.f10945m);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();

        /* renamed from: l, reason: collision with root package name */
        public ResultReceiver f10946l;

        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper[] newArray(int i7) {
                return new ResultReceiverWrapper[i7];
            }
        }

        public ResultReceiverWrapper(Parcel parcel) {
            this.f10946l = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            this.f10946l.writeToParcel(parcel, i7);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();

        /* renamed from: l, reason: collision with root package name */
        public final Object f10947l;

        /* renamed from: m, reason: collision with root package name */
        public final Object f10948m;

        /* renamed from: n, reason: collision with root package name */
        public android.support.v4.media.session.a f10949n;

        /* renamed from: o, reason: collision with root package name */
        public InterfaceC0841c f10950o;

        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable(null));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Token[] newArray(int i7) {
                return new Token[i7];
            }
        }

        public Token(Object obj) {
            this(obj, null, null);
        }

        public Object b() {
            return this.f10948m;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f10948m;
            if (obj2 == null) {
                return token.f10948m == null;
            }
            Object obj3 = token.f10948m;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        public int hashCode() {
            Object obj = this.f10948m;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            parcel.writeParcelable((Parcelable) this.f10948m, i7);
        }

        public Token(Object obj, android.support.v4.media.session.a aVar, InterfaceC0841c interfaceC0841c) {
            this.f10947l = new Object();
            this.f10948m = obj;
            this.f10949n = aVar;
            this.f10950o = interfaceC0841c;
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static Bundle b(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        a(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }
}
