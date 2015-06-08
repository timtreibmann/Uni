package de.beuth.treibmann.Controller;

import de.beuth.treibmann.Adressbook;
import de.beuth.treibmann.Contactdetails;
import de.beuth.treibmann.View.BenutzerOberflaeche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.PropertyValueFactory;

public class EinfuegeController {
	
	
	
	@SuppressWarnings("unchecked")
	public void setListViewData(BenutzerOberflaeche benutzeroberflaeche, Adressbook adressbook) {
	
		adressbook.createObListforListView();
		benutzeroberflaeche.getListView().setItems(adressbook.getDataList());
		
	}

	public void setTreeItemData(BenutzerOberflaeche benutzeroberflaeche, Adressbook adressbook) {

		for (Contactdetails cd : adressbook.getData()) {
			TreeItem<String> ersternode = new TreeItem<String>(cd.getName());
			ersternode.getChildren().add(new TreeItem<String>(cd.getVorname()));
			ersternode.getChildren().add(new TreeItem<String>(cd.getEmail()));
			ersternode.getChildren().add(new TreeItem<String>(cd.getAdresse()));
			ersternode.getChildren().add(new TreeItem<String>(cd.getTelefonnummer()));
			benutzeroberflaeche.getRootItem().getChildren().add(ersternode);
		}
	}

	@SuppressWarnings("unchecked")
	public void setTableViewData(BenutzerOberflaeche benutzeroberflaeche, Adressbook adressbook) {
		benutzeroberflaeche.getTable().setItems(adressbook.getData());
		benutzeroberflaeche.getFirstNameCol()
				.setCellValueFactory(new PropertyValueFactory<Contactdetails, String>("vorname"));
		benutzeroberflaeche.getLastNameCol()
				.setCellValueFactory(new PropertyValueFactory<Contactdetails, String>("name"));
		benutzeroberflaeche.getAdress().setCellValueFactory(new PropertyValueFactory<Contactdetails, String>("adresse"));
		benutzeroberflaeche.getEmailCol().setCellValueFactory(new PropertyValueFactory<Contactdetails, String>("email"));
		benutzeroberflaeche.getTelefonnumber()
				.setCellValueFactory(new PropertyValueFactory<Contactdetails, String>("telefonnummer"));
	}
	public void setData(BenutzerOberflaeche benutzeroberflaeche, Adressbook adressbook) {
		setListViewData(benutzeroberflaeche, adressbook);
		setTreeItemData(benutzeroberflaeche, adressbook);
		setTableViewData(benutzeroberflaeche, adressbook);
	}

}
