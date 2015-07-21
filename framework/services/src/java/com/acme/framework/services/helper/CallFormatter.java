package com.acme.framework.services.helper;

import static java.lang.String.*;

import com.acme.api.services.model.*;
import com.acme.framework.core.helper.*;

public final class CallFormatter {

    private CallFormatter() {
        // Helper class
    }

    public static String formatCall(Call call) {
        return format("%s - %s", call.getId(), TimeFormatter.formatDuration(call.getDuration()));
    }
}
