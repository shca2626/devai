package com.amazonaws.mobile.config;

import android.content.Context;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class AWSConfiguration {
    private static final String DEFAULT = "Default";
    private static final String DEFAULT_IDENTIFIER = "awsconfiguration";
    private String configName;
    private JSONObject mJSONObject;

    public AWSConfiguration(Context context) {
        this(context, getConfigResourceId(context));
    }

    private static int getConfigResourceId(Context context) {
        try {
            return context.getResources().getIdentifier(DEFAULT_IDENTIFIER, "raw", context.getPackageName());
        } catch (Exception e12) {
            throw new RuntimeException("Failed to read awsconfiguration.json please check that it is correctly formed.", e12);
        }
    }

    private void readInputJson(Context context, int i12) {
        try {
            Scanner scanner = new Scanner(context.getResources().openRawResource(i12));
            StringBuilder sb2 = new StringBuilder();
            while (scanner.hasNextLine()) {
                sb2.append(scanner.nextLine());
            }
            scanner.close();
            this.mJSONObject = new JSONObject(sb2.toString());
        } catch (Exception e12) {
            throw new RuntimeException("Failed to read awsconfiguration.json please check that it is correctly formed.", e12);
        }
    }

    public String getConfiguration() {
        return this.configName;
    }

    public String getUserAgent() {
        try {
            return this.mJSONObject.getString("UserAgent");
        } catch (JSONException unused) {
            return "";
        }
    }

    public JSONObject optJsonObject(String str) throws JSONException {
        try {
            JSONObject jSONObject = this.mJSONObject.getJSONObject(str);
            if (jSONObject.has(this.configName)) {
                jSONObject = jSONObject.getJSONObject(this.configName);
            }
            return new JSONObject(jSONObject.toString());
        } catch (JSONException unused) {
            return null;
        }
    }

    public void setConfiguration(String str) {
        this.configName = str;
    }

    public String toString() {
        return this.mJSONObject.toString();
    }

    public AWSConfiguration(Context context, int i12) {
        this(context, i12, DEFAULT);
    }

    public AWSConfiguration(Context context, int i12, String str) {
        this.configName = str;
        readInputJson(context, i12);
    }
}
