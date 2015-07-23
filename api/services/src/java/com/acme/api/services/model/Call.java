package com.acme.api.services.model;

import java.util.*;

import com.acme.api.services.json.*;
import com.fasterxml.jackson.core.*;

public class Call {

    private final String mId;
    private final long mDuration;

    public Call(long duration) {
        this(UUID.randomUUID().toString().substring(0, 4), duration);
    }

    public Call(String id, long duration) {
        mId = id;
        mDuration = duration;
    }

    public String getId() {
        return mId;
    }

    public long getDuration() {
        return mDuration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mDuration);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Call other = (Call) obj;
        return Objects.equals(mId, other.mId) && Objects.equals(mDuration, other.mDuration);
    }

    public String toJson() throws JsonProcessingException {
        return JsonHelper.mapper().writeValueAsString(this);
    }

    @Override
    public String toString() {
        try {
            return toJson();
        } catch (JsonProcessingException exception) {
            return super.toString();
        }
    }
}
