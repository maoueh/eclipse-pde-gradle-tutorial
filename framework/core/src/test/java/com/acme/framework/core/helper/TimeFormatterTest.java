package com.acme.framework.core.helper;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

public class TimeFormatterTest {

    @Test
    public void testDurationFormat() {
        assertThat(TimeFormatter.formatDuration(500), is("0.5 s"));
    }

}
