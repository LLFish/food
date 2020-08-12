package top.llfish.food.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    private String password = "518701";

    @GetMapping("")
    public boolean Login(String password)
    {
        if(password.equals(this.password)){
            return true;
        }

        return false;
    }
}
