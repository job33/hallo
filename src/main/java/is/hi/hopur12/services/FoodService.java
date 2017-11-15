package is.hi.hopur12.services;

import java.util.List;

import is.hi.hopur12.model.*;

/*
 * Interface klasi fyrir service
 * Atli Haraldsson
 * HBV501G
 */
public interface FoodService {
	
	/*
	 * Vistar gögn í gagnagrunni
	 * @user er model af taginu User.
	 */
	public Food save(Food food);
	
	public List<Food> allFood();
	
	public Food findOne(long id);
	
	public Nutrition calcEaten(long id, Nutrition nut);
	
	public void calcProtein(Food food, Nutrition nut);
	public void calcFat(Food food, Nutrition nut);
	public void calcCarb(Food food, Nutrition nut);
	public String findtheOne(long ls);
	

}
