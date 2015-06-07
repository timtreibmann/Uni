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

	public BenutzerOberflaeche() {

		scene = new Scene(new Group());
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
		search = new TextField();
		cm = new ContextMenu();
		cmItem1 = new MenuItem("Löschen");

		starteMitEinstellungen();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) throws Exception {

		setStage(stage);

		table.getColumns().addAll(firstNameCol, lastNameCol, adress, emailCol, telefonnumber);

		hb.getChildren().addAll(addVorName, addNachname, addAdresse, addEmail, addTelefonnummer, addButton);
		hb.setSpacing(3);

		hboxOben.getChildren().addAll(label, search);

		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(hboxOben, table, hb);

		hboxSuper.getChildren().addAll(listView, vbox, tree);

		((Group) scene.getRoot()).getChildren().addAll(hboxSuper);

		stage.setScene(scene);
		stage.show();
		

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void starteMitEinstellungen() {

		rootItem.setExpanded(false);

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

		table.setMaxWidth(firstNameCol.getPrefWidth() + lastNameCol.getPrefWidth() + adress.getPrefWidth()
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

}
