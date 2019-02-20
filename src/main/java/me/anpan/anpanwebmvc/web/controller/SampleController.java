package me.anpan.anpanwebmvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class SampleController {

    @GetMapping("/{name:[a-z]+}")
    @ResponseBody
    public String hello(@PathVariable() String name) {
        return  "hello "+name;
    }


    @GetMapping("/hi")
    @ResponseBody
    public String hi() {
        return  "hi ";
    }
}
