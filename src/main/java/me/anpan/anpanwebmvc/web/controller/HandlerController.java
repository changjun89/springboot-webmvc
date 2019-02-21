package me.anpan.anpanwebmvc.web.controller;

import me.anpan.anpanwebmvc.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HandlerController {

    @GetMapping("/member/{id}")
    @ResponseBody
    public Member getMemmber(@PathVariable("id") Integer id) {
        Member member = new Member();
        member.setId(id);
        return member;
    }

    @GetMapping("/member/form")
    public String memberForm( Model model) {
        Member member = new Member();
        member.setName("changjun");
        member.setTall(170);
        model.addAttribute("member",member);
        return "member/form";
    }


    @PostMapping("/member")
    public String  getMemmberByName(@Validated @ModelAttribute Member member , BindingResult bindingResult,Model model) {
        if(bindingResult.hasErrors()){
            return "/member/form";
        }

//        List<Member> memberList = new ArrayList<Member>();
//        memberList.add(member);
//        model.addAttribute(memberList);
        //save 로직

        return "redirect:/member/list";
    }

    @GetMapping("/member/list")
    public String getMembers(Model model){
        //select 로직
        Member member = new Member();
        member.setName("spring");
        member.setTall(100);

        List<Member> memberList = new ArrayList<>();
        memberList.add(member);
        model.addAttribute(memberList);

        return "/member/list";
    }



}
