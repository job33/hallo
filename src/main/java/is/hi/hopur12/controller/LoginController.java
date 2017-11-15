/*
package is.hi.hopur12.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import is.hi.hopur12.model.User;
import is.hi.hopur12.services.UserService;


@Controller
public class LoginController {

	@Autowired
	UserService userServ;
	
    @RequestMapping(value="/aboutDiet", method=RequestMethod.POST)
    public String aboutDiet(@ModelAttribute("userInfo") User u,
    	ModelMap model) {
    	userServ.calcBMR(u);
    	u.setNutrition(userServ.calcAll(u.getBmr()));
    	userServ.save(u);
    	return "greeting/userInfo";	
    }
    
    

}
*/