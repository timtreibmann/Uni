package de.beuth.treibmann.View;

import java.util.ArrayList;

import de.beuth.treibmann.Contactdetails;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

@SuppressWarnings("rawtypes")
public class BenutzerOberflaeche extends Application {

	private TableView<Contactdetails> table = new TableView<Contactdetails>();
	private TextField addVorName;
	private TextField addNachname;
	private TextField addAdresse;
	private TextField addEmail;
	private TextField addTelefonnummer;
	private HBox hb;
	private TableColumn firstNameCol;
	private TableColumn lastNameCol;
	private TableColumn adress;
	private TableColumn emailCol;
	private TableColumn telefonnumber;
	private ArrayList<TextField> listeEingabeFelder;
	private TreeView<String> tree;
	private Button addButton;
	private HBox hboxOben;
	private TextField search;
	private ContextMenu cm;
	private MenuItem cmItem1;
	private Label label;
	private VBox vbox;
	private HBox hboxSuper;
	private ListView listView;
	private TreeItem<String> rootItem;
	private Scene scene;
	private MenuBar menuebar;
	private MenuItem menueTable;
	private MenuItem menueList;
	private MenuItem menueTree;
	private Menu menue;
	private VBox vboxmenu;
	private HBox contentBox;
	private Button addbuttonBlank;
	private Button consolenAusgabe;
	private HBox hboxbuttonBlankCA;

	public BenutzerOberflaeche() {

		scene = new Scene(new Group());
		vboxmenu = new VBox();
		hboxbuttonBlankCA = new HBox();
		menuebar = new MenuBar();
		menue = new Menu("View");
		menueTable = new MenuItem("TableView");
		menueList = new MenuItem("ListView");
		menueTree = new MenuItem("TreeView");
		contentBox = new HBox();
		hb = new HBox();
		hboxOben = new HBox();
		vbox = new VBox();
		hboxSuper = new HBox();
		listView = new ListView();
		rootItem = new TreeItem<String>("Kontakte");
		tree = new TreeView<String>(rootItem);
		label = new Label("Addressbuch");

		firstNameCol = new TableColumn("Vorname");
		lastNameCol = new TableColumn("Nachname");
		adress = new TableColumn("Adresse");
		emailCol = new TableColumn("Email");
		telefonnumber = new TableColumn("Telefonnummer");

		addVorName = new TextField();
		addNachname = new TextField();
		addAdresse = new TextField();
		addEmail = new TextField();
		addTelefonnummer = new TextField();

		listeEingabeFelder = new ArrayList<TextField>();
		listeEingabeFelder.add(addVorName);
		listeEingabeFelder.add(addNachname);
		listeEingabeFelder.add(addAdresse);
		listeEingabeFelder.add(addEmail);
		listeEingabeFelder.add(addTelefonnummer);

		addButton = new Button("Hinzufügen");
		addbuttonBlank = new Button("Blank+");
		consolenAusgabe = new Button("ConsolenAusgabe");
		search = new TextField();
		cm = new ContextMenu();
		cmItem1 = new MenuItem("Löschen");

		starteMitEinstellungen();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) throws Exception {

		setStage(stage);
		menuebar.getMenus().addAll(menue);
		menue.getItems().addAll(menueTable, menueList, menueTree);

		table.getColumns().addAll(firstNameCol, lastNameCol, adress, emailCol, telefonnumber);

		hb.getChildren().addAll(addVorName, addNachname, addAdresse, addEmail, addTelefonnummer, addButton);
		hb.setSpacing(3);

		hboxOben.getChildren().addAll(label, search);

		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vboxmenu.getChildren().addAll(menuebar);
		contentBox.getChildren().addAll(table);
		hboxbuttonBlankCA.getChildren().addAll(addbuttonBlank,consolenAusgabe);
		vbox.getChildren().addAll(vboxmenu, hboxOben, contentBox, hb, hboxbuttonBlankCA);

		hboxSuper.getChildren().addAll(vbox);

		((Group) scene.getRoot()).getChildren().addAll(hboxSuper);

		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void starteMitEinstellungen() {

		rootItem.setExpanded(false);
		listView.setVisible(false);
		menuebar.setVisible(true);
		tree.setVisible(false);
		tree.setEditable(false);
		listView.setEditable(false);
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		firstNameCol.setPrefWidth(80);
		lastNameCol.setPrefWidth(100);
		adress.setPrefWidth(100);
		emailCol.setPrefWidth(250);
		telefonnumber.setPrefWidth(150);

		addVorName.setPromptText("Vorname");
		addVorName.setMaxWidth(firstNameCol.getPrefWidth());

		addNachname.setMaxWidth(lastNameCol.getPrefWidth());
		addNachname.setPromptText("Nachname");

		addAdresse.setMaxWidth(adress.getPrefWidth());
		addAdresse.setPromptText("Adresse");

		addEmail.setMaxWidth(emailCol.getPrefWidth());
		addEmail.setPromptText("Email");

		addTelefonnummer.setMaxWidth(telefonnumber.getPrefWidth());
		addTelefonnummer.setPromptText("Telefonnummer");

		search.setPromptText("Suche");
		label.setFont(new Font("Arial", 20));

		table.setEditable(true);
		label.setPadding(new Insets(5, 380, 5, 5));
		search.setPadding(new Insets(5));
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));

		table.setMinWidth(firstNameCol.getPrefWidth() + lastNameCol.getPrefWidth() + adress.getPrefWidth()
				+ emailCol.getPrefWidth() + telefonnumber.getPrefWidth());

		listView.setMinWidth(firstNameCol.getPrefWidth() + lastNameCol.getPrefWidth() + adress.getPrefWidth()
				+ emailCol.getPrefWidth() + telefonnumber.getPrefWidth());

		tree.setMinWidth(firstNameCol.getPrefWidth() + lastNameCol.getPrefWidth() + adress.getPrefWidth()
				+ emailCol.getPrefWidth() + telefonnumber.getPrefWidth());
	}

	public void setStage(Stage stage) {
		stage.setTitle("Adressbuch");
		stage.setWidth(730);
		stage.setHeight(600);
	}

	public TableView<Contactdetails> getTable() {
		return table;
	}

	public void setTable(TableView<Contactdetails> table) {
		this.table = table;
	}

	public TextField getAddVorName() {
		return addVorName;
	}

	public void setAddVorName(TextField addVorName) {
		this.addVorName = addVorName;
	}

	public TextField getAddNachname() {
		return addNachname;
	}

	public void setAddNachname(TextField addNachname) {
		this.addNachname = addNachname;
	}

	public TextField getAddAdresse() {
		return addAdresse;
	}

	public void setAddAdresse(TextField addAdresse) {
		this.addAdresse = addAdresse;
	}

	public TextField getAddEmail() {
		return addEmail;
	}

	public void setAddEmail(TextField addEmail) {
		this.addEmail = addEmail;
	}

	public TextField getAddTelefonnummer() {
		return addTelefonnummer;
	}

	public void setAddTelefonnummer(TextField addTelefonnummer) {
		this.addTelefonnummer = addTelefonnummer;
	}

	public HBox getHb() {
		return hb;
	}

	public void setHb(HBox hb) {
		this.hb = hb;
	}

	public TableColumn getFirstNameCol() {
		return firstNameCol;
	}

	public void setFirstNameCol(TableColumn firstNameCol) {
		this.firstNameCol = firstNameCol;
	}

	public TableColumn getLastNameCol() {
		return lastNameCol;
	}

	public void setLastNameCol(TableColumn lastNameCol) {
		this.lastNameCol = lastNameCol;
	}

	public TableColumn getAdress() {
		return adress;
	}

	public void setAdress(TableColumn adress) {
		this.adress = adress;
	}

	public TableColumn getEmailCol() {
		return emailCol;
	}

	public void setEmailCol(TableColumn emailCol) {
		this.emailCol = emailCol;
	}

	public TableColumn getTelefonnumber() {
		return telefonnumber;
	}

	public void setTelefonnumber(TableColumn telefonnumber) {
		this.telefonnumber = telefonnumber;
	}

	public ArrayList<TextField> getListeEingabeFelder() {
		return listeEingabeFelder;
	}

	public void setListeEingabeFelder(ArrayList<TextField> listeEingabeFelder) {
		this.listeEingabeFelder = listeEingabeFelder;
	}

	public TreeView<String> getTree() {
		return tree;
	}

	public void setTree(TreeView<String> tree) {
		this.tree = tree;
	}

	public Button getAddButton() {
		return addButton;
	}

	public void setAddButton(Button addButton) {
		this.addButton = addButton;
	}

	public HBox getHboxOben() {
		return hboxOben;
	}

	public void setHboxOben(HBox hboxOben) {
		this.hboxOben = hboxOben;
	}

	public TextField getSearch() {
		return search;
	}

	public void setSearch(TextField search) {
		this.search = search;
	}

	public ContextMenu getCm() {
		return cm;
	}

	public void setCm(ContextMenu cm) {
		this.cm = cm;
	}

	public MenuItem getCmItem1() {
		return cmItem1;
	}

	public void setCmItem1(MenuItem cmItem1) {
		this.cmItem1 = cmItem1;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public VBox getVbox() {
		return vbox;
	}

	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}

	public HBox getHboxSuper() {
		return hboxSuper;
	}

	public void setHboxSuper(HBox hboxSuper) {
		this.hboxSuper = hboxSuper;
	}

	public ListView getListView() {
		return listView;
	}

	public void setListView(ListView listView) {
		this.listView = listView;
	}

	public TreeItem<String> getRootItem() {
		return rootItem;
	}

	public void setRootItem(TreeItem<String> rootItem) {
		this.rootItem = rootItem;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public MenuBar getMenuebar() {
		return menuebar;
	}

	public void setMenuebar(MenuBar menuebar) {
		this.menuebar = menuebar;
	}

	public MenuItem getMenueTable() {
		return menueTable;
	}

	public MenuItem getMenueList() {
		return menueList;
	}

	public MenuItem getMenueTree() {
		return menueTree;
	}

	public VBox getVboxmenu() {
		return vboxmenu;
	}

	public void setVboxmenu(VBox vboxmenu) {
		this.vboxmenu = vboxmenu;
	}

	public Menu getMenue() {
		return menue;
	}

	public void setMenue(Menu menue) {
		this.menue = menue;
	}

	public void setMenueTable(MenuItem menueTable) {
		this.menueTable = menueTable;
	}

	public void setMenueList(MenuItem menueList) {
		this.menueList = menueList;
	}

	public void setMenueTree(MenuItem menueTree) {
		this.menueTree = menueTree;
	}

	public HBox getContentBox() {
		return contentBox;
	}

	public void setContentBox(HBox contentBox) {
		this.contentBox = contentBox;
	}

	public Button getAddbuttonBlank() {
		return addbuttonBlank;
	}

	public void setAddbuttonBlank(Button addbuttonBlank) {
		this.addbuttonBlank = addbuttonBlank;
	}

	public Button getConsolenAusgabe() {
		return consolenAusgabe;
	}

	public void setConsolenAusgabe(Button consolenAusgabe) {
		this.consolenAusgabe = consolenAusgabe;
	}

	public HBox getHboxbuttonBlankCA() {
		return hboxbuttonBlankCA;
	}

	public void setHboxbuttonBlankCA(HBox hboxbuttonBlankCA) {
		this.hboxbuttonBlankCA = hboxbuttonBlankCA;
	}

}
