package com.acme.framework.services;

import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Suite.*;

import com.acme.framework.services.test.*;

import junit.framework.*;

@RunWith(Suite.class)
@SuiteClasses({CallFormatterTest.class})
public class AllTests extends TestCase {}
