package org.example;

import java.io.File;

public class LogFilePathHelper {
    public static String getLogFilePath() {
        String projectDir = System.getProperty("user.dir");
        return projectDir + File.separator + "test-logs.log";
    }
}
