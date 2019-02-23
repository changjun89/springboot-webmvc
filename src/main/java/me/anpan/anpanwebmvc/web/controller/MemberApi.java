package me.anpan.anpanwebmvc.web.controller;

import me.anpan.anpanwebmvc.Member;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/member")
public class MemberApi {

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody @Valid Member member, BindingResult bindingResult) {
        //save event
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(member);
    }


}
