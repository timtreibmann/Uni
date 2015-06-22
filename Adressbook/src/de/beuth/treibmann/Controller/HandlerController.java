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
	public void init(BenutzerOberflaeche benutzeroberflaeche, Adressbook adressbook,
			PruefeEingabeController pruefeingabecontroller) {
		benutzeroberflaeche.getFirstNameCol()
				.setOnEditCommit(new EventHandler<CellEditEvent<Contactdetails, String>>() {

					@Override
					public void handle(CellEditEvent<Contactdetails, String> t) {

						if ((pruefeingabecontroller.isName(t.getNewValue())) && (!t.getNewValue().equals(""))) {
							((Contactdetails) t.getTableView().getItems().get(t.getTablePosition().getRow()))
									.setVorname(t.getNewValue());

							behebeAnzeigefehler(benutzeroberflaeche);

						} else {

							new AlertController().sendeWarnung(new Alert(Alert.AlertType.ERROR), "Fehler",
									"Fehlerhafte Eingabe Vorname",
									"Ihre Eingabe " + t.getNewValue() + " war fehlerhaft");
							behebeAnzeigefehler(benutzeroberflaeche);

						}
					}
				});

		benutzeroberflaeche.getLastNameCol().setOnEditCommit(new EventHandler<CellEditEvent<Contactdetails, String>>() {
			@Override
			public void handle(CellEditEvent<Contactdetails, String> t) {

				if ((pruefeingabecontroller.isName(t.getNewValue())) && (!t.getNewValue().equals(""))) {
					((Contactdetails) t.getTableView().getItems().get(t.getTablePosition().getRow()))
							.setName(t.getNewValue());

					behebeAnzeigefehler(benutzeroberflaeche);
				} else {
					new AlertController().sendeWarnung(new Alert(Alert.AlertType.ERROR), "Fehler",
							"Fehlerhafte Eingabe Nachname", "Ihre Eingabe " + t.getNewValue() + " war fehlerhaft");
					behebeAnzeigefehler(benutzeroberflaeche);
				}
			}

		});

		benutzeroberflaeche.getAdress().setOnEditCommit(new EventHandler<CellEditEvent<Contactdetails, String>>() {
			@Override
			public void handle(CellEditEvent<Contactdetails, String> t) {
				if (pruefeingabecontroller.isAdresse(t.getNewValue())) {
					((Contactdetails) t.getTableView().getItems().get(t.getTablePosition().getRow()))
							.setAdresse(t.getNewValue());
					behebeAnzeigefehler(benutzeroberflaeche);
				} else {
					new AlertController().sendeWarnung(new Alert(Alert.AlertType.ERROR), "Fehler",
							"Fehlerhafte Eingabe", "Ihre Eingabe " + t.getNewValue() + " war fehlerhaft");
					behebeAnzeigefehler(benutzeroberflaeche);
				}
			}
		});

		benutzeroberflaeche.getEmailCol().setOnEditCommit(new EventHandler<CellEditEvent<Contactdetails, String>>() {
			@Override
			public void handle(CellEditEvent<Contactdetails, String> t) {
				if (pruefeingabecontroller.isEmail(t.getNewValue())) {
					((Contactdetails) t.getTableView().getItems().get(t.getTablePosition().getRow()))
							.setEmail(t.getNewValue());
					behebeAnzeigefehler(benutzeroberflaeche);
				} else {
					new AlertController().sendeWarnung(new Alert(Alert.AlertType.ERROR), "Fehler",
							"Fehlerhafte Eingabe", "Ihre Eingabe " + t.getNewValue() + " war fehlerhaft");
					behebeAnzeigefehler(benutzeroberflaeche);
				}
			}
		});

		benutzeroberflaeche.getTelefonnumber()
				.setOnEditCommit(new EventHandler<CellEditEvent<Contactdetails, String>>() {
					@Override
					public void handle(CellEditEvent<Contactdetails, String> t) {
						if (pruefeingabecontroller.isTelefonnummer(t.getNewValue())) {
							((Contactdetails) t.getTableView().getItems().get(t.getTablePosition().getRow()))
									.setTelefonnummer(t.getNewValue());
							behebeAnzeigefehler(benutzeroberflaeche);
						} else {
							new AlertController().sendeWarnung(new Alert(Alert.AlertType.ERROR), "Fehler",
									"Fehlerhafte Eingabe", "Ihre Eingabe " + t.getNewValue() + " war fehlerhaft");
							behebeAnzeigefehler(benutzeroberflaeche);
						}
					}
				});
	}

	public void fuegeeinEingabeFelder(BenutzerOberflaeche benutzeroberflaeche, Adressbook adressbook,
			PruefeEingabeController eingabe) {
		benutzeroberflaeche.getAddButton().setOnAction((e) -> {
			if (!adressbook.keyInUse(benutzeroberflaeche.getAddVorName().getText(),
					benutzeroberflaeche.getAddNachname().getText(), adressbook.getData())
					&& eingabe.checkDetails(benutzeroberflaeche.getListeEingabeFelder(), benutzeroberflaeche)) {

				adressbook.getData().add(new Contactdetails(benutzeroberflaeche.getAddNachname().getText(),
						benutzeroberflaeche.getAddVorName().getText(), benutzeroberflaeche.getAddAdresse().getText(),
						benutzeroberflaeche.getAddEmail().getText(),
						benutzeroberflaeche.getAddTelefonnummer().getText()));
				adressbook.createObListforListView();
				clearEingabeFeld(benutzeroberflaeche);
			} else {
				new AlertController().sendeWarnung(new Alert(AlertType.WARNING), "Warnung", "Falsche Eingabe",
						"Ihre Eingabe war falsch!");

			}
		} );

	}

	public void fuegeEinBlank(BenutzerOberflaeche benutzerOberflaeche, Adressbook adressbook) {
		benutzerOberflaeche.getAddbuttonBlank().setOnAction((e) -> {
			adressbook.getData().add(new Contactdetails("name", "vorname", "adresse", "email", "telefonnummer"));
			adressbook.createObListforListView();
			this.behebeAnzeigefehler(benutzerOberflaeche);

		} );
	}

	public void zeigeAnDateninConsole(BenutzerOberflaeche benutzerOberflaeche, Adressbook adressbook) {
		benutzerOberflaeche.getConsolenAusgabe().setOnAction((e) -> {
			if (benutzerOberflaeche.getTable().isEditable())
				System.out.println(adressbook.getData().toString());
			if (benutzerOberflaeche.getListView().isEditable())
				System.out.println(adressbook.getDataList().toString());
		} );
	}

	public void rechtsKlicken(BenutzerOberflaeche benutzerOberflaeche, Adressbook adressbook) {
		benutzerOberflaeche.getCm().getItems().add(benutzerOberflaeche.getCmItem1());

		benutzerOberflaeche.getCmItem1().setOnAction((e) -> {

			if (benutzerOberflaeche.getTable().getSelectionModel().getSelectedItem() != null) {
				adressbook.getData().remove(benutzerOberflaeche.getTable().getSelectionModel().getSelectedItem());
				benutzerOberflaeche.getTable().getSelectionModel().clearSelection();
			} else if (benutzerOberflaeche.getListView().getSelectionModel().getSelectedItem() != null) {
				adressbook.getData().remove(benutzerOberflaeche.getListView().getSelectionModel().getSelectedIndex());
				adressbook.createObListforListView();
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
		benutzerOberflaeche.getListView().setOnMousePressed((e) -> {

			if (e.isSecondaryButtonDown()) {
				benutzerOberflaeche.getCm().show(benutzerOberflaeche.getListView(), e.getScreenX(), e.getScreenY());
			} else if (!e.isPrimaryButtonDown()){
				benutzerOberflaeche.getListView().getSelectionModel().clearSelection();
				benutzerOberflaeche.getCm().hide();
			}
		} );
	}

	public void onclickMenueTable(BenutzerOberflaeche benutzerOberflaeche, Adressbook adressbook) {
		benutzerOberflaeche.getMenueTable().setOnAction((e) -> {
			adressbook.updateData(adressbook.getData(), adressbook.getDataList());
			this.behebeAnzeigefehler(benutzerOberflaeche);
			benutzerOberflaeche.getContentBox().getChildren().remove(0);
			benutzerOberflaeche.getContentBox().getChildren().add(benutzerOberflaeche.getTable());
			benutzerOberflaeche.getTable().setEditable(true);
			benutzerOberflaeche.getListView().setEditable(false);
			benutzerOberflaeche.getTree().setEditable(false);
			benutzerOberflaeche.getTableappointment().setVisible(false);
			benutzerOberflaeche.getTable().setVisible(true);

		} );

	}

	public void onclickMenueList(BenutzerOberflaeche benutzerOberflaeche, Adressbook adressbook) {

		benutzerOberflaeche.getMenueList().setOnAction((e) -> {
			adressbook.createObListforListView();
			benutzerOberflaeche.getContentBox().getChildren().remove(0);
			benutzerOberflaeche.getContentBox().getChildren().add(benutzerOberflaeche.getListView());
			benutzerOberflaeche.getListView().setEditable(true);
			benutzerOberflaeche.getTable().setEditable(false);
			benutzerOberflaeche.getTree().setEditable(false);
			benutzerOberflaeche.getTableappointment().setVisible(false);
			benutzerOberflaeche.getListView().setVisible(true);
			

		} );

	}

	public void onclickMenueTree(BenutzerOberflaeche benutzerOberflaeche) {
		benutzerOberflaeche.getMenueTree().setOnAction((e) -> {
			benutzerOberflaeche.getContentBox().getChildren().remove(0);
			benutzerOberflaeche.getContentBox().getChildren().add(benutzerOberflaeche.getTree());
			benutzerOberflaeche.getTree().setEditable(true);
			benutzerOberflaeche.getListView().setEditable(false);
			benutzerOberflaeche.getTable().setEditable(false);
			benutzerOberflaeche.getTree().setVisible(true);
			benutzerOberflaeche.getTableappointment().setVisible(false);
		} );

	}
	
	public void onclickMenueTableAppointment(BenutzerOberflaeche benutzerOberflaeche, Adressbook adressbook) {
		benutzerOberflaeche.getMenueTableAppointment().setOnAction((e) -> {
			benutzerOberflaeche.getContentBox().getChildren().remove(0);
			benutzerOberflaeche.getContentBox().getChildren().add(benutzerOberflaeche.getTableappointment());
			
			benutzerOberflaeche.getTable().setEditable(false);
			benutzerOberflaeche.getListView().setEditable(false);
			benutzerOberflaeche.getTree().setEditable(false);
			benutzerOberflaeche.getTable().setVisible(false);
			benutzerOberflaeche.getTableappointment().setVisible(true);

		} );

	}

	@SuppressWarnings("unchecked")
	public void behebeAnzeigefehler(BenutzerOberflaeche benutzeroberflaeche) {
		benutzeroberflaeche.getTable().getColumns().get(0).setVisible(false);
		benutzeroberflaeche.getTable().getColumns().get(0).setVisible(true);
		benutzeroberflaeche.getListView().setVisible(false);
		benutzeroberflaeche.getListView().setVisible(true);

	}

	private void clearEingabeFeld(BenutzerOberflaeche benutzerOberflaeche) {
		benutzerOberflaeche.getAddVorName().clear();
		benutzerOberflaeche.getAddNachname().clear();
		benutzerOberflaeche.getAddAdresse().clear();
		benutzerOberflaeche.getAddEmail().clear();
		benutzerOberflaeche.getAddTelefonnummer().clear();
	}

}
