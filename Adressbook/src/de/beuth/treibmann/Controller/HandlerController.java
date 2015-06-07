package de.beuth.treibmann.Controller;

import de.beuth.treibmann.Adressbook;
import de.beuth.treibmann.Contactdetails;
import de.beuth.treibmann.View.BenutzerOberflaeche;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellEditEvent;

public class HandlerController {



	@SuppressWarnings("unchecked")
	public void init(BenutzerOberflaeche benutzeroberflaeche, Adressbook adressbook) {
		benutzeroberflaeche.getFirstNameCol()
				.setOnEditCommit(new EventHandler<CellEditEvent<Contactdetails, String>>() {

					@Override
					public void handle(CellEditEvent<Contactdetails, String> t) {

						if (adressbook.isName(t.getNewValue()) && !t.getNewValue().equals("")) {
							((Contactdetails) t.getTableView().getItems().get(t.getTablePosition().getRow()))
									.setVorname(t.getNewValue());
							behebeAnzeigefehler(benutzeroberflaeche, adressbook);


						} else {

							new AlertController().sendeWarnung(new Alert(Alert.AlertType.ERROR), "Fehler",
									"Fehlerhafte Eingabe Vorname",
									"Ihre Eingabe " + t.getNewValue() + " war fehlerhaft");
							behebeAnzeigefehler(benutzeroberflaeche, adressbook);
						}
					}
				});

		benutzeroberflaeche.getLastNameCol().setOnEditCommit(new EventHandler<CellEditEvent<Contactdetails, String>>() {
			@Override
			public void handle(CellEditEvent<Contactdetails, String> t) {

				if (adressbook.isName(t.getNewValue()) && !t.getNewValue().equals("")) {
					((Contactdetails) t.getTableView().getItems().get(t.getTablePosition().getRow()))
							.setName(t.getNewValue());
					behebeAnzeigefehler(benutzeroberflaeche, adressbook);
				} else {
					new AlertController().sendeWarnung(new Alert(Alert.AlertType.ERROR), "Fehler",
							"Fehlerhafte Eingabe Nachname", "Ihre Eingabe " + t.getNewValue() + " war fehlerhaft");
					behebeAnzeigefehler(benutzeroberflaeche, adressbook);
				}
			}

		});

		benutzeroberflaeche.getAdress().setOnEditCommit(new EventHandler<CellEditEvent<Contactdetails, String>>() {
			@Override
			public void handle(CellEditEvent<Contactdetails, String> t) {
				if (adressbook.isAdresse(t.getNewValue())) {
					((Contactdetails) t.getTableView().getItems().get(t.getTablePosition().getRow()))
							.setAdresse(t.getNewValue());
					behebeAnzeigefehler(benutzeroberflaeche, adressbook);
				} else {
					new AlertController().sendeWarnung(new Alert(Alert.AlertType.ERROR), "Fehler",
							"Fehlerhafte Eingabe", "Ihre Eingabe " + t.getNewValue() + " war fehlerhaft");
					behebeAnzeigefehler(benutzeroberflaeche, adressbook);
				}
			}
		});

		benutzeroberflaeche.getEmailCol().setOnEditCommit(new EventHandler<CellEditEvent<Contactdetails, String>>() {
			@Override
			public void handle(CellEditEvent<Contactdetails, String> t) {
				if (adressbook.isEmail(t.getNewValue())) {
					((Contactdetails) t.getTableView().getItems().get(t.getTablePosition().getRow()))
							.setEmail(t.getNewValue());
					behebeAnzeigefehler(benutzeroberflaeche, adressbook);
				} else {
					new AlertController().sendeWarnung(new Alert(Alert.AlertType.ERROR), "Fehler",
							"Fehlerhafte Eingabe", "Ihre Eingabe " + t.getNewValue() + " war fehlerhaft");
					behebeAnzeigefehler(benutzeroberflaeche, adressbook);
				}
			}
		});

		benutzeroberflaeche.getTelefonnumber()
				.setOnEditCommit(new EventHandler<CellEditEvent<Contactdetails, String>>() {
					@Override
					public void handle(CellEditEvent<Contactdetails, String> t) {
						if (adressbook.isTelefonnummer(t.getNewValue())) {
							((Contactdetails) t.getTableView().getItems().get(t.getTablePosition().getRow()))
									.setTelefonnummer(t.getNewValue());
							behebeAnzeigefehler(benutzeroberflaeche, adressbook);
						} else {
							new AlertController().sendeWarnung(new Alert(Alert.AlertType.ERROR), "Fehler",
									"Fehlerhafte Eingabe", "Ihre Eingabe " + t.getNewValue() + " war fehlerhaft");
							behebeAnzeigefehler(benutzeroberflaeche, adressbook);
						}
					}
				});
	}

	public void fuegeeinEingabeFelder(BenutzerOberflaeche benutzeroberflaeche, Adressbook adressbook) {
		benutzeroberflaeche.getAddButton().setOnAction((e) -> {
			if (!adressbook.keyInUse(benutzeroberflaeche.getAddVorName().getText(),
					benutzeroberflaeche.getAddNachname().getText(), adressbook.getData())
					&& adressbook.addDetails(benutzeroberflaeche.getListeEingabeFelder(), benutzeroberflaeche)) {

				adressbook.getData().add(new Contactdetails(benutzeroberflaeche.getAddNachname().getText(),
						benutzeroberflaeche.getAddVorName().getText(), benutzeroberflaeche.getAddAdresse().getText(),
						benutzeroberflaeche.getAddEmail().getText(),
						benutzeroberflaeche.getAddTelefonnummer().getText()));
				clearEingabeFeld(benutzeroberflaeche);
			} else {
				new AlertController().sendeWarnung(new Alert(AlertType.WARNING), "Warnung",
						"Vor- oder Nachname in Benutzung", "Vor- und Nachname schon vorhanden");

			}
		} );

	}

	public void rechtsKlicken(BenutzerOberflaeche benutzerOberflaeche, Adressbook adressbook) {
		benutzerOberflaeche.getCm().getItems().add(benutzerOberflaeche.getCmItem1());

		benutzerOberflaeche.getCmItem1().setOnAction((e) -> {

			if (benutzerOberflaeche.getTable().getSelectionModel().getSelectedItem() != null) {
				adressbook.getData().remove(benutzerOberflaeche.getTable().getSelectionModel().getSelectedItem());
				benutzerOberflaeche.getTable().getSelectionModel().clearSelection();
			} else {
				new AlertController().sendeWarnung(new Alert(AlertType.ERROR), "Fehler", "Fehler bei Löschvorgang",
						"Es können nur bestehende Einträge gelöscht werden");
			}

		} );
		benutzerOberflaeche.getTable().setOnMousePressed((e) -> {

			if (e.isSecondaryButtonDown()) {
				benutzerOberflaeche.getCm().show(benutzerOberflaeche.getTable(), e.getScreenX(), e.getScreenY());
			} else {
				benutzerOberflaeche.getTable().getSelectionModel().clearSelection();
				benutzerOberflaeche.getCm().hide();
			}
		} );
	}

	@SuppressWarnings("unchecked")
	public void behebeAnzeigefehler(BenutzerOberflaeche benutzeroberflaeche, Adressbook adressbook) {
		benutzeroberflaeche.getTable().getColumns().get(0).setVisible(false);
		benutzeroberflaeche.getTable().getColumns().get(0).setVisible(true);
		benutzeroberflaeche.getListView().setItems(null);
		benutzeroberflaeche.getListView().setItems(benutzeroberflaeche.getTable().getItems());
		
		
	}

	private void clearEingabeFeld(BenutzerOberflaeche benutzerOberflaeche) {
		benutzerOberflaeche.getAddVorName().clear();
		benutzerOberflaeche.getAddNachname().clear();
		benutzerOberflaeche.getAddAdresse().clear();
		benutzerOberflaeche.getAddEmail().clear();
		benutzerOberflaeche.getAddTelefonnummer().clear();
	}

}
