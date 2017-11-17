package demo.spring.boot.demospringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ExceptionController {

    @GetMapping(value = "null-point-exception")
    public String nullPointException() {
        Date date = null;
        date.setTime(11);
        return date.toString();
    }

}
