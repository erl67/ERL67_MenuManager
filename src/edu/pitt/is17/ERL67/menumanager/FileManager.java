package edu.pitt.is17.ERL67.menumanager;
/**
 * Class FileManager / new version for final project / original named FileManager0
 * author : ERL67
 * created: 12/04/2016
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileManager {

	final static String SPLIT = "@@";	//string of separating chars

	/**
	 * Method readItems
	 * @param fileName a string of the data file holding the menu info
	 * @return ArrayList<MenuItem>
	 */
	public static ArrayList<MenuItem> readItems (String fileName){

		ArrayList<MenuItem> allItems = new ArrayList<MenuItem>();	//create array list to hold data read

		try {
			FileReader fr = new FileReader(fileName); 
			BufferedReader br = new BufferedReader(fr); 
			String line = null;
			while ((line = br.readLine()) != null) {

				String[] lineParts = line.split(SPLIT);

				if (lineParts[1].equalsIgnoreCase("entree")){
					allItems.add(new Entree(
							lineParts[0],
							lineParts[2],
							Integer.parseInt(lineParts[3]),
							Double.parseDouble(lineParts[4])
							));
				} else if (lineParts[1].equalsIgnoreCase("side")) {
					allItems.add(new Side(
							lineParts[0],
							lineParts[2],
							Integer.parseInt(lineParts[3]),
							Double.parseDouble(lineParts[4])
							));	
				}  else if (lineParts[1].equalsIgnoreCase("salad")) {
					allItems.add(new Salad(
							lineParts[0],
							lineParts[2],
							Integer.parseInt(lineParts[3]),
							Double.parseDouble(lineParts[4])
							));	
				} else if (lineParts[1].equalsIgnoreCase("dessert")) {
					allItems.add(new Dessert(
							lineParts[0],
							lineParts[2],
							Integer.parseInt(lineParts[3]),
							Double.parseDouble(lineParts[4])
							));	
				} else {	//incase of an unknown dish type such as soup
					allItems.add(new MenuItem(
							lineParts[0],
							lineParts[2],
							Integer.parseInt(lineParts[3]),
							Double.parseDouble(lineParts[4])
							));	
				} // end if

			}	// end while
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return allItems;
	}

	/**
	 * Method writeMenu
	 * @param fileName
	 * @param menus
	 */
	public static void writeMenu (String fileName, ArrayList<Menu> menus) {
		try {
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);      
			for (Menu menuList: menus){
				bw.write(
						menuList.getName() + SPLIT + 
						menuList.totalCalories() + SPLIT +
						menuList.totalPrice() + SPLIT +
						menuList.getEntree() + SPLIT + 
						menuList.getEntree().getDescription() + SPLIT +
						menuList.getEntree().getCalories() + SPLIT +
						menuList.getEntree().getPrice() + SPLIT +
						menuList.getSalad() + SPLIT + 
						menuList.getSalad().getDescription() + SPLIT +
						menuList.getSalad().getCalories() + SPLIT +
						menuList.getSalad().getPrice() + SPLIT +
						menuList.getSide() + SPLIT + 
						menuList.getSide().getDescription() + SPLIT +
						menuList.getSide().getCalories() + SPLIT +
						menuList.getSide().getPrice() + SPLIT +
						menuList.getDessert() + SPLIT + 
						menuList.getDessert().getDescription() + SPLIT +
						menuList.getDessert().getCalories() + SPLIT +
						menuList.getDessert().getPrice()
						);
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
