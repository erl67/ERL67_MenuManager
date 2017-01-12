package edu.pitt.is17.ERL67.menumanager;
/**
 * Class MenuManager
 * author : ERL67
 * created: 12/04/2016
 */
import java.util.ArrayList;

public class MenuManager {

	private ArrayList<Entree> entrees = new ArrayList<Entree>();
	private ArrayList<Side> sides = new ArrayList<Side>();
	private ArrayList<Salad> salads = new ArrayList<Salad>();
	private ArrayList<Dessert> desserts = new ArrayList<Dessert>();

	/**
	 * Method MenuManager reads file of menu items, and sorts each item into a corresponding array list
	 * @param dishesFile
	 */
	public MenuManager (String dishesFile){
		ArrayList<MenuItem> menuItems = FileManager.readItems(dishesFile);

		for (MenuItem item: menuItems){
			if (item instanceof Entree){ 
				this.entrees.add((Entree) item); 
			}else if (item instanceof Side){ 
				this.sides.add((Side) item); 
			}else if (item instanceof Salad){ 
				this.salads.add((Salad) item); 
			}else if (item instanceof Dessert){ 
				this.desserts.add((Dessert) item); 
			} 
		}
	}

	/**
	 * Method randomMenu generates a random menu
	 * @param name
	 * @return menu
	 */
	public Menu randomMenu (String name){
		//create a new menu object
		Menu randMenu = new Menu (name);
		//use setter for each item, based on size of array list * random
		randMenu.setEntree(entrees.get( (int) (entrees.size() * Math.random() )));
		randMenu.setSide(sides.get((int)(sides.size()*Math.random())));
		randMenu.setSalad(salads.get((int)(salads.size()*Math.random())));
		randMenu.setDessert(desserts.get((int)(desserts.size()*Math.random())));
		return randMenu;
	}

	/**
	 * Method minCaloriesMenu generates a menu with the lowest calorie items available
	 * @param name
	 * @return menu
	 */
	public Menu minCaloriesMenu (String name){
		Menu minMenu = new Menu (name);
		
		minMenu.setEntree(entrees.get(entrees.size()-1));
		for (Entree item: entrees){
			if (minMenu.getEntree().getCalories() > item.getCalories()) 
				minMenu.setEntree(item);		
		}

		minMenu.setSalad(salads.get(salads.size()-1));
		for (Salad item: salads){
			if (minMenu.getSalad().getCalories() > item.getCalories()) 
				minMenu.setSalad(item);		
		}
		
		minMenu.setSide(sides.get(sides.size()-1));
		for (Side item: sides){
			if (minMenu.getSide().getCalories() > item.getCalories()) 
				minMenu.setSide(item);		
		}
		
		minMenu.setDessert(desserts.get(desserts.size()-1));
		for (Dessert item: desserts){
			if (minMenu.getDessert().getCalories() > item.getCalories()) 
				minMenu.setDessert(item);		
		}
				
		return minMenu;
	}

	/**
	 * Generates menu with the highest calorie items available
	 * @param name
	 * @return menu
	 */
	public Menu maxCaloriesMenu (String name){
		Menu maxMenu = new Menu (name);
		
		maxMenu.setEntree(entrees.get(entrees.size()-1));
		for (Entree item: entrees){
			if (maxMenu.getEntree().getCalories() < item.getCalories()) 
				maxMenu.setEntree(item);		
		}

		maxMenu.setSalad(salads.get(salads.size()-1));
		for (Salad item: salads){
			if (maxMenu.getSalad().getCalories() < item.getCalories()) 
				maxMenu.setSalad(item);		
		}
		
		maxMenu.setSide(sides.get(sides.size()-1));
		for (Side item: sides){
			if (maxMenu.getSide().getCalories() < item.getCalories()) 
				maxMenu.setSide(item);		
		}
		
		maxMenu.setDessert(desserts.get(desserts.size()-1));
		for (Dessert item: desserts){
			if (maxMenu.getDessert().getCalories() < item.getCalories()) 
				maxMenu.setDessert(item);		
		}
				
		return maxMenu;
	}

	public ArrayList<Entree> getEntrees() {
		return entrees;
	}

	public void setEntrees(ArrayList<Entree> entrees) {
		this.entrees = entrees;
	}

	public ArrayList<Side> getSides() {
		return sides;
	}

	public void setSides(ArrayList<Side> sides) {
		this.sides = sides;
	}

	public ArrayList<Salad> getSalads() {
		return salads;
	}

	public void setSalads(ArrayList<Salad> salads) {
		this.salads = salads;
	}

	public ArrayList<Dessert> getDesserts() {
		return desserts;
	}

	public void setDesserts(ArrayList<Dessert> desserts) {
		this.desserts = desserts;
	}

}
