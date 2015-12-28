package app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/controller")
public class Controller1 {

    @RequestMapping("/echo/{a}")
    public ResponseEntity getValue(@PathVariable("a") String a) {
        return new ResponseEntity(a, HttpStatus.OK);
    }
}
