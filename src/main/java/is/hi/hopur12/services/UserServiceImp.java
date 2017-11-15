package is.hi.hopur12.services;

import org.springframework.stereotype.Component;
import is.hi.hopur12.model.User;
import is.hi.hopur12.model.Nutrition;
import is.hi.hopur12.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/*
 * Service klasi
 * Atli Haraldsson
 * HBV501G
 */
@Component
public class UserServiceImp implements UserService {
	
    
	@Autowired
    UserRepository userRep;
	Nutrition nutrition;
    
	//Reiknar æskilegt magn af proteini per dag
	@Override
	public int calcProtein(int bmr) {
		return (int)((0.3*bmr)/4);
	}
	
	//Reiknar æskilegt magn af fitu per dag
	@Override
	public int calcFat(int bmr) {
		return (int)((0.2*bmr)/9);

	}
	
	//Reiknar æskilegt magn af carbs per dag
	@Override
	public int calcCarbs(int bmr) {
		return (int)((0.5*bmr)/4);
	}
	
	// Næringargildi sem æskileg eru með tilliti til útreiknaðs
	// BMRs, úr upplýsingum sem fengnar eru.
	@Override
	public Nutrition calcAll(int bmr) {
		Nutrition nut = new Nutrition(calcProtein(bmr),calcCarbs(bmr), calcFat(bmr),0,0,0,0,0,0);
		return nut;
		
	}
	// Vistar User object í gagnagrunnstöflunni "about_user" með Embedded object Nutrition.
	@Override
    public User save(User user) {
        return userRep.save(user);
    }
	// Reiknar BMR fyrir objectið user
	// Tekur tillit til hreyfingar og markmiða
	@Override
	public void calcBMR(User u) {
		int bmrx = 0;
		if(u.getGender().contentEquals("M")) {
			bmrx = (int)(66.5 + (13.75*u.getWeight()) + (5.003*u.getHeight()) - (6.755*u.getAge()));
		}
		if (u.getGender().contentEquals("F")) {
			bmrx = (int)(655.1 + (9.563*u.getWeight()) + (1.85*u.getHeight()) - (4.676*u.getAge()));
		}
		if(u.getGoal().contentEquals("1")) {
			bmrx = bmrx-500;
		} else if (u.getGoal().contentEquals("3")) {
			bmrx = bmrx+500;
		}
		
		checkWorkout(u,bmrx);
	}
	
	// Hendir réttu BMR í objectið user
	// Með tilliti til hreyfingar og markmiða
	public void checkWorkout(User u, int bmr) {
		if(u.getWorkout().contentEquals("1"))
			u.setBmr((int)(bmr*1.2));
		else if(u.getWorkout().contentEquals("2"))
			u.setBmr((int)(bmr*1.375));
		else if(u.getWorkout().contentEquals("3"))
			u.setBmr((int)(bmr*1.55));
		else if(u.getWorkout().contentEquals("4"))
			u.setBmr((int)(bmr*1.725));
		else if(u.getWorkout().contentEquals("5"))
			u.setBmr((int)(bmr*1.9));
	}
	
	
	
/*	
    @Override
    public List<User> allUsers() {
        return userRep.findAll();
        */

}
