package com.acme.api.services.test.json;

import static com.google.common.collect.Maps.*;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;

public class JsonHelperTest {

    @Test
    public void testAnyGetterSetter() throws Exception {
        Foo foo = new Foo();
        foo.add("first", "second");
        foo.add("third", "fourth");
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(foo);
        Foo foo2 = mapper.readValue(value, Foo.class);
        assertEquals("second", foo2.channels().get("first"));
        assertEquals("fourth", foo2.channels().get("third"));
    }

    private static class Foo {
        private final Map<String, String> mData = newHashMap();

        @JsonAnyGetter
        public Map<String, String> channels() {
            return mData;
        }

        @JsonAnySetter
        public void add(String first, String second) {
            mData.put(first, second);
        }
    }
}
