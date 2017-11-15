package is.hi.hopur12.services;

import org.springframework.stereotype.Component;
import is.hi.hopur12.model.User;
import is.hi.hopur12.model.Nutrition;
import is.hi.hopur12.model.Food;
import is.hi.hopur12.repository.FoodRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * Service klasi
 * Atli Haraldsson
 * HBV501G
 */
@Component
public class FoodServiceImp implements FoodService {
	User user;
	Nutrition nutrition;
	int MILL = 100;
	
	@Autowired
    FoodRepository foodRep;
    
	@Override
	public Food save(Food food) {
		return foodRep.save(food);
	}
	
	@Override
    public List<Food> allFood() {
        return foodRep.findAll(); 
    }
	
	@Override
	public Food findOne(long id) {
		return foodRep.findOne(id);
	}
	
	@Override
	public String findtheOne(long iid) {
		Food ls = findOne(iid);
		return "ID:" + ls.getId() + ", Nafn: " + ls.getName() + ", carbs: " + ls.getCarb() + ", protein: " + ls.getProtein();
	}
	
	@Override
	public void calcProtein(Food food, Nutrition nut) {
		int knt = nut.getPpro();
		nut.setPpro(knt + food.getProtein());
		nut.setProcentProtein((MILL*nut.getPpro())/nut.getProtein());
	}
	
	@Override
	public void calcFat(Food food, Nutrition nut) {
		int knt = nut.getPfat();
		nut.setPfat(knt + food.getFat());
		nut.setProcentFat((MILL*nut.getPfat())/nut.getFat());
	}
	
	@Override
	public void calcCarb(Food food, Nutrition nut) {
		int knt = nut.getPcar();
		nut.setPcar(knt + food.getCarb());
		nut.setProcentCarbs((MILL*nut.getPcar())/nut.getFat());
		
	}
	
	@Override
	public Nutrition calcEaten(long id, Nutrition nut) {
		calcFat(findOne(id), nut);
		calcCarb(findOne(id), nut);
		calcProtein(findOne(id), nut);
		return nut;
	}


}
