package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.JsonFactory;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

@Deprecated
/* loaded from: classes.dex */
public class ISO8601Utils {
    protected static final int DEF_8601_LEN = 29;
    private static final TimeZone TIMEZONE_Z = DesugarTimeZone.getTimeZone("UTC");

    private static boolean checkOffset(String str, int i7, char c7) {
        return i7 < str.length() && str.charAt(i7) == c7;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_Z);
    }

    private static int indexOfNonDigit(String str, int i7) {
        while (i7 < str.length()) {
            char cCharAt = str.charAt(i7);
            if (cCharAt < '0' || cCharAt > '9') {
                return i7;
            }
            i7++;
        }
        return str.length();
    }

    public static Date parse(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        int i7;
        int i8;
        int i9;
        int i10;
        int length;
        TimeZone timeZone;
        char cCharAt;
        try {
            int index = parsePosition.getIndex();
            int i11 = index + 4;
            int i12 = parseInt(str, index, i11);
            if (checkOffset(str, i11, '-')) {
                i11 = index + 5;
            }
            int i13 = i11 + 2;
            int i14 = parseInt(str, i11, i13);
            if (checkOffset(str, i13, '-')) {
                i13 = i11 + 3;
            }
            int i15 = i13 + 2;
            int i16 = parseInt(str, i13, i15);
            boolean zCheckOffset = checkOffset(str, i15, 'T');
            if (!zCheckOffset && str.length() <= i15) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(i12, i14 - 1, i16);
                parsePosition.setIndex(i15);
                return gregorianCalendar.getTime();
            }
            if (zCheckOffset) {
                int i17 = i13 + 5;
                int i18 = parseInt(str, i13 + 3, i17);
                if (checkOffset(str, i17, ':')) {
                    i17 = i13 + 6;
                }
                int i19 = i17 + 2;
                int i20 = parseInt(str, i17, i19);
                if (checkOffset(str, i19, ':')) {
                    i19 = i17 + 3;
                }
                if (str.length() <= i19 || (cCharAt = str.charAt(i19)) == 'Z' || cCharAt == '+' || cCharAt == '-') {
                    i15 = i19;
                    i7 = i18;
                    i9 = 0;
                    i10 = 0;
                } else {
                    int i21 = i19 + 2;
                    i10 = parseInt(str, i19, i21);
                    if (i10 > 59 && i10 < 63) {
                        i10 = 59;
                    }
                    if (checkOffset(str, i21, '.')) {
                        int i22 = i19 + 3;
                        int iIndexOfNonDigit = indexOfNonDigit(str, i19 + 4);
                        int iMin = Math.min(iIndexOfNonDigit, i19 + 6);
                        int i23 = parseInt(str, i22, iMin);
                        int i24 = iMin - i22;
                        if (i24 == 1) {
                            i23 *= 100;
                        } else if (i24 == 2) {
                            i23 *= 10;
                        }
                        i7 = i18;
                        i15 = iIndexOfNonDigit;
                        i8 = i20;
                        i9 = i23;
                    } else {
                        i7 = i18;
                        i15 = i21;
                        i9 = 0;
                    }
                }
                i8 = i20;
            } else {
                i7 = 0;
                i8 = 0;
                i9 = 0;
                i10 = 0;
            }
            if (str.length() <= i15) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            char cCharAt2 = str.charAt(i15);
            if (cCharAt2 == 'Z') {
                timeZone = TIMEZONE_Z;
                length = i15 + 1;
            } else {
                if (cCharAt2 != '+' && cCharAt2 != '-') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt2 + "'");
                }
                String strSubstring = str.substring(i15);
                length = i15 + strSubstring.length();
                if ("+0000".equals(strSubstring) || "+00:00".equals(strSubstring)) {
                    timeZone = TIMEZONE_Z;
                } else {
                    String str3 = "GMT" + strSubstring;
                    TimeZone timeZone2 = DesugarTimeZone.getTimeZone(str3);
                    String id = timeZone2.getID();
                    if (!id.equals(str3) && !id.replace(":", "").equals(str3)) {
                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone2.getID());
                    }
                    timeZone = timeZone2;
                }
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
            gregorianCalendar2.setLenient(false);
            gregorianCalendar2.set(1, i12);
            gregorianCalendar2.set(2, i14 - 1);
            gregorianCalendar2.set(5, i16);
            gregorianCalendar2.set(11, i7);
            gregorianCalendar2.set(12, i8);
            gregorianCalendar2.set(13, i10);
            gregorianCalendar2.set(14, i9);
            parsePosition.setIndex(length);
            return gregorianCalendar2.getTime();
        } catch (Exception e7) {
            if (str == null) {
                str2 = null;
            } else {
                str2 = JsonFactory.DEFAULT_QUOTE_CHAR + str + JsonFactory.DEFAULT_QUOTE_CHAR;
            }
            String message = e7.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e7.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date " + str2 + ": " + message, parsePosition.getIndex());
            parseException.initCause(e7);
            throw parseException;
        }
    }

    private static int parseInt(String str, int i7, int i8) {
        int i9;
        int i10;
        if (i7 < 0 || i8 > str.length() || i7 > i8) {
            throw new NumberFormatException(str);
        }
        if (i7 < i8) {
            i10 = i7 + 1;
            int iDigit = Character.digit(str.charAt(i7), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i7, i8));
            }
            i9 = -iDigit;
        } else {
            i9 = 0;
            i10 = i7;
        }
        while (i10 < i8) {
            int i11 = i10 + 1;
            int iDigit2 = Character.digit(str.charAt(i10), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i7, i8));
            }
            i9 = (i9 * 10) - iDigit2;
            i10 = i11;
        }
        return -i9;
    }

    public static String format(Date date, boolean z7) {
        return format(date, z7, TIMEZONE_Z);
    }

    @Deprecated
    public static String format(Date date, boolean z7, TimeZone timeZone) {
        return format(date, z7, timeZone, Locale.US);
    }

    public static String format(Date date, boolean z7, TimeZone timeZone, Locale locale) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, locale);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(30);
        sb.append(String.format("%04d-%02d-%02dT%02d:%02d:%02d", Integer.valueOf(gregorianCalendar.get(1)), Integer.valueOf(gregorianCalendar.get(2) + 1), Integer.valueOf(gregorianCalendar.get(5)), Integer.valueOf(gregorianCalendar.get(11)), Integer.valueOf(gregorianCalendar.get(12)), Integer.valueOf(gregorianCalendar.get(13))));
        if (z7) {
            sb.append(String.format(".%03d", Integer.valueOf(gregorianCalendar.get(14))));
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i7 = offset / 60000;
            sb.append(String.format("%c%02d:%02d", Character.valueOf(offset < 0 ? '-' : '+'), Integer.valueOf(Math.abs(i7 / 60)), Integer.valueOf(Math.abs(i7 % 60))));
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }
}
