package com.facebook.stetho.inspector.database;

import android.annotation.TargetApi;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes8.dex */
public abstract class SQLiteDatabaseCompat {
    public static final int ENABLE_FOREIGN_KEY_CONSTRAINTS = 2;
    public static final int ENABLE_WRITE_AHEAD_LOGGING = 1;
    private static final SQLiteDatabaseCompat sInstance = new JellyBeanAndBeyondImpl();

    @TargetApi(14)
    private static class IceCreamSandwichImpl extends SQLiteDatabaseCompat {
        private IceCreamSandwichImpl() {
        }

        @Override // com.facebook.stetho.inspector.database.SQLiteDatabaseCompat
        public void enableFeatures(@SQLiteOpenOptions int i12, SQLiteDatabase sQLiteDatabase) throws SQLException {
            if ((i12 & 1) != 0) {
                sQLiteDatabase.enableWriteAheadLogging();
            }
            if ((i12 & 2) != 0) {
                sQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
            }
        }

        @Override // com.facebook.stetho.inspector.database.SQLiteDatabaseCompat
        public int provideOpenFlags(@SQLiteOpenOptions int i12) {
            return 0;
        }
    }

    @TargetApi(16)
    private static class JellyBeanAndBeyondImpl extends SQLiteDatabaseCompat {
        private JellyBeanAndBeyondImpl() {
        }

        @Override // com.facebook.stetho.inspector.database.SQLiteDatabaseCompat
        public void enableFeatures(@SQLiteOpenOptions int i12, SQLiteDatabase sQLiteDatabase) {
            if ((i12 & 2) != 0) {
                sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
            }
        }

        @Override // com.facebook.stetho.inspector.database.SQLiteDatabaseCompat
        public int provideOpenFlags(@SQLiteOpenOptions int i12) {
            return (i12 & 1) != 0 ? 536870912 : 0;
        }
    }

    public @interface SQLiteOpenOptions {
    }

    public static SQLiteDatabaseCompat getInstance() {
        return sInstance;
    }

    public abstract void enableFeatures(@SQLiteOpenOptions int i12, SQLiteDatabase sQLiteDatabase);

    public abstract int provideOpenFlags(@SQLiteOpenOptions int i12);
}
