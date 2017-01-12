package edu.pitt.is17.ERL67.menumanager;
/**
 * Class Menu
 * author : ERL67
 * created: 10/14/2016
 */

public class Menu {

	private String name;
	private Entree entree;
	private Side side;
	private Salad salad;
	private Dessert dessert;

	public Menu (String name)
	{
		this.name = name;
		this.entree = new Entree();		//all new object of each dishes default constructor have all their properties set to NULL for strings and 0 for calories
		this.side = new Side ();
		this.salad = new Salad();
		this.dessert = new Dessert ();
	}

	public Menu (String name, Entree entree, Side side)
	{
		this.name = name;
		this.entree = entree;
		this.side = side;
		this.salad = new Salad();
		this.dessert = new Dessert ();
	}

	public Menu (String name, Entree entree, Side side, Salad salad, Dessert dessert)
	{
		this.name = name;
		this.entree = entree;
		this.side = side;
		this.salad = salad;
		this.dessert = dessert;
	}

	public int totalCalories (){
		return entree.getCalories() + side.getCalories() + salad.getCalories() + dessert.getCalories();
	}
	
	public double totalPrice (){
		return entree.getPrice() + side.getPrice() + salad.getPrice() + dessert.getPrice();
	}

	public String descriptionOfMeal () {
		return "The meal " + this.name + " consists of: "
				+ "\nEntree: " + entree.getName() + ". " + entree.getDescription()
				+ "\nSalad: " + salad.getName() + ". " + salad.getDescription()
				+ "\nSide: " + side.getName() + ". " + side.getDescription()
				+ "\nDessert: " + dessert.getName() + ". " + dessert.getDescription();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Entree getEntree() {
		return entree;
	}

	public void setEntree(Entree entree) {
		this.entree = entree;
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

	public Salad getSalad() {
		return salad;
	}

	public void setSalad(Salad salad) {
		this.salad = salad;
	}

	public Dessert getDessert() {
		return dessert;
	}

	public void setDessert(Dessert dessert) {
		this.dessert = dessert;
	}
	
	@Override
	public String toString() {
		return getName();
	}

}
