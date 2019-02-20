package me.anpan.anpanwebmvc.web.controller;

import me.anpan.anpanwebmvc.GetHelloMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @GetHelloMapping
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
