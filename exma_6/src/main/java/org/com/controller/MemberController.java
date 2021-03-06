package org.com.controller;

import javax.inject.Inject;
import org.com.service.MemberService;
import org.com.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "/memberForm", method = RequestMethod.GET)
	public void memberFormGET(@ModelAttribute("vo") UserVO vo) {
	}	
	
	@RequestMapping(value = "/memberForm", method = RequestMethod.POST)
	public String memberFormPOST(@ModelAttribute("vo") UserVO vo) {
		try {
			memberService.create(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/adminMain", method = RequestMethod.GET)
	public void adminMain() {
	}
	
	@RequestMapping(value = "/managerMain", method = RequestMethod.GET)
	public void managerMain() {
	}
	
	@RequestMapping(value = "/memberMain", method = RequestMethod.GET)
	public void memberMain() {
	}	
}