package com.diamonshop.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.diamonshop.dtos.UserDto;
import com.diamonshop.dtos.request.LoginRequest;
import com.diamonshop.dtos.request.UserRequest;
import com.diamonshop.entities.User;
import com.diamonshop.services.AuthService;
import com.diamonshop.services.UserService;

@Controller
@RequestMapping("/auth")
public class AuthController {

	private final AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@GetMapping("/")
	public String getHomePage() {
		return "redirect:/login.html";
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
		User user = authService.authenticateUser(loginRequest);
		if (user != null) {
			session.setAttribute("user", user);
			return ResponseEntity.status(HttpStatus.OK).body("home");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Tên đăng nhập hoặc mật khẩu không đúng");
		}
	}

	@GetMapping("/logout")
	@ResponseBody
	public String logout_Get(HttpSession session) {
		if (session != null) {
			session.invalidate();
			return "login.html";
		}
		return "error.html";
	}

	@PostMapping("/logout")
	@ResponseBody
	public String logout_Post(HttpSession session) {
		if (session != null) {
			session.invalidate();
			return "login.html";
		}
		return "error.html";
	}

}
