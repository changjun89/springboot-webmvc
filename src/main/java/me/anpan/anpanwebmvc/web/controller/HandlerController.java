package me.anpan.anpanwebmvc.web.controller;

import me.anpan.anpanwebmvc.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("member")
public class HandlerController {

    @GetMapping("/member/form/name")
    public String memberForm(Model model) {
        model.addAttribute("member",new Member());
        return "member/form-name";
    }

    @PostMapping("/member/form/name")
    public String  memmberFormNameSubmit(@Validated @ModelAttribute Member member , BindingResult bindingResult,Model model) {
        if(bindingResult.hasErrors()){
            return "/member/form-name";
        }
        return "redirect:/member/form/tall";
    }

    @GetMapping("/member/form/tall")
    public String memberFormTall(@ModelAttribute Member member,Model model){
        model.addAttribute("member",member);
        return "/member/form-tall";
    }

    @PostMapping("/member/form/tall")
    public String  memmberFormTallSubmit(@Validated @ModelAttribute Member member , BindingResult bindingResult,Model model,SessionStatus sessionStatus) {
        if(bindingResult.hasErrors()){
            return "/member/form-tall";
        }
        sessionStatus.setComplete();
        return "redirect:/member/list";
    }

    @GetMapping("/member/list")
    public String getMembers(Model model) {
        Member member = new Member();
        member.setName("spring");
        member.setTall(100);

        List<Member> memberList = new ArrayList<>();
        memberList.add(member);

        model.addAttribute("memberList",memberList);

        return "/member/list";
    }






}
