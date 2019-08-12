package com.singleton.dynamic.builder.validation.integration;

import static com.singleton.dynamic.builder.validation.NotParameterValidator.NULL;

import org.junit.Test;

import com.singleton.dynamic.builder.DynamicBuilderFactory;
import com.singleton.dynamic.builder.annotation.Not;

/**
 * Test class to validate that an argument to a builder method can be declared as not null and it
 * will be enforced.
 * 
 * @author Dustin Singleton
 */
@SuppressWarnings("javadoc")
public class NotNullTest
{
    private final DynamicBuilderFactory factory = DynamicBuilderFactory.getInstance();

    @Test(expected = IllegalArgumentException.class)
    public void testNotNull_nullValue()
    {
        factory.createBuilderForClass(NotNullObjectBuilder.class).stringValue(null);
    }

    public interface NotNullObjectBuilder
    {

        NotNullObjectBuilder stringValue(@Not({ NULL }) String value);

        NotNullObjectBuiltObject build();
    }

    public interface NotNullObjectBuiltObject
    {
        String getStringValue();
    }
}
