package me.anpan.anpanwebmvc.web.controller;

import me.anpan.anpanwebmvc.web.MemberException;
import me.anpan.anpanwebmvc.web.MemberValidator;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice(assignableTypes = HandlerController.class)
public class BaseController {

    @ExceptionHandler({MemberException.class, RuntimeException.class})
    public String memberErrorHandeler(RuntimeException e, Model model) {

        model.addAttribute("message", "runtime 에러입니다.");
        return "error";
    }

    @InitBinder("member")
    public void initMemberBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(new MemberValidator());
    }

    @ModelAttribute
    public void categories(Model model) {
        List list = new ArrayList();
        list.add("study");
        list.add("playing");
        model.addAttribute("categories", list);
    }
}
