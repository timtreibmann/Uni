package de.beuth.treibmann.Controller;

import java.io.FileNotFoundException;

import de.beuth.Treibmann.EinAusgabe.CSVAppointmentReader;
import de.beuth.treibmann.Adressbook;
import de.beuth.treibmann.Appointment;
import de.beuth.treibmann.Contactdetails;
import de.beuth.treibmann.View.BenutzerOberflaeche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.PropertyValueFactory;

public class EinfuegeController {

	private ObservableList<Appointment> appointmentlist = FXCollections.observableArrayList();

	@SuppressWarnings("unchecked")
	public void setAppointmentData(BenutzerOberflaeche benutzeroberflaeche, String source, String splitter)
			throws FileNotFoundException {
		appointmentlist.addAll(CSVAppointmentReader.readEntityList(source, splitter));
		System.out.println(appointmentlist.toString());
		benutzeroberflaeche.getTableappointment().setItems(appointmentlist);
		benutzeroberflaeche.getStartZeit()
				.setCellValueFactory(new PropertyValueFactory<Appointment, String>("startZeit"));
		benutzeroberflaeche.getEndZeit()
				.setCellValueFactory(new PropertyValueFactory<Contactdetails, String>("endZeit"));
		benutzeroberflaeche.getGesamtDauer()
				.setCellValueFactory(new PropertyValueFactory<Contactdetails, String>("gesamtDauer"));
		benutzeroberflaeche.getKategorie()
				.setCellValueFactory(new PropertyValueFactory<Contactdetails, String>("kategorie"));
		benutzeroberflaeche.getBeschreibung()
				.setCellValueFactory(new PropertyValueFactory<Contactdetails, String>("beschreibung"));
		benutzeroberflaeche.getBezeichnung()
				.setCellValueFactory(new PropertyValueFactory<Contactdetails, String>("bezeichnung"));
	}

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
		benutzeroberflaeche.getAdress()
				.setCellValueFactory(new PropertyValueFactory<Contactdetails, String>("adresse"));
		benutzeroberflaeche.getEmailCol()
				.setCellValueFactory(new PropertyValueFactory<Contactdetails, String>("email"));
		benutzeroberflaeche.getTelefonnumber()
				.setCellValueFactory(new PropertyValueFactory<Contactdetails, String>("telefonnummer"));
	}

	public void setData(BenutzerOberflaeche benutzeroberflaeche, Adressbook adressbook) {
		setListViewData(benutzeroberflaeche, adressbook);
		setTreeItemData(benutzeroberflaeche, adressbook);
		setTableViewData(benutzeroberflaeche, adressbook);
	}

}
