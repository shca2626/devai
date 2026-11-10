package com.hiennv.flutter_callkit_incoming;

import android.os.Bundle;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import z5.C1863G;

/* loaded from: classes.dex */
public final class Data {
    public static final Companion Companion = new Companion(null);

    @JsonProperty("actionColor")
    private String actionColor;

    @JsonProperty("appName")
    private String appName;
    private final Map<String, Object> args;

    @JsonProperty("avatar")
    private String avatar;

    @JsonProperty("backgroundColor")
    private String backgroundColor;

    @JsonProperty("backgroundUrl")
    private String backgroundUrl;

    @JsonProperty("callingNotificationCallbackText")
    private String callingNotificationHangupText;

    @JsonProperty("callingNotificationId")
    private String callingNotificationId;

    @JsonProperty("callingNotificationSubtitle")
    private String callingNotificationSubtitle;

    @JsonProperty("duration")
    private long duration;

    @JsonProperty("extra")
    private HashMap<String, Object> extra;

    @JsonProperty("from")
    private String from;

    @JsonProperty("handle")
    private String handle;

    @JsonProperty("headers")
    private HashMap<String, Object> headers;

    @JsonProperty("id")
    private String id;

    @JsonProperty("incomingCallNotificationChannelName")
    private String incomingCallNotificationChannelName;

    @JsonProperty("isAccepted")
    private boolean isAccepted;

    @JsonProperty("isBot")
    private boolean isBot;

    @JsonProperty("isCustomNotification")
    private boolean isCustomNotification;

    @JsonProperty("isCustomSmallExNotification")
    private boolean isCustomSmallExNotification;

    @JsonProperty("isFullScreen")
    private boolean isFullScreen;

    @JsonProperty("isImportant")
    private boolean isImportant;

    @JsonProperty("isShowCallID")
    private boolean isShowCallID;

    @JsonProperty("isShowCallback")
    private boolean isShowCallback;

    @JsonProperty("isShowCallingNotification")
    private boolean isShowCallingNotification;

    @JsonProperty("isShowFullLockedScreen")
    private boolean isShowFullLockedScreen;

    @JsonProperty("isShowHangup")
    private boolean isShowHangup;

    @JsonProperty("isShowLogo")
    private boolean isShowLogo;

    @JsonProperty("isShowMissedCallNotification")
    private boolean isShowMissedCallNotification;

    @JsonProperty("logoUrl")
    private String logoUrl;

    @JsonProperty("missedCallNotificationChannelName")
    private String missedCallNotificationChannelName;

    @JsonProperty("missedNotificationCallbackText")
    private String missedNotificationCallbackText;

    @JsonProperty("missedNotificationCount")
    private int missedNotificationCount;

    @JsonProperty("missedNotificationId")
    private Integer missedNotificationId;

    @JsonProperty("missedNotificationSubtitle")
    private String missedNotificationSubtitle;

    @JsonProperty("nameCaller")
    private String nameCaller;

    @JsonProperty("ringtonePath")
    private String ringtonePath;

    @JsonProperty("textAccept")
    private String textAccept;

    @JsonProperty("textColor")
    private String textColor;

    @JsonProperty("textDecline")
    private String textDecline;

    @JsonProperty("type")
    private int type;

    public static final class Companion {
        public /* synthetic */ Companion(M5.g gVar) {
            this();
        }

        public final Data fromBundle(Bundle bundle) {
            M5.m.e(bundle, "bundle");
            Data data = new Data(C1863G.h());
            String string = bundle.getString(CallkitConstants.EXTRA_CALLKIT_ID, "");
            M5.m.d(string, "getString(...)");
            data.setId(string);
            String string2 = bundle.getString(CallkitConstants.EXTRA_CALLKIT_NAME_CALLER, "");
            M5.m.d(string2, "getString(...)");
            data.setNameCaller(string2);
            String string3 = bundle.getString(CallkitConstants.EXTRA_CALLKIT_APP_NAME, "");
            M5.m.d(string3, "getString(...)");
            data.setAppName(string3);
            String string4 = bundle.getString(CallkitConstants.EXTRA_CALLKIT_HANDLE, "");
            M5.m.d(string4, "getString(...)");
            data.setHandle(string4);
            String string5 = bundle.getString(CallkitConstants.EXTRA_CALLKIT_AVATAR, "");
            M5.m.d(string5, "getString(...)");
            data.setAvatar(string5);
            data.setType(bundle.getInt(CallkitConstants.EXTRA_CALLKIT_TYPE, 0));
            data.setDuration(bundle.getLong(CallkitConstants.EXTRA_CALLKIT_DURATION, 30000L));
            String string6 = bundle.getString(CallkitConstants.EXTRA_CALLKIT_TEXT_ACCEPT, "");
            M5.m.d(string6, "getString(...)");
            data.setTextAccept(string6);
            String string7 = bundle.getString(CallkitConstants.EXTRA_CALLKIT_TEXT_DECLINE, "");
            M5.m.d(string7, "getString(...)");
            data.setTextDecline(string7);
            data.setImportant(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_IS_IMPORTANT, false));
            data.setBot(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_IS_BOT, false));
            data.setFullScreen(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_IS_FULL_SCREEN, false));
            data.setMissedNotificationId(Integer.valueOf(bundle.getInt(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_ID)));
            data.setShowMissedCallNotification(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_SHOW, true));
            data.setMissedNotificationCount(bundle.getInt(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_COUNT, 1));
            data.setMissedNotificationSubtitle(bundle.getString(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_SUBTITLE, ""));
            data.setShowCallback(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_CALLBACK_SHOW, false));
            data.setMissedNotificationCallbackText(bundle.getString(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_CALLBACK_TEXT, ""));
            data.setCallingNotificationId(bundle.getString(CallkitConstants.EXTRA_CALLKIT_CALLING_ID));
            data.setShowCallingNotification(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_CALLING_SHOW, true));
            data.setCallingNotificationSubtitle(bundle.getString(CallkitConstants.EXTRA_CALLKIT_CALLING_SUBTITLE, ""));
            data.setShowHangup(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_CALLING_HANG_UP_SHOW, false));
            data.setCallingNotificationHangupText(bundle.getString(CallkitConstants.EXTRA_CALLKIT_CALLING_HANG_UP_TEXT, ""));
            Serializable serializable = bundle.getSerializable(CallkitConstants.EXTRA_CALLKIT_EXTRA);
            M5.m.c(serializable, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any?>");
            data.setExtra((HashMap) serializable);
            Serializable serializable2 = bundle.getSerializable(CallkitConstants.EXTRA_CALLKIT_HEADERS);
            M5.m.c(serializable2, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any?>");
            data.setHeaders((HashMap) serializable2);
            data.setCustomNotification(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_IS_CUSTOM_NOTIFICATION, false));
            data.setCustomSmallExNotification(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_IS_CUSTOM_SMALL_EX_NOTIFICATION, false));
            data.setShowLogo(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_IS_SHOW_LOGO, false));
            String string8 = bundle.getString(CallkitConstants.EXTRA_CALLKIT_LOGO_URL, "");
            M5.m.d(string8, "getString(...)");
            data.setLogoUrl(string8);
            data.setShowCallID(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_IS_SHOW_CALL_ID, false));
            String string9 = bundle.getString(CallkitConstants.EXTRA_CALLKIT_RINGTONE_PATH, "");
            M5.m.d(string9, "getString(...)");
            data.setRingtonePath(string9);
            String string10 = bundle.getString(CallkitConstants.EXTRA_CALLKIT_BACKGROUND_COLOR, "#0955fa");
            M5.m.d(string10, "getString(...)");
            data.setBackgroundColor(string10);
            String string11 = bundle.getString(CallkitConstants.EXTRA_CALLKIT_BACKGROUND_URL, "");
            M5.m.d(string11, "getString(...)");
            data.setBackgroundUrl(string11);
            String string12 = bundle.getString(CallkitConstants.EXTRA_CALLKIT_ACTION_COLOR, "#4CAF50");
            M5.m.d(string12, "getString(...)");
            data.setActionColor(string12);
            String string13 = bundle.getString(CallkitConstants.EXTRA_CALLKIT_TEXT_COLOR, "#FFFFFF");
            M5.m.d(string13, "getString(...)");
            data.setTextColor(string13);
            data.setIncomingCallNotificationChannelName(bundle.getString(CallkitConstants.EXTRA_CALLKIT_INCOMING_CALL_NOTIFICATION_CHANNEL_NAME));
            data.setMissedCallNotificationChannelName(bundle.getString(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_NOTIFICATION_CHANNEL_NAME));
            data.setShowFullLockedScreen(bundle.getBoolean(CallkitConstants.EXTRA_CALLKIT_IS_SHOW_FULL_LOCKED_SCREEN, true));
            String string14 = bundle.getString(CallkitConstants.EXTRA_CALLKIT_ACTION_FROM, "");
            M5.m.d(string14, "getString(...)");
            data.setFrom(string14);
            return data;
        }

        private Companion() {
        }
    }

    public Data(Map<String, ? extends Object> map) {
        long jLongValue;
        M5.m.e(map, "args");
        this.args = map;
        Object obj = map.get("id");
        String str = obj instanceof String ? (String) obj : null;
        this.id = str == null ? "" : str;
        Object obj2 = map.get("nameCaller");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        this.nameCaller = str2 == null ? "" : str2;
        Object obj3 = map.get("appName");
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        this.appName = str3 == null ? "" : str3;
        Object obj4 = map.get("avatar");
        String str4 = obj4 instanceof String ? (String) obj4 : null;
        this.avatar = str4 == null ? "" : str4;
        Object obj5 = map.get("handle");
        String str5 = obj5 instanceof String ? (String) obj5 : null;
        this.handle = str5 == null ? "" : str5;
        Object obj6 = map.get("type");
        Integer num = obj6 instanceof Integer ? (Integer) obj6 : null;
        this.type = num != null ? num.intValue() : 0;
        Object obj7 = map.get("duration");
        Long l7 = obj7 instanceof Long ? (Long) obj7 : null;
        if (l7 != null) {
            jLongValue = l7.longValue();
        } else {
            Object obj8 = map.get("duration");
            jLongValue = (obj8 instanceof Integer ? (Integer) obj8 : null) != null ? r1.intValue() : 30000L;
        }
        this.duration = jLongValue;
        this.textAccept = "";
        this.textDecline = "";
        this.isShowMissedCallNotification = true;
        this.isShowCallback = true;
        this.missedNotificationCount = 1;
        this.isShowCallingNotification = true;
        this.isShowHangup = true;
        Object obj9 = map.get("extra");
        this.extra = (HashMap) (obj9 == null ? new HashMap() : obj9);
        Object obj10 = map.get("headers");
        this.headers = (HashMap) (obj10 == null ? new HashMap() : obj10);
        this.isShowFullLockedScreen = true;
        this.from = "";
        Object obj11 = map.get("android");
        Map<String, ? extends Object> map2 = obj11 instanceof HashMap ? (HashMap) obj11 : null;
        map2 = map2 == null ? map : map2;
        Object obj12 = map2.get("isCustomNotification");
        Boolean bool = obj12 instanceof Boolean ? (Boolean) obj12 : null;
        this.isCustomNotification = bool != null ? bool.booleanValue() : false;
        Object obj13 = map2.get("isCustomSmallExNotification");
        Boolean bool2 = obj13 instanceof Boolean ? (Boolean) obj13 : null;
        this.isCustomSmallExNotification = bool2 != null ? bool2.booleanValue() : false;
        Object obj14 = map2.get("isShowLogo");
        Boolean bool3 = obj14 instanceof Boolean ? (Boolean) obj14 : null;
        this.isShowLogo = bool3 != null ? bool3.booleanValue() : false;
        Object obj15 = map2.get("logoUrl");
        String str6 = obj15 instanceof String ? (String) obj15 : null;
        this.logoUrl = str6 == null ? "" : str6;
        Object obj16 = map2.get("isShowCallID");
        Boolean bool4 = obj16 instanceof Boolean ? (Boolean) obj16 : null;
        this.isShowCallID = bool4 != null ? bool4.booleanValue() : false;
        Object obj17 = map2.get("ringtonePath");
        String str7 = obj17 instanceof String ? (String) obj17 : null;
        this.ringtonePath = str7 == null ? "" : str7;
        Object obj18 = map2.get("backgroundColor");
        String str8 = obj18 instanceof String ? (String) obj18 : null;
        this.backgroundColor = str8 == null ? "#0955fa" : str8;
        Object obj19 = map2.get("backgroundUrl");
        String str9 = obj19 instanceof String ? (String) obj19 : null;
        this.backgroundUrl = str9 == null ? "" : str9;
        Object obj20 = map2.get("actionColor");
        String str10 = obj20 instanceof String ? (String) obj20 : null;
        this.actionColor = str10 == null ? "#4CAF50" : str10;
        Object obj21 = map2.get("textColor");
        String str11 = obj21 instanceof String ? (String) obj21 : null;
        this.textColor = str11 == null ? "#ffffff" : str11;
        Object obj22 = map2.get("incomingCallNotificationChannelName");
        this.incomingCallNotificationChannelName = obj22 instanceof String ? (String) obj22 : null;
        Object obj23 = map2.get("missedCallNotificationChannelName");
        this.missedCallNotificationChannelName = obj23 instanceof String ? (String) obj23 : null;
        Object obj24 = map2.get("isShowFullLockedScreen");
        Boolean bool5 = obj24 instanceof Boolean ? (Boolean) obj24 : null;
        this.isShowFullLockedScreen = bool5 != null ? bool5.booleanValue() : true;
        Object obj25 = map2.get("isImportant");
        Boolean bool6 = obj25 instanceof Boolean ? (Boolean) obj25 : null;
        this.isImportant = bool6 != null ? bool6.booleanValue() : false;
        Object obj26 = map2.get("isBot");
        Boolean bool7 = obj26 instanceof Boolean ? (Boolean) obj26 : null;
        this.isBot = bool7 != null ? bool7.booleanValue() : false;
        Object obj27 = map2.get("isFullScreen");
        Boolean bool8 = obj27 instanceof Boolean ? (Boolean) obj27 : null;
        this.isFullScreen = bool8 != null ? bool8.booleanValue() : false;
        Object obj28 = map2.get("from");
        String str12 = obj28 instanceof String ? (String) obj28 : null;
        this.from = str12 == null ? "" : str12;
        Object obj29 = map2.get("textAccept");
        String str13 = obj29 instanceof String ? (String) obj29 : null;
        this.textAccept = str13 == null ? "" : str13;
        Object obj30 = map2.get("textDecline");
        String str14 = obj30 instanceof String ? (String) obj30 : null;
        this.textDecline = str14 == null ? "" : str14;
        Object obj31 = map.get("missedCallNotification");
        Map map3 = obj31 instanceof Map ? (Map) obj31 : null;
        if (map3 != null) {
            Object obj32 = map3.get("id");
            this.missedNotificationId = obj32 instanceof Integer ? (Integer) obj32 : null;
            Object obj33 = map3.get("subtitle");
            this.missedNotificationSubtitle = obj33 instanceof String ? (String) obj33 : null;
            Object obj34 = map3.get("count");
            Integer num2 = obj34 instanceof Integer ? (Integer) obj34 : null;
            this.missedNotificationCount = num2 != null ? num2.intValue() : 1;
            Object obj35 = map3.get("callbackText");
            this.missedNotificationCallbackText = obj35 instanceof String ? (String) obj35 : null;
            Object obj36 = map3.get("isShowCallback");
            Boolean bool9 = obj36 instanceof Boolean ? (Boolean) obj36 : null;
            this.isShowCallback = bool9 != null ? bool9.booleanValue() : true;
            Object obj37 = map3.get("showNotification");
            Boolean bool10 = obj37 instanceof Boolean ? (Boolean) obj37 : null;
            this.isShowMissedCallNotification = bool10 != null ? bool10.booleanValue() : true;
        } else {
            Object obj38 = map.get("textMissedCall");
            String str15 = obj38 instanceof String ? (String) obj38 : null;
            this.missedNotificationSubtitle = str15 == null ? "" : str15;
            Object obj39 = map.get("textCallback");
            String str16 = obj39 instanceof String ? (String) obj39 : null;
            this.missedNotificationCallbackText = str16 != null ? str16 : "";
            Object obj40 = map2.get("isShowCallback");
            Boolean bool11 = obj40 instanceof Boolean ? (Boolean) obj40 : null;
            this.isShowCallback = bool11 != null ? bool11.booleanValue() : true;
            Object obj41 = map2.get("isShowMissedCallNotification");
            Boolean bool12 = obj41 instanceof Boolean ? (Boolean) obj41 : null;
            this.isShowMissedCallNotification = bool12 != null ? bool12.booleanValue() : true;
        }
        Object obj42 = map.get("callingNotification");
        Map map4 = obj42 instanceof Map ? (Map) obj42 : null;
        if (map4 != null) {
            Object obj43 = map4.get("id");
            this.callingNotificationId = obj43 instanceof String ? (String) obj43 : null;
            Object obj44 = map4.get("subtitle");
            this.callingNotificationSubtitle = obj44 instanceof String ? (String) obj44 : null;
            Object obj45 = map4.get("callbackText");
            this.callingNotificationHangupText = obj45 instanceof String ? (String) obj45 : null;
            Object obj46 = map4.get("isShowCallback");
            Boolean bool13 = obj46 instanceof Boolean ? (Boolean) obj46 : null;
            this.isShowHangup = bool13 != null ? bool13.booleanValue() : true;
            Object obj47 = map4.get("showNotification");
            Boolean bool14 = obj47 instanceof Boolean ? (Boolean) obj47 : null;
            this.isShowCallingNotification = bool14 != null ? bool14.booleanValue() : true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Data copy$default(Data data, Map map, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            map = data.args;
        }
        return data.copy(map);
    }

    public final Map<String, Object> component1() {
        return this.args;
    }

    public final Data copy(Map<String, ? extends Object> map) {
        M5.m.e(map, "args");
        return new Data(map);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return M5.m.a(this.id, ((Data) obj).id);
    }

    public final String getActionColor() {
        return this.actionColor;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final Map<String, Object> getArgs() {
        return this.args;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    public final String getCallingNotificationHangupText() {
        return this.callingNotificationHangupText;
    }

    public final String getCallingNotificationId() {
        return this.callingNotificationId;
    }

    public final String getCallingNotificationSubtitle() {
        return this.callingNotificationSubtitle;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final HashMap<String, Object> getExtra() {
        return this.extra;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getHandle() {
        return this.handle;
    }

    public final HashMap<String, Object> getHeaders() {
        return this.headers;
    }

    public final String getId() {
        return this.id;
    }

    public final String getIncomingCallNotificationChannelName() {
        return this.incomingCallNotificationChannelName;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final String getMissedCallNotificationChannelName() {
        return this.missedCallNotificationChannelName;
    }

    public final String getMissedNotificationCallbackText() {
        return this.missedNotificationCallbackText;
    }

    public final int getMissedNotificationCount() {
        return this.missedNotificationCount;
    }

    public final Integer getMissedNotificationId() {
        return this.missedNotificationId;
    }

    public final String getMissedNotificationSubtitle() {
        return this.missedNotificationSubtitle;
    }

    public final String getNameCaller() {
        return this.nameCaller;
    }

    public final String getRingtonePath() {
        return this.ringtonePath;
    }

    public final String getTextAccept() {
        return this.textAccept;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final String getTextDecline() {
        return this.textDecline;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public final boolean isAccepted() {
        return this.isAccepted;
    }

    public final boolean isBot() {
        return this.isBot;
    }

    public final boolean isCustomNotification() {
        return this.isCustomNotification;
    }

    public final boolean isCustomSmallExNotification() {
        return this.isCustomSmallExNotification;
    }

    public final boolean isFullScreen() {
        return this.isFullScreen;
    }

    public final boolean isImportant() {
        return this.isImportant;
    }

    public final boolean isShowCallID() {
        return this.isShowCallID;
    }

    public final boolean isShowCallback() {
        return this.isShowCallback;
    }

    public final boolean isShowCallingNotification() {
        return this.isShowCallingNotification;
    }

    public final boolean isShowFullLockedScreen() {
        return this.isShowFullLockedScreen;
    }

    public final boolean isShowHangup() {
        return this.isShowHangup;
    }

    public final boolean isShowLogo() {
        return this.isShowLogo;
    }

    public final boolean isShowMissedCallNotification() {
        return this.isShowMissedCallNotification;
    }

    public final void setAccepted(boolean z7) {
        this.isAccepted = z7;
    }

    public final void setActionColor(String str) {
        M5.m.e(str, "<set-?>");
        this.actionColor = str;
    }

    public final void setAppName(String str) {
        M5.m.e(str, "<set-?>");
        this.appName = str;
    }

    public final void setAvatar(String str) {
        M5.m.e(str, "<set-?>");
        this.avatar = str;
    }

    public final void setBackgroundColor(String str) {
        M5.m.e(str, "<set-?>");
        this.backgroundColor = str;
    }

    public final void setBackgroundUrl(String str) {
        M5.m.e(str, "<set-?>");
        this.backgroundUrl = str;
    }

    public final void setBot(boolean z7) {
        this.isBot = z7;
    }

    public final void setCallingNotificationHangupText(String str) {
        this.callingNotificationHangupText = str;
    }

    public final void setCallingNotificationId(String str) {
        this.callingNotificationId = str;
    }

    public final void setCallingNotificationSubtitle(String str) {
        this.callingNotificationSubtitle = str;
    }

    public final void setCustomNotification(boolean z7) {
        this.isCustomNotification = z7;
    }

    public final void setCustomSmallExNotification(boolean z7) {
        this.isCustomSmallExNotification = z7;
    }

    public final void setDuration(long j7) {
        this.duration = j7;
    }

    public final void setExtra(HashMap<String, Object> map) {
        M5.m.e(map, "<set-?>");
        this.extra = map;
    }

    public final void setFrom(String str) {
        M5.m.e(str, "<set-?>");
        this.from = str;
    }

    public final void setFullScreen(boolean z7) {
        this.isFullScreen = z7;
    }

    public final void setHandle(String str) {
        M5.m.e(str, "<set-?>");
        this.handle = str;
    }

    public final void setHeaders(HashMap<String, Object> map) {
        M5.m.e(map, "<set-?>");
        this.headers = map;
    }

    public final void setId(String str) {
        M5.m.e(str, "<set-?>");
        this.id = str;
    }

    public final void setImportant(boolean z7) {
        this.isImportant = z7;
    }

    public final void setIncomingCallNotificationChannelName(String str) {
        this.incomingCallNotificationChannelName = str;
    }

    public final void setLogoUrl(String str) {
        M5.m.e(str, "<set-?>");
        this.logoUrl = str;
    }

    public final void setMissedCallNotificationChannelName(String str) {
        this.missedCallNotificationChannelName = str;
    }

    public final void setMissedNotificationCallbackText(String str) {
        this.missedNotificationCallbackText = str;
    }

    public final void setMissedNotificationCount(int i7) {
        this.missedNotificationCount = i7;
    }

    public final void setMissedNotificationId(Integer num) {
        this.missedNotificationId = num;
    }

    public final void setMissedNotificationSubtitle(String str) {
        this.missedNotificationSubtitle = str;
    }

    public final void setNameCaller(String str) {
        M5.m.e(str, "<set-?>");
        this.nameCaller = str;
    }

    public final void setRingtonePath(String str) {
        M5.m.e(str, "<set-?>");
        this.ringtonePath = str;
    }

    public final void setShowCallID(boolean z7) {
        this.isShowCallID = z7;
    }

    public final void setShowCallback(boolean z7) {
        this.isShowCallback = z7;
    }

    public final void setShowCallingNotification(boolean z7) {
        this.isShowCallingNotification = z7;
    }

    public final void setShowFullLockedScreen(boolean z7) {
        this.isShowFullLockedScreen = z7;
    }

    public final void setShowHangup(boolean z7) {
        this.isShowHangup = z7;
    }

    public final void setShowLogo(boolean z7) {
        this.isShowLogo = z7;
    }

    public final void setShowMissedCallNotification(boolean z7) {
        this.isShowMissedCallNotification = z7;
    }

    public final void setTextAccept(String str) {
        M5.m.e(str, "<set-?>");
        this.textAccept = str;
    }

    public final void setTextColor(String str) {
        M5.m.e(str, "<set-?>");
        this.textColor = str;
    }

    public final void setTextDecline(String str) {
        M5.m.e(str, "<set-?>");
        this.textDecline = str;
    }

    public final void setType(int i7) {
        this.type = i7;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_ID, this.id);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_NAME_CALLER, this.nameCaller);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_APP_NAME, this.appName);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_HANDLE, this.handle);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_AVATAR, this.avatar);
        bundle.putInt(CallkitConstants.EXTRA_CALLKIT_TYPE, this.type);
        bundle.putLong(CallkitConstants.EXTRA_CALLKIT_DURATION, this.duration);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_TEXT_ACCEPT, this.textAccept);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_TEXT_DECLINE, this.textDecline);
        Integer num = this.missedNotificationId;
        if (num != null) {
            bundle.putInt(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_ID, num.intValue());
        }
        bundle.putBoolean(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_SHOW, this.isShowMissedCallNotification);
        bundle.putInt(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_COUNT, this.missedNotificationCount);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_SUBTITLE, this.missedNotificationSubtitle);
        bundle.putBoolean(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_CALLBACK_SHOW, this.isShowCallback);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_CALLBACK_TEXT, this.missedNotificationCallbackText);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_CALLING_ID, this.callingNotificationId);
        bundle.putBoolean(CallkitConstants.EXTRA_CALLKIT_CALLING_SHOW, this.isShowCallingNotification);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_CALLING_SUBTITLE, this.callingNotificationSubtitle);
        bundle.putBoolean(CallkitConstants.EXTRA_CALLKIT_CALLING_HANG_UP_SHOW, this.isShowHangup);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_CALLING_HANG_UP_TEXT, this.callingNotificationHangupText);
        bundle.putSerializable(CallkitConstants.EXTRA_CALLKIT_EXTRA, this.extra);
        bundle.putSerializable(CallkitConstants.EXTRA_CALLKIT_HEADERS, this.headers);
        bundle.putBoolean(CallkitConstants.EXTRA_CALLKIT_IS_CUSTOM_NOTIFICATION, this.isCustomNotification);
        bundle.putBoolean(CallkitConstants.EXTRA_CALLKIT_IS_CUSTOM_SMALL_EX_NOTIFICATION, this.isCustomSmallExNotification);
        bundle.putBoolean(CallkitConstants.EXTRA_CALLKIT_IS_SHOW_LOGO, this.isShowLogo);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_LOGO_URL, this.logoUrl);
        bundle.putBoolean(CallkitConstants.EXTRA_CALLKIT_IS_SHOW_CALL_ID, this.isShowCallID);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_RINGTONE_PATH, this.ringtonePath);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_BACKGROUND_COLOR, this.backgroundColor);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_BACKGROUND_URL, this.backgroundUrl);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_TEXT_COLOR, this.textColor);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_ACTION_COLOR, this.actionColor);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_INCOMING_CALL_NOTIFICATION_CHANNEL_NAME, this.incomingCallNotificationChannelName);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_MISSED_CALL_NOTIFICATION_CHANNEL_NAME, this.missedCallNotificationChannelName);
        bundle.putBoolean(CallkitConstants.EXTRA_CALLKIT_IS_SHOW_FULL_LOCKED_SCREEN, this.isShowFullLockedScreen);
        bundle.putBoolean(CallkitConstants.EXTRA_CALLKIT_IS_IMPORTANT, this.isImportant);
        bundle.putBoolean(CallkitConstants.EXTRA_CALLKIT_IS_BOT, this.isBot);
        bundle.putBoolean(CallkitConstants.EXTRA_CALLKIT_IS_FULL_SCREEN, this.isFullScreen);
        bundle.putString(CallkitConstants.EXTRA_CALLKIT_ACTION_FROM, this.from);
        return bundle;
    }

    public String toString() {
        return "Data(args=" + this.args + ')';
    }

    public Data() {
        this(C1863G.h());
    }
}
