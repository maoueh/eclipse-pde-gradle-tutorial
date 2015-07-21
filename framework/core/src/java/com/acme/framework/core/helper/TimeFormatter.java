package com.acme.framework.core.helper;

import com.google.common.base.*;

public final class TimeFormatter {

    private TimeFormatter() {
        // Helper class
    }

    public static String formatDuration(long duration) {
        return Joiner.on(" ").join(Double.toString(duration / 1000.0), "s");
    }
}
