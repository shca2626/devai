package com.checkout;

import java.util.Calendar;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class CardValidator {
    public static final String CARD_NAME_REPLACE_PATTERN = "[^A-Z\\s]";
    private static String DEFAULT_CARD_FORMAT = "(\\d{1,4})";

    public enum Cards {
        MAESTRO("maestro", "^(5018|5020|5038|6304|6759|6761|6763)[0-9]{8,15}$", CardValidator.DEFAULT_CARD_FORMAT, new int[]{12, 13, 14, 15, 16, 17, 18, 19}, new int[]{3}, true, true),
        MASTERCARD("mastercard", "^5[1-5][0-9]{14}$", CardValidator.DEFAULT_CARD_FORMAT, new int[]{16, 17}, new int[]{3}, true, true),
        DINERSCLUB("dinersclub", "^3(?:0[0-5]|[68][0-9])?[0-9]{11}$", "(\\d{1,4})(\\d{1,6})?(\\d{1,4})?", new int[]{14}, new int[]{3}, true, true),
        LASER("laser", "^(6304|6706|6709|6771)[0-9]{12,15}$", CardValidator.DEFAULT_CARD_FORMAT, new int[]{16, 17, 18, 19}, new int[]{3}, true, false),
        JCB("jcb", "^(?:2131|1800|35[0-9]{3})[0-9]{11}$", CardValidator.DEFAULT_CARD_FORMAT, new int[]{16}, new int[]{3}, true, true),
        UNIONPAY("unionpay", "^(62[0-9]{14,17})$", CardValidator.DEFAULT_CARD_FORMAT, new int[]{16, 17, 18, 19}, new int[]{3}, false, false),
        DISCOVER("discover", "^6(?:011|5[0-9]{2})[0-9]{12}$", CardValidator.DEFAULT_CARD_FORMAT, new int[]{16}, new int[]{3}, true, true),
        AMEX("amex", "^3[47][0-9]{13}$", "^(\\d{1,4})(\\d{1,6})?(\\d{1,5})?$", new int[]{15}, new int[]{4}, true, true),
        VISA("visa", "^4[0-9]{12}(?:[0-9]{3})?$", CardValidator.DEFAULT_CARD_FORMAT, new int[]{13, 16}, new int[]{3}, true, true);

        private final int[] cardLength;
        private final int[] cvvLength;
        private final String format;
        private final boolean luhn;
        private final String name;
        private final String pattern;
        private final boolean supported;

        Cards(String str, String str2, String str3, int[] iArr, int[] iArr2, boolean z12, boolean z13) {
            this.name = str;
            this.pattern = str2;
            this.format = str3;
            this.cardLength = iArr;
            this.cvvLength = iArr2;
            this.luhn = z12;
            this.supported = z13;
        }
    }

    public static Cards getCardType(String str) {
        String strSanitizeEntry = sanitizeEntry(str, true);
        if (Pattern.matches("^(54)", strSanitizeEntry) && strSanitizeEntry.length() > 16) {
            return Cards.MAESTRO;
        }
        Cards[] cardsArrValues = Cards.values();
        for (int i12 = 0; i12 < cardsArrValues.length; i12++) {
            if (Pattern.matches(cardsArrValues[i12].pattern, strSanitizeEntry)) {
                return cardsArrValues[i12];
            }
        }
        return null;
    }

    private static boolean isDigit(String str) {
        return Pattern.matches("^\\d+$", str);
    }

    public static String sanitizeEntry(String str, boolean z12) {
        return str.replaceAll(z12 ? "\\D" : "\\s+|-", "");
    }

    private static String sanitizeName(String str) {
        return str.toUpperCase().replaceAll(CARD_NAME_REPLACE_PATTERN, "");
    }

    public static boolean validateCVV(String str, Cards cards) {
        if (!str.equals("") && cards != null) {
            for (int i12 = 0; i12 < cards.cvvLength.length; i12++) {
                if (cards.cvvLength[i12] == str.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validateCardNumber(String str) {
        Cards cardType;
        if (str.equals("")) {
            return false;
        }
        String strSanitizeEntry = sanitizeEntry(str, true);
        if (!Pattern.matches("^\\d+$", strSanitizeEntry) || (cardType = getCardType(strSanitizeEntry)) == null) {
            return false;
        }
        for (int i12 = 0; i12 < cardType.cardLength.length; i12++) {
            if (cardType.cardLength[i12] == strSanitizeEntry.length()) {
                return !cardType.luhn || validateLuhnNumber(strSanitizeEntry);
            }
        }
        return false;
    }

    public static boolean validateExpiryDate(String str, String str2) {
        if (str2.length() != 4 && str2.length() != 2) {
            return false;
        }
        try {
            return validateExpiryDate(Integer.parseInt(str), Integer.parseInt(str2));
        } catch (Exception e12) {
            e12.printStackTrace();
            return false;
        }
    }

    private static boolean validateLuhnNumber(String str) throws NumberFormatException {
        if (str.equals("")) {
            return false;
        }
        String strSanitizeEntry = sanitizeEntry(str, true);
        int i12 = 0;
        boolean z12 = false;
        for (int length = strSanitizeEntry.length() - 1; length >= 0; length--) {
            int i13 = Integer.parseInt(String.valueOf(strSanitizeEntry.charAt(length)));
            if (z12 && (i13 = i13 * 2) > 9) {
                i13 -= 9;
            }
            i12 += i13;
            z12 = !z12;
        }
        return i12 % 10 == 0;
    }

    public static boolean validateCVV(int i12, Cards cards) {
        return validateCVV(String.valueOf(i12), cards);
    }

    public static boolean validateExpiryDate(int i12, int i13) {
        if (i12 < 1 || i13 < 1) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        int i14 = calendar.get(2) + 1;
        int i15 = calendar.get(1);
        if (i13 < 100) {
            i15 -= 2000;
        }
        if (i15 == i13) {
            if (i14 > i12) {
                return false;
            }
        } else if (i15 >= i13) {
            return false;
        }
        return true;
    }
}
