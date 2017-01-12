package edu.pitt.is17.ERL67.menumanager;
import java.util.ArrayList;

/**
 * Class MenuTester
 * author : ERL67
 * created: 11/02/2016
 */
import javax.swing.JOptionPane;

public class MenuTester {

	public static void main(String[] args) {

		int userInput = 0;
		Object[] options = {1, 9999};

		//read menu data from file
//		MenuRandomize randomize = new MenuRandomize("data/entrees.txt",
//				"data/sides.txt","data/salads.txt","data/desserts.txt");
		
		MenuManager randomize = new MenuManager("data/dishes.txt");	
		
		ArrayList<Menu> menus = new ArrayList<Menu>(); //array list that logs all the random menus then writes to file at the end

		//implements it as a loop because testing it per execution won't ensure the method works right
		do {
			try {
				userInput = (int) options[JOptionPane.showOptionDialog(null, "Choose Option: \n"
						+ "1 to generate random menu\n9999 to quit & writeFile", "Menu Randomness Tester",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						null, options, options[0])];
			}
			catch (Exception e) {
				userInput = 0;
			}
			if (userInput==9999 || userInput == 0){
				FileManager.writeMenu("data/OUTPUT.TXT", menus);
				System.out.println("Goodbye");
			} 
			else if (userInput==1) {
				Menu myMenu = randomize.randomMenu("RandomTestFinalProject");	//changed for final project
				menus.add(myMenu);												//creates array list of menus for writing to file

				System.out.println(myMenu.descriptionOfMeal() +
						"\nTotal calories=" + myMenu.totalCalories() + "\n");
			}
		} while (userInput == 1);
	}

}
