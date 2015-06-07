/**
 * 
 
package de.beuth.treibmann;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;



public class BenutzerOberflaeche extends Application {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private TableView<Contactdetails> table = new TableView();
	
	// private ObservableList<Contactdetails> data;
	private Adressbook adressbook;
	private final TextField addVorName;
	private final TextField addNachname;
	private final TextField addAdresse;
	private final TextField addEmail;
	private final TextField addTelefonnummer;
	@SuppressWarnings("rawtypes")
	private TableColumn firstNameCol;
	@SuppressWarnings("rawtypes")
	private TableColumn lastNameCol;
	@SuppressWarnings("rawtypes")
	private TableColumn adress;
	@SuppressWarnings("rawtypes")
	private TableColumn emailCol;
	@SuppressWarnings("rawtypes")
	private TableColumn telefonnumber;
	private ArrayList<TextField> listeEingabeFelder;
	private TreeView<String> tree;

	@SuppressWarnings("rawtypes")
	public BenutzerOberflaeche() {
		this.adressbook = new Adressbook();
		// this.data = adressbook.getData();

		firstNameCol = new TableColumn("Vorname");
		lastNameCol = new TableColumn("Nachname");
		adress = new TableColumn("Adresse");
		emailCol = new TableColumn("Email");
		telefonnumber = new TableColumn("Telefonnummer");

		addVorName = new TextField();
		addVorName.setPromptText("Vorname");
		addVorName.setMaxWidth(firstNameCol.getPrefWidth());

		addNachname = new TextField();
		addNachname.setMaxWidth(lastNameCol.getPrefWidth());
		addNachname.setPromptText("Nachname");

		addAdresse = new TextField();
		addAdresse.setMaxWidth(adress.getPrefWidth());
		addAdresse.setPromptText("Adresse");

		addEmail = new TextField();
		addEmail.setMaxWidth(emailCol.getPrefWidth());
		addEmail.setPromptText("Email");

		addTelefonnummer = new TextField();
		addTelefonnummer.setMaxWidth(telefonnumber.getPrefWidth());
		addTelefonnummer.setPromptText("Telefonnummer");

		listeEingabeFelder = new ArrayList<TextField>();
		listeEingabeFelder.add(addVorName);
		listeEingabeFelder.add(addNachname);
		listeEingabeFelder.add(addAdresse);
		listeEingabeFelder.add(addEmail);
		listeEingabeFelder.add(addTelefonnummer);
	}

	final HBox hb = new HBox();

	

	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void start(Stage stage) {
		// get window size
		// https://weblogs.java.net/blog/ixmal/archive/2011/06/23/javafx-20-how-size-your-windows-easily
		// Screen screen = Screen.getPrimary();
		// rectangle2D bounds = screen.getVisualBounds();
		Scene scene = new Scene(new Group());
		stage.setTitle("Adressbuch");
		stage.setWidth(730);
		stage.setHeight(600);

		final ListView listView = new ListView(adressbook.getData());
		
		
		 TreeItem<String> rootItem = new TreeItem<String>("Kontakte");
		 rootItem.setExpanded(false);
		 for (Contactdetails cd : adressbook.getData()) {
			 TreeItem<String> ersternode = new TreeItem<String>(cd.getName());
			 ersternode.getChildren().add(new TreeItem<String> (cd.getVorname()));
			 ersternode.getChildren().add(new TreeItem<String> (cd.getEmail()));
			 ersternode.getChildren().add(new TreeItem<String> (cd.getAdresse()));
			 ersternode.getChildren().add(new TreeItem<String> (cd.getTelefonnummer()));
			 rootItem.getChildren().add(ersternode);
		}
		 tree = new TreeView<String>(rootItem);
		
		
		final Label label = new Label("Addressbuch");
		label.setFont(new Font("Arial", 20));

		table.setEditable(true);

		Callback<TableColumn, TableCell> cellFactory = new Callback<TableColumn, TableCell>() {
			public TableCell call(TableColumn p) {

				return new EditingCell();
			}
		};

		firstNameCol.setPrefWidth(80);
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Contactdetails, String>("vorname"));
		firstNameCol.setCellFactory(cellFactory);
		firstNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Contactdetails, String>>() {

			@Override
			public void handle(CellEditEvent<Contactdetails, String> t) {

				if (adressbook.isName(t.getNewValue()) && !t.getNewValue().equals("")) {
					((Contactdetails) t.getTableView().getItems().get(t.getTablePosition().getRow()))
							.setVorname(t.getNewValue());
				} else {

					sendefehlerberichtbeieingabe();
				}
			}
		});

		lastNameCol.setPrefWidth(100);
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Contactdetails, String>("name"));
		lastNameCol.setCellFactory(cellFactory);
		lastNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Contactdetails, String>>() {
			@Override
			public void handle(CellEditEvent<Contactdetails, String> t) {

				if (adressbook.isName(t.getNewValue()) && !t.getNewValue().equals("")) {
					((Contactdetails) t.getTableView().getItems().get(t.getTablePosition().getRow()))
							.setName(t.getNewValue());
				} else {
					sendefehlerberichtbeieingabe();
				}
			}

		});

		adress.setPrefWidth(100);
		adress.setCellValueFactory(new PropertyValueFactory<Contactdetails, String>("adresse"));
		adress.setCellFactory(cellFactory);
		adress.setOnEditCommit(new EventHandler<CellEditEvent<Contactdetails, String>>() {
			@Override
			public void handle(CellEditEvent<Contactdetails, String> t) {
				if (adressbook.isAdresse(t.getNewValue())) {
					((Contactdetails) t.getTableView().getItems().get(t.getTablePosition().getRow()))
							.setAdresse(t.getNewValue());
				} else {
					sendefehlerberichtbeieingabe();
				}
			}
		});

		emailCol.setPrefWidth(250);
		emailCol.setCellValueFactory(new PropertyValueFactory<Contactdetails, String>("email"));
		emailCol.setCellFactory(cellFactory);
		emailCol.setOnEditCommit(new EventHandler<CellEditEvent<Contactdetails, String>>() {
			@Override
			public void handle(CellEditEvent<Contactdetails, String> t) {
				if (adressbook.isEmail(t.getNewValue())) {
					((Contactdetails) t.getTableView().getItems().get(t.getTablePosition().getRow()))
							.setEmail(t.getNewValue());
				} else {
					sendefehlerberichtbeieingabe();
				}
			}
		});

		telefonnumber.setPrefWidth(150);
		telefonnumber.setCellValueFactory(new PropertyValueFactory<Contactdetails, String>("telefonnummer"));
		telefonnumber.setCellFactory(cellFactory);
		telefonnumber.setOnEditCommit(new EventHandler<CellEditEvent<Contactdetails, String>>() {
			@Override
			public void handle(CellEditEvent<Contactdetails, String> t) {
				if (adressbook.isTelefonnummer(t.getNewValue())) {
					((Contactdetails) t.getTableView().getItems().get(t.getTablePosition().getRow()))
							.setTelefonnummer(t.getNewValue());
				} else {
					sendefehlerberichtbeieingabe();
				}
			}
		});

		table.setMaxWidth(firstNameCol.getPrefWidth() + lastNameCol.getPrefWidth() + adress.getPrefWidth()
				+ emailCol.getPrefWidth() + telefonnumber.getPrefWidth());

		table.getColumns().addAll(firstNameCol, lastNameCol, adress, emailCol, telefonnumber);

		final Button addButton = new Button("Hinzufügen");

		addButton.setOnAction((e) -> {
			if (addVorName.getText().isEmpty() || addNachname.getText().isEmpty()) {
				sendeWarnung(new Alert(AlertType.WARNING), "Warnung", "Vor- oder Nachname fehlt",
						"Vor- und Nachname müssen eingetragen werden");
				clearEingabeFeld();
				return;

			}

			if (!adressbook.keyInUse(addVorName.getText(), addNachname.getText(), adressbook.getData())
					&& adressbook.addDetails(listeEingabeFelder, this)) {

				adressbook.getData().add(new Contactdetails(addNachname.getText(), addVorName.getText(), addAdresse.getText(),
						addEmail.getText(), addTelefonnummer.getText()));
				clearEingabeFeld();
			} else {
				sendeWarnung(new Alert(AlertType.WARNING), "Warnung", "Fehlerhafte Eingabe",
						"Bitte überprüfen sie Ihre Eingabe.");

			}
		} );

		hb.getChildren().addAll(addVorName, addNachname, addAdresse, addEmail, addTelefonnummer, addButton);
		hb.setSpacing(3);

		final HBox hboxOben = new HBox();
		TextField search = new TextField();
		search.setPromptText("Suche");

		final ContextMenu cm = new ContextMenu();
		MenuItem cmItem1 = new MenuItem("Löschen");
		cm.getItems().add(cmItem1);

		cmItem1.setOnAction((e) -> {

			if (table.getSelectionModel().getSelectedItem() != null) {
				adressbook.getData().remove(table.getSelectionModel().getSelectedItem());
				table.getSelectionModel().clearSelection();
			} else {
				sendeWarnung(new Alert(AlertType.ERROR), "Fehler", "Fehler bei Löschvorgang",
						"Es können nur bestehende Einträge gelöscht werden");
			}

		} );
		table.setOnMousePressed((e) -> {

			if (e.isSecondaryButtonDown()) {
				cm.show(table, e.getScreenX(), e.getScreenY());
			} else {
				table.getSelectionModel().clearSelection();
				cm.hide();
			}
		} );
		adressbook.search(adressbook.getData(), search, table);

		hboxOben.getChildren().addAll(label, search);
		label.setPadding(new Insets(5, 380, 5, 5));
		search.setPadding(new Insets(5));
		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(hboxOben, table, hb);
		final HBox hboxSuper = new HBox();
		hboxSuper.getChildren().addAll(listView,vbox,tree);

		((Group) scene.getRoot()).getChildren().addAll(hboxSuper);

		stage.setScene(scene);
		stage.show();
	}

	private void sendeWarnung(Alert alarm2, String title, String headerText, String ContextText) {

		alarm2.setTitle(title);
		alarm2.setHeaderText(headerText);
		alarm2.setContentText(ContextText);
		alarm2.setResizable(true);
		alarm2.showAndWait();

	}

	private void clearEingabeFeld() {
		addVorName.clear();
		addNachname.clear();
		addAdresse.clear();
		addEmail.clear();
		addTelefonnummer.clear();
	}

	private void sendefehlerberichtbeieingabe() {
		sendeWarnung(new Alert(AlertType.ERROR), "Falsche Eingabe", "Falsche Eingabe", "Ihre Eingabe war fehlerhaft");
		table.getColumns().get(0).setVisible(false);
		table.getColumns().get(0).setVisible(true);
	}

	public TextField getAddVorName() {
		return addVorName;
	}

	public TextField getAddNachname() {
		return addNachname;
	}

	public TextField getAddAdresse() {
		return addAdresse;
	}

	public TextField getAddEmail() {
		return addEmail;
	}

	public TextField getAddTelefonnummer() {
		return addTelefonnummer;
	}

}
*/