package me.anpan.anpanwebmvc.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    @GetMapping(value = "/hello" , headers = HttpHeaders.FROM+"=localhost")
    @ResponseBody
    public String hello() {
        return  "hello";
    }

    @GetMapping("/hi")
    @ResponseBody
    public String hi() {
        return  "hi ";
    }

}
