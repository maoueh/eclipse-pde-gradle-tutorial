package com.acme.framework.services.helper;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

import com.acme.api.services.model.*;

public class CallFormatterTest {

    @Test
    public void testCallFormat() {
        assertThat(CallFormatter.formatCall(new Call("abcdef", 1200L)), is("abcdef - 1.2 s"));
    }

}
