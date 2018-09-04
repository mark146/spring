package org.com.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.com.session.SessionRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "index";
	}

	@RequestMapping(value = "/error_common", method = RequestMethod.GET)
	public String error() {
		return "/error/404";
	}	
	
	@RequestMapping(value = "/sessions", method = RequestMethod.GET)
	protected void sessions(Model model)
    {
		model.addAttribute("numberOfSessions",SessionRegistry.getNumberOfSessions());
		model.addAttribute("sessionList", SessionRegistry.getAllSessions());
    }
}