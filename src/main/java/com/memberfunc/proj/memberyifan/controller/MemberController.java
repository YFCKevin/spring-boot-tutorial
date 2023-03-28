package com.memberfunc.proj.memberyifan.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.memberfunc.proj.memberyifan.entity.Member;
import com.memberfunc.proj.memberyifan.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Member member, BindingResult bindingResult) {
		List<String> errors = null;
		if (bindingResult.hasErrors()) {
			errors = bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage)
					.collect(Collectors.toList());
			return ResponseEntity.badRequest().body(errors);
		}
		try {
			Integer key = memberService.register(member);
			return ResponseEntity.ok(key);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(errors);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Member member, BindingResult bindingResult,
			@CookieValue(name = "memId", required = false) String memId,
			@CookieValue(name = "memNickname", required = false) String memNickname) {
		List<String> errors = null;
		if (bindingResult.hasErrors()) {
			errors = bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage)
					.collect(Collectors.toList());
			return ResponseEntity.badRequest().body(errors);
		}
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Set-Cookie", "memId=" + memId + "; Max-Age=36000; Path=/;");
			headers.add("Set-Cookie", "memNickname=" + memNickname + "; Max-Age=36000; Path=/;");
			Member result = memberService.login(member);
			memNickname = result.getNickname();
			memId = String.valueOf(result.getMemberid());
			return ResponseEntity.ok().headers(headers).body(result.getNickname() + " 歡迎回來");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpServletResponse response) {
	    Cookie cookie1 = new Cookie("memId", "");
	    cookie1.setMaxAge(0);
	    cookie1.setPath("/");
	    response.addCookie(cookie1);
	    Cookie cookie2 = new Cookie("memNickname", "");
	    cookie2.setMaxAge(0);
	    cookie2.setPath("/");
	    response.addCookie(cookie2);
	    return ResponseEntity.ok().body("已成功登出");
	}
	
	@PutMapping("/{memberid}")
	public ResponseEntity<?> updateByMemberId(@PathVariable("memberid") int memberid, @RequestBody Member member,
			BindingResult bindingResult) {
		List<String> errors = null;
		if (bindingResult.hasErrors()) {
			errors = bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage)
					.collect(Collectors.toList());
			return ResponseEntity.badRequest().body(errors);
		}
		try {
			int result = memberService.updatePut(member, memberid);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
