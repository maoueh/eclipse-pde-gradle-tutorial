package com.acme.framework.core;

import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Suite.*;

import com.acme.framework.core.helper.*;

import junit.framework.*;

@RunWith(Suite.class)
@SuiteClasses({TimeFormatter.class})
public class AllTests extends TestCase {}
