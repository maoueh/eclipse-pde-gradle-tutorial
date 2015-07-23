package com.acme.api.services.json;

import java.util.regex.*;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.cfg.*;
import com.fasterxml.jackson.databind.introspect.*;
import com.fasterxml.jackson.datatype.guava.*;
import com.google.common.base.*;

public final class JsonHelper {
    private static ObjectMapper sMapper = new ObjectMapper();

    static {
        configureMapper(sMapper);
    }

    private JsonHelper() {
        // Helper class
    }

    public static void configureMapper(ObjectMapper mapper) {
        mapper.registerModule(new GuavaModule());

        mapper.setPropertyNamingStrategy(new AcmePropertyNamingStrategy());

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS);
    }

    public static ObjectMapper mapper() {
        return sMapper;
    }

    public static final class AcmePropertyNamingStrategy extends PropertyNamingStrategy {
        private static final long serialVersionUID = 1L;
        private static final Pattern FIELD_PATTERN = Pattern.compile("^m[A-Z0-9][a-zA-Z0-9]*$");

        @Override
        public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName) {
            Package classPackage = field.getDeclaringClass().getPackage();
            if (classPackage.getName().startsWith("org.acme") && FIELD_PATTERN.matcher(defaultName).matches()) {
                defaultName = defaultName.substring(1, defaultName.length());
                defaultName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, defaultName);
            }
            return defaultName;
        }
    }
}