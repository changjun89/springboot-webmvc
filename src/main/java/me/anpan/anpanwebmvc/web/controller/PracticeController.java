package me.anpan.anpanwebmvc.web.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class PracticeController {

    @GetMapping("/events")
    public String events() {
        return "events";
    }


    @GetMapping("/events/{id}")
    public String events2(@PathVariable int id) {
        return "events";
    }

    @PostMapping(value = "/events" ,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String events3() {
        return "events";
    }

    @DeleteMapping("/events/{id}")
    public String events4(@PathVariable int id) {
        return "events";
    }

    @PutMapping(value = "/events" ,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String events5() {
        return "events";
    }


}
