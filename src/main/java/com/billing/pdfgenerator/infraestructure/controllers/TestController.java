package com.billing.pdfgenerator.infraestructure.controllers;

import com.billing.pdfgenerator.domain.dto.Example;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("hello-world")
    public String getHelloWorldMessage() {
        return "Hello world, i am working successfully";
    }

    @GetMapping("example-object")
    public List<Example> getExampleObject() {
        return List.of(new Example("Example 1", LocalDate.now()),
                new Example("Example 2", LocalDate.now().plusDays(1)));
    }

    @PostMapping("create-operation/{value-a}/{value-b}")
    public String createOperation(@PathVariable("value-a") Integer a, @PathVariable("value-b") Integer b) {
        return "Result =" + (a - b);
    }

    //TODO Create 4 operations given a list of elements without using pathVariable (clue JSON) + - / *
    //TODO Create a object person and return it
    //TODO Create a list of person then order by name or nick name and return it
    //TODO create a list of persons and delete the given one
}
