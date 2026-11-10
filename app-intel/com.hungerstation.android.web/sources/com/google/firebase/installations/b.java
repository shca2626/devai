package com.google.firebase.installations;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

/* loaded from: classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private final FileChannel f24265a;

    /* renamed from: b, reason: collision with root package name */
    private final FileLock f24266b;

    private b(FileChannel fileChannel, FileLock fileLock) {
        this.f24265a = fileChannel;
        this.f24266b = fileLock;
    }

    static b a(Context context, String str) throws IOException {
        FileChannel channel;
        FileLock fileLockLock;
        try {
            channel = new RandomAccessFile(new File(context.getFilesDir(), str), "rw").getChannel();
            try {
                fileLockLock = channel.lock();
            } catch (IOException | Error | OverlappingFileLockException unused) {
                fileLockLock = null;
            }
        } catch (IOException | Error | OverlappingFileLockException unused2) {
            channel = null;
            fileLockLock = null;
        }
        try {
            return new b(channel, fileLockLock);
        } catch (IOException | Error | OverlappingFileLockException unused3) {
            if (fileLockLock != null) {
                try {
                    fileLockLock.release();
                } catch (IOException unused4) {
                }
            }
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException unused5) {
                }
            }
            return null;
        }
    }

    void b() throws IOException {
        try {
            this.f24266b.release();
            this.f24265a.close();
        } catch (IOException unused) {
        }
    }
}
