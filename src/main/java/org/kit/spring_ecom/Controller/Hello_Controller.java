package org.kit.spring_ecom.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello_Controller {

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }
}
