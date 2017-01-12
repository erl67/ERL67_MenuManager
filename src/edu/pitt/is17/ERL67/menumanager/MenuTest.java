//package edu.pitt.is17.ERL67.menumanager;
///**
// * Class MenuTest
// * author : ERL67
// * created: 10/14/2016
// */
//public class MenuTest {
//
//	public static void main(String[] args) {
//		
//		//creating different objects of each menu item
//		Entree steak = new Entree("Steak", "Grilled cow meat", 600);
//		Entree fish = new Entree("Fish", "Grilled salmon", 300);
//		Side potato = new Side ("Potato", "Boiled potato", 250);
//		Side potato2 = new Side ("Potato, mashed", "Mashed potato", 200);
//		Salad potatoSalad = new Salad ("Potato salad", "Salad version of potoatoes", 270);
//		Salad greenSalad = new Salad ("Green salad", "Mixed vegetables", 189);
//		Dessert cake = new Dessert ("Cake", "Real cake", 311);
//		Dessert iceCream = new Dessert("Ice Cream", "Vanilla", 217);
//		
//		//using the 3 different constructors of Menu()
//		Menu water = new Menu ("Water only");
//		Menu steakAndPotatoMeal = new Menu("Steak and Potato", steak, potato);
//		Menu fishMeal = new Menu ("Fish dinner", fish, potato2, greenSalad, cake);
//		
//		//trying to make a meal of desert only for which a constructor isn't defined, tried to pass null as the other 3 dishes but it gave an NPE error when called
//		//works by either setting it manually or creating the 3 other sides with their default constructor(which sets null,null,0) when setting the menu, which should happen automatically according to the menu constructor that only accepts the name
//		Menu cakeOnly = new Menu ("Cake dinner");
//		cakeOnly.setDessert(cake);
//		Menu iceCreamOnly = new Menu ("Ice cream dinner", new Entree(), new Side (), new Salad(), iceCream);
//		
//		//print out the descriptions and calories of the various menu objects
//		System.out.println(steakAndPotatoMeal.descriptionOfMeal());
//		System.out.println("The total calories of this meal is " + steakAndPotatoMeal.totalCalories() + "\n");
//		
//		System.out.println(fishMeal.descriptionOfMeal());
//		System.out.println("The total calories of this meal is " + fishMeal.totalCalories() + "\n");
//		
//		System.out.println(water.descriptionOfMeal());
//		System.out.println("The total calories of this meal is " + water.totalCalories() + "\n");
//		
//		System.out.println(cakeOnly.descriptionOfMeal());
//		System.out.println("The total calories of this meal is " + cakeOnly.totalCalories() + "\n");
//		
//		System.out.println(iceCreamOnly.descriptionOfMeal());
//		System.out.println("The total calories of this meal is " + iceCreamOnly.totalCalories() + "\n");
//		
//		
//		//testing different functions of the other classes
//		Menu fishAndPotatos = new Menu ("Fish and potato salad", fish, potato, potatoSalad, cake);  //just here to not have an unreferenced object
//		fishAndPotatos.setDessert(new Dessert());		//cake is gone
////		System.out.println(fishAndPotatos.descriptionOfMeal());
////		System.out.println("The total calories of this meal is " + fishAndPotatos.totalCalories() + "\n");
////		iceCreamOnly.setSide(potato); //add potato to ice cream
////		steakAndPotatoMeal.setEntree(new Entree()); //remove meat from this meal, still not sure how to set a component to null without creating a new object in there
////		steakAndPotatoMeal.setName("Potato only. Steak is unavailable today. ");
////		System.out.println(iceCreamOnly.descriptionOfMeal());
////		System.out.println("The total calories of this meal is " + iceCreamOnly.totalCalories() + "\n");
////		System.out.println(steakAndPotatoMeal.descriptionOfMeal());
////		System.out.println("The total calories of this meal is " + steakAndPotatoMeal.totalCalories() + "\n");
//
//		
//	}
//
//}
