package i4;

import android.content.SharedPreferences;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class x {
    public static void a(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2, SharedPreferences sharedPreferences3, y yVar, t tVar, String str) {
        int i7;
        String strH = h(yVar, tVar);
        if ("complete".equals(strH) || "deleted".equals(strH)) {
            Log.d("MigrationBackup", "Backup already exists (status: " + strH + "), skipping");
            return;
        }
        if ("started".equals(strH)) {
            Log.w("MigrationBackup", "Found incomplete backup (status: started), deleting and restarting");
            e(sharedPreferences, sharedPreferences2, sharedPreferences3, str);
        }
        Log.i("MigrationBackup", "Starting backup creation (rename operation)...");
        j(yVar, tVar, "started");
        int i8 = 0;
        if (sharedPreferences3 != null) {
            Log.i("MigrationBackup", "Backing up EncryptedSharedPreferences data with _BACKUP suffix...");
            try {
                SharedPreferences.Editor editorEdit = sharedPreferences3.edit();
                i7 = 0;
                for (Map.Entry<String, ?> entry : sharedPreferences3.getAll().entrySet()) {
                    String key = entry.getKey();
                    if ((entry.getValue() instanceof String) && key.contains(str) && !key.endsWith("_BACKUP")) {
                        editorEdit.putString(key + "_BACKUP", (String) entry.getValue());
                        i7++;
                    }
                }
                if (!editorEdit.commit()) {
                    throw new RuntimeException("Failed to copy ESP data to backup");
                }
                Log.i("MigrationBackup", "Backed up " + i7 + " items in ESP");
            } catch (Exception e7) {
                Log.w("MigrationBackup", "ESP backup failed (ESP corrupted): " + e7.getMessage());
                Log.w("MigrationBackup", "Skipping ESP backup - migration will use algorithm mismatch recovery");
            }
        } else {
            i7 = 0;
        }
        SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
        int i9 = 0;
        for (Map.Entry<String, ?> entry2 : sharedPreferences.getAll().entrySet()) {
            String key2 = entry2.getKey();
            if ((entry2.getValue() instanceof String) && key2.contains(str) && !key2.endsWith("_BACKUP")) {
                editorEdit2.putString(key2 + "_BACKUP", (String) entry2.getValue());
                i9++;
            }
        }
        if (!editorEdit2.commit()) {
            throw new RuntimeException("Failed to copy encrypted data to backup");
        }
        SharedPreferences.Editor editorEdit3 = sharedPreferences2.edit();
        for (Map.Entry<String, ?> entry3 : sharedPreferences2.getAll().entrySet()) {
            String key3 = entry3.getKey();
            if ((entry3.getValue() instanceof String) && !key3.endsWith("_BACKUP")) {
                editorEdit3.putString(key3 + "_BACKUP", (String) entry3.getValue());
                i8++;
            }
        }
        if (!editorEdit3.commit()) {
            throw new RuntimeException("Failed to copy wrapped keys to backup");
        }
        j(yVar, tVar, "complete");
        Log.i("MigrationBackup", "Backup complete: " + i9 + " data items, " + i8 + " wrapped keys, " + i7 + " ESP items - originals preserved until migration succeeds");
    }

    public static void b(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2, y yVar, t tVar, String str) {
        a(sharedPreferences, sharedPreferences2, null, yVar, tVar, str);
    }

    public static void c(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2, SharedPreferences sharedPreferences3, y yVar, t tVar, String str) {
        e(sharedPreferences, sharedPreferences2, sharedPreferences3, str);
        yVar.b().remove("FlutterSecureStorageBackupStatus").commit();
        Log.d("MigrationBackup", "Backup deleted and status key removed");
    }

    public static void d(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2, y yVar, t tVar, String str) {
        c(sharedPreferences, sharedPreferences2, null, yVar, tVar, str);
    }

    public static void e(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2, SharedPreferences sharedPreferences3, String str) {
        int i7;
        int i8 = 0;
        if (sharedPreferences3 != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences3.edit();
            Iterator<Map.Entry<String, ?>> it = sharedPreferences3.getAll().entrySet().iterator();
            i7 = 0;
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (key.endsWith("_BACKUP") && key.contains(str)) {
                    editorEdit.remove(key);
                    i7++;
                }
            }
            editorEdit.commit();
        } else {
            i7 = 0;
        }
        SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
        Iterator<Map.Entry<String, ?>> it2 = sharedPreferences.getAll().entrySet().iterator();
        int i9 = 0;
        while (it2.hasNext()) {
            String key2 = it2.next().getKey();
            if (key2.endsWith("_BACKUP") && key2.contains(str)) {
                editorEdit2.remove(key2);
                i9++;
            }
        }
        editorEdit2.commit();
        SharedPreferences.Editor editorEdit3 = sharedPreferences2.edit();
        Iterator<Map.Entry<String, ?>> it3 = sharedPreferences2.getAll().entrySet().iterator();
        while (it3.hasNext()) {
            String key3 = it3.next().getKey();
            if (key3.endsWith("_BACKUP")) {
                editorEdit3.remove(key3);
                i8++;
            }
        }
        editorEdit3.commit();
        if (i9 > 0 || i8 > 0 || i7 > 0) {
            Log.d("MigrationBackup", "Deleted " + i9 + " data _BACKUP entries, " + i8 + " key _BACKUP entries, " + i7 + " ESP _BACKUP entries");
        }
    }

    public static void f(y yVar, String str) {
        SharedPreferences.Editor editorB = yVar.b();
        Iterator it = yVar.c().entrySet().iterator();
        int i7 = 0;
        while (it.hasNext()) {
            String str2 = (String) ((Map.Entry) it.next()).getKey();
            if (str2.endsWith("_MIGRATED") && str2.contains(str)) {
                editorB.remove(str2);
                i7++;
            }
        }
        editorB.commit();
        if (i7 > 0) {
            Log.d("MigrationBackup", "Deleted " + i7 + " _MIGRATED marker entries from configSource");
        }
    }

    public static void g(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2, y yVar, String str) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Iterator<Map.Entry<String, ?>> it = sharedPreferences.getAll().entrySet().iterator();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (!key.endsWith("_BACKUP") && key.contains(str)) {
                if (yVar != null) {
                    if (yVar.a(key + "_MIGRATED")) {
                        Log.d("MigrationBackup", "Preserving already-migrated key in dataSource: " + key);
                        i9++;
                    }
                }
                editorEdit.remove(key);
                i8++;
            }
        }
        editorEdit.commit();
        if (yVar == null || !i(yVar, str)) {
            SharedPreferences.Editor editorEdit2 = sharedPreferences2.edit();
            Iterator<Map.Entry<String, ?>> it2 = sharedPreferences2.getAll().entrySet().iterator();
            while (it2.hasNext()) {
                String key2 = it2.next().getKey();
                if (!key2.endsWith("_BACKUP")) {
                    editorEdit2.remove(key2);
                    i7++;
                }
            }
            editorEdit2.commit();
        } else {
            Log.d("MigrationBackup", "Preserving keyStorage originals (new wrapped AES key) — already-migrated keys exist");
        }
        Log.d("MigrationBackup", "Deleted " + i8 + " original data entries (preserved " + i9 + " already-migrated), " + i7 + " original key entries");
    }

    public static String h(y yVar, t tVar) {
        return yVar.e("FlutterSecureStorageBackupStatus", null);
    }

    public static boolean i(y yVar, String str) {
        Iterator it = yVar.c().entrySet().iterator();
        while (it.hasNext()) {
            String str2 = (String) ((Map.Entry) it.next()).getKey();
            if (str2.endsWith("_MIGRATED") && str2.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static void j(y yVar, t tVar, String str) {
        if (tVar.w()) {
            yVar.b().putString("FlutterSecureStorageBackupStatus", str).commit();
        }
    }
}
