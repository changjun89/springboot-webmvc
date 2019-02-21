package me.anpan.anpanwebmvc.web.controller;

import me.anpan.anpanwebmvc.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HandlerController {

    @GetMapping("/member/{id}")
    @ResponseBody
    public Member getMemmber(@PathVariable("id") Integer id) {
        Member member = new Member();
        member.setId(id);
        return member;
    }


    @PostMapping("/member")
    @ResponseBody
    public Member getMemmberByName(Member member) {
        System.out.println(member.getName());
        System.out.println(member.getTall());

        return member;
    }

    @GetMapping("/member/form")
    public String memberForm( Model model) {
        model.addAttribute("member",new Member());
        return "member/form";
    }

}
