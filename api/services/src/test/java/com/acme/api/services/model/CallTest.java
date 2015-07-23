package com.acme.api.services.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

public class CallTest {

    @Test
    public void testGetId() {
        assertThat(new Call("a", 1500).getId(), is("a"));
    }

}
