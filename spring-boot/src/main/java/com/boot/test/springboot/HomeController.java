/**
 * 
 */
package com.boot.test.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sunil.yadav
 *
 */
@Controller
public class HomeController {

	@RequestMapping(value= {"/", "/home"}, method=RequestMethod.GET)
	public String getHomePage() {
		return "home";
	}
}
