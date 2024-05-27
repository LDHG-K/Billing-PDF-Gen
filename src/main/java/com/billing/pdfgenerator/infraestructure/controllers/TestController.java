package com.billing.pdfgenerator.infraestructure.controllers;

import com.billing.pdfgenerator.domain.dto.Example;
import com.billing.pdfgenerator.domain.dto.OperationRequest;
import com.billing.pdfgenerator.domain.dto.Person;
import com.billing.pdfgenerator.domain.dto.PersonRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    private List<Person> personList = new ArrayList<>();

    @GetMapping("hello-world")
    public String getHelloWorldMessage() {
        return "Hello world, i am working successfully";
    }

    @GetMapping("example-object")
    public List<Example> getExampleObject() {
        return List.of(
                new Example("Stiwar", LocalDate.now()),
                new Example("Pepito", LocalDate.now().plusDays(1)));
    }

    @GetMapping("example-person")
    public List<Person> getInfoPerson() {
        return personList;
    }


    @GetMapping("example-person-order-by-name")
    public List<Person> getSortedExample() {
        personList.sort(Comparator.comparing(Person::getNickname));
        return personList;
    }


    @PostMapping("create-person")
    public void createPerson(@RequestBody PersonRequest request) {
        personList.add(new Person(request.getName(), request.getNickname(), request.getAge()));

    }


    @PostMapping("create-operation/{value-a}/{value-b}")
    public String createOperation(@PathVariable("value-a") Integer a, @PathVariable("value-b") Integer b) {
        return "Result =" + (a - b);
    }

    @DeleteMapping("delete-example")
    public String deleteExample(@RequestParam String name) {
        Iterator<Person> iterator = personList.iterator();
        while (iterator.hasNext()) {
            Person persons = iterator.next();
            if (persons.getName().equals(name)) {
                iterator.remove();
                return "Deleted: " + name;
            }
        }
        return "Not found: " + name;
    }

    @PostMapping("create-operation/gg")
    public String createNewOperation(@RequestBody OperationRequest request) {

        int a = request.getValueA();
        int b = request.getValueB();
        char operator = request.getOperator();

        switch (operator) {

            case '+':
                return "Result = " + (a + b);
            case '-':
                return "Result = " + (a - b);
            case '/':
                return "Result = " + (a / b);

            case '*':
                return "Result = " + (a * b);

            default:
                return "Cagaste";
        }


    }


}
