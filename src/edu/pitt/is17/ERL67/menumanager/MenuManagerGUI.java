package edu.pitt.is17..menumanager;
/**
 * Class MenuManagerGUI
 * author : 
 * created: 12/04/2016
 */
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MenuManagerGUI implements ActionListener, ListSelectionListener, MouseListener {

	private JFrame frmMain;
	private JLabel lblEntrees;
	private JLabel lblSides;
	private JLabel lblSalads;
	private JLabel lblDesserts;
	private JLabel lblH1, lblH2, lblH3;
	private JComboBox<Entree> cboEntrees;
	private JComboBox<Side> cboSides;
	private JComboBox<Salad> cboSalads;
	private JComboBox<Dessert> cboDesserts;
	private JButton btnCreateMenu;
	private JButton btnRandomMenu;
	private JButton btnMinMenu;
	private JButton btnMaxMenu;
	private JButton btnDetails;
	private JButton btnDelete;
	private JButton btnSave;
	private JList<Menu> list1;
	private DefaultListModel<Menu> listModel;

	MenuManager manager = new MenuManager("data/dishes.txt");	//MenuManager object of all menu items, and type array lists
	ArrayList<Menu> allMenus = new ArrayList<Menu>();			//array list of all created menus


	/**
	 * Generate the main menu manager GUI form
	 */
	/**
	 * 
	 */
	public MenuManagerGUI() {

		frmMain = new JFrame("Menu Manager // ERL67");
		frmMain.setLayout(null);
		frmMain.setBounds(100,100,600,470);
		frmMain.setResizable(false);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.setAlwaysOnTop(true);

		lblH1 = new JLabel("Create your own menu:");
		lblH1.setBounds(10, 5, 135, 25);
		lblH2 = new JLabel("Created menus:");
		lblH2.setBounds(350, 10, 100, 25);
		lblH3 = new JLabel("Or generate a menu:");
		lblH3.setBounds(10, 250, 120, 25);

		lblEntrees = new JLabel("Entrees:");
		lblEntrees.setBounds(15, 30, 70, 25);

		lblSalads = new JLabel("Salads:");
		lblSalads.setBounds(15, 65, 70, 25);

		lblSides = new JLabel("Sides:");
		lblSides.setBounds(15, 100, 70, 25);

		lblDesserts = new JLabel("Desserts:");
		lblDesserts.setBounds(15, 135, 70, 25);

		frmMain.add(lblEntrees);
		frmMain.add(lblSides);
		frmMain.add(lblSalads);
		frmMain.add(lblDesserts);
		frmMain.add(lblH1);
		frmMain.add(lblH2);
		frmMain.add(lblH3);

		cboEntrees = new JComboBox<Entree>();
		cboEntrees.setBounds(90,30,195,25);

		cboSalads = new JComboBox<Salad>();
		cboSalads.setBounds(90,65,195,25);

		cboSides = new JComboBox<Side>();
		cboSides.setBounds(90,100,195,25);

		cboDesserts = new JComboBox<Dessert>();
		cboDesserts.setBounds(90,135,195,25);

		frmMain.add(cboEntrees);
		frmMain.add(cboSalads);
		frmMain.add(cboSides);
		frmMain.add(cboDesserts);

		btnCreateMenu = new JButton("Create Menu with these Dishes");
		btnCreateMenu.setBounds(15,170,270,30);

		btnRandomMenu = new JButton("Create Random Menu");
		btnRandomMenu.setBounds(15,280,270,30);

		btnMinMenu = new JButton("Create Minimum Calorie Menu");
		btnMinMenu.setBounds(15,315,270,30);

		btnMaxMenu = new JButton("Create Maximum Calorie Menu");
		btnMaxMenu.setBounds(15,350,270,30);

		btnDetails = new JButton("Details");
		btnDetails.setBounds(350,360,210,25);

		btnDelete = new JButton("Delete All");
		btnDelete.setBounds(360,400,90,25);

		btnSave = new JButton("Save All");
		btnSave.setBounds(460,400,90,25);

		listModel = new DefaultListModel<Menu>();
		list1 = new JList<Menu>(listModel);
		list1.setBounds(350,40,210,300);
		list1.setBorder(BorderFactory.createLineBorder(Color.black));
		list1.addListSelectionListener(this);
		list1.addMouseListener((MouseListener) this);

		frmMain.add(btnCreateMenu);
		frmMain.add(btnRandomMenu);
		frmMain.add(btnMinMenu);
		frmMain.add(btnMaxMenu);
		frmMain.add(btnDetails);
		frmMain.add(btnDelete);
		frmMain.add(btnSave);
		frmMain.add(list1);

		//create menu button, reads combo boxes, creates new menu, adds it to list box, and adds it to Menu array list
		btnCreateMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				Entree selectedEntree = (Entree) cboEntrees.getSelectedItem();
				Side selectedSide = (Side) cboSides.getSelectedItem();
				Salad selectedSalad = (Salad) cboSalads.getSelectedItem();
				Dessert selectedDessert = (Dessert) cboDesserts.getSelectedItem();

				String menuName = JOptionPane.showInputDialog("Name for the menu?");
				if(menuName != null){
					Menu m = new Menu(menuName,selectedEntree,selectedSide,selectedSalad,selectedDessert);
					listModel.addElement(m);
					allMenus.add(m);
				}
			}
		});

		//delete button, removes all items from list box and arraylist of menus
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				allMenus.removeAll(allMenus);
				listModel.removeAllElements();
			}
		});

		//save button, writes all menus to menus.txt and displays message
		btnSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				FileManager.writeMenu("data/menus.txt", allMenus);
				JOptionPane.showMessageDialog(null,allMenus.size() + " Menus saved to menus.txt");
			}
		});

		//random button, creates a random menu and adds it to box and array
		btnRandomMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String menuName = JOptionPane.showInputDialog("Name for the menu?");
				Menu randMenu = manager.randomMenu(menuName.toString());
				listModel.addElement(randMenu);
				allMenus.add(randMenu);
			}
		});

		//minimum calorie menu button, calls method and adds new menu to list and array
		btnMinMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Menu minMenu = manager.minCaloriesMenu("Low Calorie Menu");
				listModel.addElement(minMenu);
				allMenus.add(minMenu);
			}
		});

		//maximum calorie menu button, calls method and adds new menu to list and array
		btnMaxMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Menu maxMenu = manager.maxCaloriesMenu("High Calorie Menu");
				listModel.addElement(maxMenu);
				allMenus.add(maxMenu);
			}
		});

		//details button, reads selected menu from list and calls the details pane method
		btnDetails.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					detailsPane(listModel.elementAt(list1.getSelectedIndex()));
				} catch (Exception f){		//do nothing if list is empty
					//detailsPane(listModel.elementAt(0));	//pull details for first item in list if nothing selected, just makes it easier for testing layouts
				}
			}
		});

		fillComboBoxes();
		frmMain.setVisible(true);		
	}

	/**
	 * Method that reads each array list of item types and fills in the comboboxes
	 */
	public void fillComboBoxes(){
		for (Entree item: manager.getEntrees()) cboEntrees.addItem(item); 
		for (Salad item: manager.getSalads()) cboSalads.addItem(item); 
		for (Side item: manager.getSides()) cboSides.addItem(item); 
		for (Dessert item: manager.getDesserts()) cboDesserts.addItem(item); 
	}

	/**
	 * Details Pane form. Receives menu and displays all the details
	 * @param menu
	 */
	public static void detailsPane(Menu menu){
		JFrame frmDetails = new JFrame("Menu: " + menu);
		frmDetails.setLayout(null);
		frmDetails.setBounds(250,250,900,500);
		frmDetails.setResizable(false);
		//frmDetails.setDefaultCloseOperation(JFrame.NORMAL);
		frmDetails.setAlwaysOnTop(true);
		//Insets margins = new Insets(1,3,1,1);

		JLabel lblEntrees1 = new JLabel("Entree:");
		lblEntrees1.setBounds(15, 30, 70, 25);

		JLabel lblSalads1 = new JLabel("Salad:");
		lblSalads1.setBounds(15, 100, 70, 25);

		JLabel lblSides1 = new JLabel("Side:");
		lblSides1.setBounds(15, 170, 70, 25);

		JLabel lblDesserts1 = new JLabel("Dessert:");
		lblDesserts1.setBounds(15, 240, 70, 25);

		JLabel lblCalories = new JLabel("Total Calories:");
		lblCalories.setBounds(15, 320, 90, 35);

		JLabel lblPrice = new JLabel("Total Price:");
		lblPrice.setBounds(15, 400, 90, 35);

		JTextArea txtArea1 = new JTextArea(3,40);
		txtArea1.setBounds(90,30,750,50);
		txtArea1.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));

		JTextArea txtArea2 = new JTextArea(3,40);
		txtArea2.setBounds(90,100,750,50);
		txtArea2.setBorder(BorderFactory.createLineBorder(Color.BLUE));

		JTextArea txtArea3 = new JTextArea(3,40);
		txtArea3.setBounds(90,170,750,50);
		txtArea3.setBorder(BorderFactory.createLineBorder(Color.RED));

		JTextArea txtArea4 = new JTextArea(3,40);
		txtArea4.setBounds(90,240,750,50);
		txtArea4.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

		JTextArea txtArea5 = new JTextArea(1,10);
		txtArea5.setBounds(110,325,60,20);
		txtArea5.setBorder(BorderFactory.createLineBorder(Color.PINK));

		JTextArea txtArea6 = new JTextArea(1,10);
		txtArea6.setBounds(110,410,60,20);
		txtArea6.setBorder(BorderFactory.createLineBorder(Color.GREEN));

		frmDetails.add(lblEntrees1);
		frmDetails.add(lblSides1);
		frmDetails.add(lblSalads1);
		frmDetails.add(lblDesserts1);
		frmDetails.add(lblCalories);
		frmDetails.add(lblPrice);
		frmDetails.add(txtArea1);
		frmDetails.add(txtArea2);
		frmDetails.add(txtArea3);
		frmDetails.add(txtArea4);
		frmDetails.add(txtArea5);
		frmDetails.add(txtArea6);

		txtArea1.setText(menu.getEntree() +"\n"+ menu.getEntree().getDescription()+ "\nCalories: " + menu.getEntree().getCalories()+ "   Price: $" + menu.getEntree().getPrice());
		txtArea2.setText(menu.getSalad() +"\n"+ menu.getSalad().getDescription()+ "\nCalories: " + menu.getSalad().getCalories()+ "   Price: $" + menu.getSalad().getPrice());
		txtArea3.setText(menu.getSide() +"\n"+ menu.getSide().getDescription()+ "\nCalories: " + menu.getSide().getCalories()+ "   Price: $" + menu.getSide().getPrice());
		txtArea4.setText(menu.getDessert() +"\n"+ menu.getDessert().getDescription()+ "\nCalories: " + menu.getDessert().getCalories()+ "   Price: $" + menu.getDessert().getPrice());
		txtArea5.setText("Kc  " + menu.totalCalories());
		txtArea6.setText("$  " + menu.totalPrice());

		frmDetails.setVisible(true);
	}

	public static void main(String[] args) {
		MenuManagerGUI g = new MenuManagerGUI();
	}

	@Override	//double click item in list to bring up details pane
	public void mouseClicked(MouseEvent event) {
		if(event.getClickCount() == 2) detailsPane(listModel.elementAt(list1.getSelectedIndex()));
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

	@Override
	public void valueChanged(ListSelectionEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {}

}
