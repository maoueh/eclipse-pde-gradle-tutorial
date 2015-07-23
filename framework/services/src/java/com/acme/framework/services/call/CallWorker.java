package com.acme.framework.services.call;

import static com.google.common.collect.Lists.*;

import java.util.*;

import com.acme.api.services.json.*;
import com.acme.api.services.model.*;
import com.fasterxml.jackson.core.*;
import com.google.common.base.*;

public class CallWorker {

    public String inspect(Call call1, Call call2) throws JsonProcessingException {
        List<String> callStrings = newArrayList();
        callStrings.add(JsonHelper.mapper().writeValueAsString(call1));
        callStrings.add(JsonHelper.mapper().writeValueAsString(call2));

        return Joiner.on('|').join(callStrings);
    }

}
