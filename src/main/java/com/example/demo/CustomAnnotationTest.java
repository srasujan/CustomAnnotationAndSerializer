package com.example.demo;

import com.example.demo.test.Test;
import com.example.demo.test2.Test2;
import com.example.demo.test3.Test3;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomAnnotationTest {

//    @Autowired
//    Test test = new Test();

    @GetMapping("/test")
    public void main() {
        Test test = new Test();
        test.setValue("ar");
        System.out.println("result :" + test.getValue());
    }

    @PostMapping("/test2")
    public void maintest2(@RequestBody Test2 test2) throws JsonProcessingException {
        System.out.println(test2.getValue());
        Test2 test21 = new Test2();
        test21.setValue("ar2");

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(test21));

    }


    @GetMapping("/test3")
    public void maintest3() {
        Test3 test2 = new Test3();
        test2.setTask("ar");
        System.out.println(""+test2.getTask());
    }
}

