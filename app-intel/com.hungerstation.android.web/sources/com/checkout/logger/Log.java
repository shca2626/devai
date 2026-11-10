package com.checkout.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes7.dex */
public class Log {
    private static Log log;

    private Log() {
    }

    public static Log getLog() {
        if (log == null) {
            log = new Log();
        }
        return log;
    }

    private void printDate() {
        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
    }

    public void error(String str) {
        printDate();
        System.out.println("ERROR: " + str);
    }

    public void info(String str) {
        printDate();
        System.out.println("INFO: " + str);
    }

    public void warn(String str) {
        printDate();
        System.out.println("WARNING: " + str);
    }
}
