package com.example.demo.test2;

import com.example.demo.test.ConversionUtil;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonDeserialize(using = DoubleDeserializer.class)
public class Test2 implements Serializable {

    @AmountSerializer
    @JsonSerialize(using = DoubleSerializer.class)
    public String value;

}