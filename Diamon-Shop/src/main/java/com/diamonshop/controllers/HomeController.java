package com.diamonshop.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.diamonshop.entities.User;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String getHomePage(HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/login.html";
        } else {
        	if(!currentUser.getRole().equals("KHACHHANG")) {
        		return "redirect:/home.html";
        	}else {
                return "redirect:/index.html";
        	}
        }
    }
}