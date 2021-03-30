package com.example.demo.test;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@RequiredArgsConstructor
@Component
@Scope(scopeName="prototype")
public class Test{

    @ConversionUtil
    public String value;

}