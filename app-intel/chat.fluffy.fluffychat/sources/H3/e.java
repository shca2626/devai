package H3;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.Log;
import java.io.IOException;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: d, reason: collision with root package name */
    public static final String f3403d = "e";

    /* renamed from: a, reason: collision with root package name */
    public final Context f3404a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3405b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3406c = false;

    public e(Activity activity) {
        activity.setVolumeControlStream(3);
        this.f3404a = activity.getApplicationContext();
    }

    public static /* synthetic */ void a(MediaPlayer mediaPlayer) throws IllegalStateException {
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
    }

    public static /* synthetic */ boolean b(MediaPlayer mediaPlayer, int i7, int i8) throws IllegalStateException {
        Log.w(f3403d, "Failed to beep " + i7 + ", " + i8);
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
        return true;
    }

    public MediaPlayer c() throws IllegalStateException, Resources.NotFoundException, IOException, IllegalArgumentException {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).build());
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: H3.c
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer2) throws IllegalStateException {
                e.a(mediaPlayer2);
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: H3.d
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer2, int i7, int i8) {
                return e.b(mediaPlayer2, i7, i8);
            }
        });
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = this.f3404a.getResources().openRawResourceFd(m.f3445a);
            try {
                mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                assetFileDescriptorOpenRawResourceFd.close();
                mediaPlayer.setVolume(0.1f, 0.1f);
                mediaPlayer.prepare();
                mediaPlayer.start();
                return mediaPlayer;
            } catch (Throwable th) {
                assetFileDescriptorOpenRawResourceFd.close();
                throw th;
            }
        } catch (IOException e7) {
            Log.w(f3403d, e7);
            mediaPlayer.reset();
            mediaPlayer.release();
            return null;
        }
    }

    public synchronized void d() {
        Vibrator vibrator;
        try {
            if (this.f3405b) {
                c();
            }
            if (this.f3406c && (vibrator = (Vibrator) this.f3404a.getSystemService("vibrator")) != null) {
                vibrator.vibrate(200L);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void e(boolean z7) {
        this.f3405b = z7;
    }
}
