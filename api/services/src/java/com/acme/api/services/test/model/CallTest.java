package com.acme.api.services.test.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

import com.acme.api.services.model.*;

public class CallTest {

    @Test
    public void testGetId() {
        assertThat(new Call("a", 1500).getId(), is("a"));
    }

}
