package me.anpan.anpanwebmvc.web.controller;

import me.anpan.anpanwebmvc.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HandlerController {

    @GetMapping("/member/{id}")
    @ResponseBody
    public Member getMemmber(@PathVariable("id") Integer id) {
        Member member = new Member();
        member.setId(id);
        return member;
    }


    @PostMapping("/member/name/{name}")
    @ResponseBody
    public Member getMemmberByName(@Valid  @ModelAttribute Member member , BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            System.out.println("#########################################################");
            bindingResult.getAllErrors().forEach(c->{
                System.out.println(c.toString());
            });
            System.out.println("#########################################################");
        }
        return member;
    }

    @GetMapping("/member/form")
    public String memberForm( Model model) {
        model.addAttribute("member",new Member());
        return "member/form";
    }

}
