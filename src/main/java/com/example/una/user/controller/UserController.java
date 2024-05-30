package com.example.una.user.controller;


import com.example.una.user.model.User;
import com.example.una.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "error"; // 유효성 검증 실패 시 에러 페이지로 이동하거나 적절한 처리를 수행합니다.
        }

        userService.saveUser(user.getName(), user.getEmail());

        return "redirect:/success"; // 사용자가 성공적으로 생성되었을 때의 페이지로 이동합니다.
    }
}
