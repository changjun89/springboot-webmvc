package me.anpan.anpanwebmvc.web.controller;

import me.anpan.anpanwebmvc.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/member")
public class MemberApi {

    @ExceptionHandler
    public ResponseEntity errorHandler() {
        return ResponseEntity.badRequest().body("can't create member");
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody @Valid Member member, BindingResult bindingResult) {
        //save event
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(member);
    }


}
