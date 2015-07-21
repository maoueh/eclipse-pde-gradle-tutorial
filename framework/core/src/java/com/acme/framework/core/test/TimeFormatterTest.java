package com.acme.framework.core.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

import com.acme.framework.core.helper.*;

public class TimeFormatterTest {

    @Test
    public void testDurationFormat() {
        assertThat(TimeFormatter.formatDuration(500), is("0.5 s"));
    }

}
