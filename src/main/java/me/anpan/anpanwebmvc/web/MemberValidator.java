package me.anpan.anpanwebmvc.web;


import me.anpan.anpanwebmvc.Member;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MemberValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Member.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Member member = (Member) o;
        if (member.getName().equalsIgnoreCase("aaa")) {
            errors.rejectValue("name", "wrongvalue", "error");
        }
    }
}
