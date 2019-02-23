package me.anpan.anpanwebmvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {

    @GetMapping("/file")
    public String fileuUploadForm(Model model) {
        return "files/index";
    }

    @PostMapping("/file")
    public String fileUpload(@RequestParam MultipartFile file ,
                             RedirectAttributes attributes) {

        String message = file.getOriginalFilename() + "is uploaded";
        System.out.println("message :" + message);
        attributes.addFlashAttribute("message",message);
        return "redirect:/file";
    }
}
