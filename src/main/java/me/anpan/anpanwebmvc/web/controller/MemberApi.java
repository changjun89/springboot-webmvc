package me.anpan.anpanwebmvc.web.controller;

import me.anpan.anpanwebmvc.Member;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/member")
public class MemberApi {

    @PostMapping()
    public Member createMember(@RequestBody @Valid Member member, BindingResult bindingResult) {
        //save event
        if(bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e->{
                System.out.println(e);
            });
        }
        return member;
    }

//    @PostMapping()
//    public Member createMember(HttpEntity<Member> request) {
//        //save event
//        MediaType contentType = request.getHeaders().getContentType();
//        return request.getBody();
//    }


}
