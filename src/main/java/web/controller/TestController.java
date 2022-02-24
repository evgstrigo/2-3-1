package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @GetMapping("/test")
    public String getResult(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("action") String action, Model model) {


        if (action.equals("multiplication")) {
           model.addAttribute("result", a * b) ;
        } else   if (action.equals("addition")) {
            model.addAttribute("result", a + b) ;
        }
        return "test";
    }
}
