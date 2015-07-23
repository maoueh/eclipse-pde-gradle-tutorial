package com.acme.framework.services.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

import com.acme.api.services.model.*;
import com.acme.framework.services.helper.*;

public class CallFormatterTest {

    @Test
    public void testCallFormat() {
        assertThat(CallFormatter.formatCall(new Call("ab", 1200L)), is("ab 1.2s"));
    }

}
