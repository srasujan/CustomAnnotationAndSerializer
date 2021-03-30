package com.example.demo.test2;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;

public class DoubleDeserializer extends JsonDeserializer<Test2> {

    @Override
    public Test2 deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        Test2 test2 = new Test2();
        Field[] fields = test2.getClass().getDeclaredFields();
        try {
            for (Field f : fields) {
                if (!f.isAccessible()) {
                    f.setAccessible(true);
                    Class<?> type = f.getType();

                    if (type.equals(Integer.class)) {
                        f.set(test2, 0); //Set Default value
                    } else if (type.equals(String.class)) {
                        String changedValue = node.get(f.getName()).asText() +"gument";
                        f.set(test2, changedValue);
                    } else if (type.equals(Date.class)) {
                        f.set(test2, new Date());
                    }
                    f.setAccessible(false);
                }
                System.out.println(f.get(test2)); //print fields with reflection
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return test2;
    }
}
