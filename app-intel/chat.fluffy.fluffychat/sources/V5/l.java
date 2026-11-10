package V5;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* loaded from: classes.dex */
public abstract class l {
    public static final h c(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new i(matcher, charSequence);
        }
        return null;
    }

    public static final S5.c d(MatchResult matchResult, int i7) {
        return S5.e.o(matchResult.start(i7), matchResult.end(i7));
    }
}
