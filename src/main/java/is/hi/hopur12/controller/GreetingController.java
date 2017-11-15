/**
* Innskráning og heilsa. 
* 
* Hópur 12
* Atli Haraldsson ath174@hi.is
* Sindri Þór Guðmundsson sthg11@hi.is
* Jónas Bergsteinsson job33@hi.is aka þykki
* Hörn Heiðarsdóttir hoh45@hi.is
* HBV501G - Hugbúnaðarverkefni 1
*/

package is.hi.hopur12.controller;

import is.hi.hopur12.services.FoodService;
import is.hi.hopur12.services.UserService;
import is.hi.hopur12.model.Food;
import is.hi.hopur12.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

/*
 * Control klasi fyrir greetings. Hefur í samskiptum við "/greeting/*.jps" skrár.
 */

@Controller
@SessionAttributes("userInfo")
@RequestMapping("/greeting") // Request Mapping er gerð fyrir klasann til að slóðin byrji á /greeting fyrir allar skipanir 
public class GreetingController {
	
	@Autowired
	UserService userServ;
	
	@Autowired
	FoodService foodServ;
	
	@ModelAttribute("userInfo")
	 public User setUpUserForm() {
		return new User();
	 }
    
    // Þar sem klasinn hefur slóðina "/greeting", er þessi slóð "/greeting/spyrjaNotanda"
    @RequestMapping("/spyrjaNotanda")
    public String spyrjaNotandi () {
    	return "greeting/askUser"; // skilar .jsp skrá sem er /webapp/WEB-INF/vefvidmot/greeting/askUser.jsp
    }
    
    @RequestMapping(value="/justInfo", method=RequestMethod.GET)
    public String justInfo(@ModelAttribute("userInfo") User u) {
    	return "greeting/justInfo";
    }
    
    /*
     * Tekur upplýsingar úr POST methodinu "userInfo"
     * Notar þær upplýsingar til að finna æskilegar næringarupplýsingar
     * Notar UserService klasana og Model klasa.
     * Vísar þér yfir á userInfo.jsp þar sem upplýsingar eru komnar í töflu.
     */
    @RequestMapping(value="/aboutDiet", method=RequestMethod.POST)
    public String aboutDiet(@ModelAttribute("userInfo") User u,
    	ModelMap model) {
    	userServ.calcBMR(u);
    	u.setNutrition(userServ.calcAll(u.getBmr()));
    	//userServ.save(u);
    	return "greeting/userInfo";	
    }
    
    @RequestMapping(value="/foodList", method=RequestMethod.GET)
    public String foodList(Model model) {
    	ArrayList<Food> listi;
    	listi = (ArrayList<Food>) foodServ.allFood();
    	model.addAttribute("allFood", listi);
    	return "/greeting/allFood";
    }
    
    @RequestMapping(value="/moreInfo", method=RequestMethod.POST)
    public String moreInfo(@RequestParam("foodVar") long foodID, @ModelAttribute("userInfo") User u, Model model) {
    	//System.out.println(foodID);
    	ArrayList<Food> listi;
    	listi = (ArrayList<Food>) foodServ.allFood();
    	model.addAttribute("allFood", listi);
    	u.setNutrition(foodServ.calcEaten(foodID,u.getNutrition()));
    	//model.addAttribute("userInfo", u);
    	//System.out.println(foodServ.findtheOne(foodID));
    	return "greeting/justInfo";
    }
}

