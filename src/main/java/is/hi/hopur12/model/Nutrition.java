package is.hi.hopur12.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
public class Nutrition {
	private int protein;
	private int carbs;
	private int fat;
	private int ppro;
	private int pcar;
	private int pfat;
	private int procentProtein;
	private int procentCarbs;
	private int procentFat;
	
	public Nutrition() {
		
	}
	
	public Nutrition(int protein, int carbs, int fat, int ppro, int pcar, int pfat, int procentProtein, int procentCarbs, int procentFat) {
		this.protein = protein;
		this.carbs = carbs;
		this.fat = fat;
		this.ppro = ppro;
		this.pcar = pcar;
		this.pfat = pfat;
		this.procentProtein = procentProtein;
		this.procentCarbs = procentCarbs;
		this.procentFat = procentFat;
	}
	
	public int getProcentProtein() {
		return procentProtein;
	}

	public void setProcentProtein(int procentProtein) {
		this.procentProtein = procentProtein;
	}

	public int getProcentCarbs() {
		return procentCarbs;
	}

	public void setProcentCarbs(int procentCarbs) {
		this.procentCarbs = procentCarbs;
	}

	public int getProcentFat() {
		return procentFat;
	}

	public void setProcentFat(int procentFat) {
		this.procentFat = procentFat;
	}

	public int getPcar() {
		return pcar;
	}
	
	public void setPcar(int pcar) {
		this.pcar = pcar;
	}
	
	public int getPfat() {
		return pfat;
	}
	
	public void setPfat(int pfat) {
		this.pfat = pfat;
	}
	
	public int getPpro() {
		return ppro;
	}
	
	public void setPpro(int ppro) {
		this.ppro = ppro;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public int getCarbs() {
		return carbs;
	}

	public void setCarbs(int carbs) {
		this.carbs = carbs;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}
	
	

}
