package com.adjust.sdk.scheduler;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executors;

/* loaded from: classes7.dex */
public abstract class AsyncTaskExecutor<Params, Result> {

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f18009a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Handler f18010b;

        /* renamed from: com.adjust.sdk.scheduler.AsyncTaskExecutor$a$a, reason: collision with other inner class name */
        public class RunnableC0345a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f18012a;

            public RunnableC0345a(Object obj) {
                this.f18012a = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                AsyncTaskExecutor.this.onPostExecute(this.f18012a);
            }
        }

        public a(Object[] objArr, Handler handler) {
            this.f18009a = objArr;
            this.f18010b = handler;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            this.f18010b.post(new RunnableC0345a(AsyncTaskExecutor.this.doInBackground(this.f18009a)));
        }
    }

    public abstract Result doInBackground(Params[] paramsArr);

    @SafeVarargs
    public final AsyncTaskExecutor<Params, Result> execute(Params... paramsArr) {
        onPreExecute();
        Executors.newSingleThreadExecutor().execute(new a(paramsArr, new Handler(Looper.getMainLooper())));
        return this;
    }

    public void onPostExecute(Result result) {
    }

    public void onPreExecute() {
    }
}
