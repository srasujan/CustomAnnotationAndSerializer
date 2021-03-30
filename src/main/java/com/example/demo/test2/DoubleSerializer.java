package com.example.demo.test2;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;


import java.io.IOException;

public class DoubleSerializer extends StdSerializer<String> implements ContextualSerializer {

    private AmountSerializer annot;

    public DoubleSerializer() {
        super(String.class);
    }

    private DoubleSerializer(String value) {
        super(String.class);
    }
    private DoubleSerializer(AmountSerializer amount) {
        super(String.class);
        this.annot = amount;
    }

    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (annot != null && s != null && !s.isEmpty()) {
            jsonGenerator.writeString(s+"gument");
        } else {
            jsonGenerator.writeString(s);
        }
    }

    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        AmountSerializer annot = null;
        if (beanProperty != null) {
            annot = beanProperty.getAnnotation(AmountSerializer.class);
        }
        return new DoubleSerializer(annot);

    }
}