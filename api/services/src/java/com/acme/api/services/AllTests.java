package com.acme.api.services;

import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Suite.*;

import com.acme.api.services.test.json.*;
import com.acme.api.services.test.model.*;

import junit.framework.*;

@RunWith(Suite.class)
@SuiteClasses({CallTest.class, JsonHelperTest.class})
public class AllTests extends TestCase {}
