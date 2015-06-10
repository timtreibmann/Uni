package de.beuth.treibmann;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
/*Beans für AppointMent Objekte mit Properties*/

public class Appointment {
	private SimpleIntegerProperty startZeit;
	private SimpleIntegerProperty endZeit;
	private SimpleIntegerProperty gesamtDauer;
	private SimpleStringProperty kategorie;
	private SimpleStringProperty bezeichnung;
	private SimpleStringProperty beschreibung;
	private NumberBinding rechne;

	
	public Appointment (int start, int end,String kategorie, String bezeichnung,String beschreibung) throws NullPointerException{
		
		super();
		if (end<start)throw new NullPointerException();
		this.startZeit = new SimpleIntegerProperty(start);
		this.endZeit = new SimpleIntegerProperty(end);

		this.gesamtDauer = new SimpleIntegerProperty();
		
		this.kategorie = new SimpleStringProperty(kategorie);
		this.bezeichnung =  new SimpleStringProperty(bezeichnung);
		this.beschreibung = new SimpleStringProperty(beschreibung);
		rechne=endZeit.subtract(startZeit);
		gesamtDauer.bind(rechne);

	}


	public SimpleIntegerProperty startZeitProperty() {
		return this.startZeit;
	}


	public int getStartZeit() {
		return this.startZeitProperty().get();
	}


	public void setStartZeit(final int startZeit) {
		this.startZeitProperty().set(startZeit);
	}


	public SimpleIntegerProperty endZeitProperty() {
		return this.endZeit;
	}


	public int getEndZeit() {
		return this.endZeitProperty().get();
	}


	public void setEndZeit(final int endZeit) {
		this.endZeitProperty().set(endZeit);
	}


	public SimpleIntegerProperty gesamtDauerProperty() {
		return this.gesamtDauer;
	}


	public int getGesamtDauer() {
		return this.gesamtDauerProperty().get();
	}


	public void setGesamtDauer(final int gesamtDauer) {
		this.gesamtDauerProperty().set(gesamtDauer);
	}


	public SimpleStringProperty kategorieProperty() {
		return this.kategorie;
	}


	public java.lang.String getKategorie() {
		return this.kategorieProperty().get();
	}


	public void setKategorie(final java.lang.String kategorie) {
		this.kategorieProperty().set(kategorie);
	}


	public SimpleStringProperty bezeichnungProperty() {
		return this.bezeichnung;
	}


	public java.lang.String getBezeichnung() {
		return this.bezeichnungProperty().get();
	}


	public void setBezeichnung(final java.lang.String bezeichnung) {
		this.bezeichnungProperty().set(bezeichnung);
	}


	public SimpleStringProperty beschreibungProperty() {
		return this.beschreibung;
	}


	public java.lang.String getBeschreibung() {
		return this.beschreibungProperty().get();
	}


	public void setBeschreibung(final java.lang.String beschreibung) {
		this.beschreibungProperty().set(beschreibung);
	}
}