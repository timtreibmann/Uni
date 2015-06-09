package de.beuth.treibmann;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.util.Callback;

public class ObservableContactDetails extends Contactdetails {

	private SimpleStringProperty surnameP;
	private SimpleStringProperty nameP;
	private SimpleStringProperty adressP;
	private SimpleStringProperty phonenumberP;
	private SimpleStringProperty mailadressP;

	public ObservableContactDetails(String name, String vorname, String adresse, String email, String telefonnummer) {
		super(name, vorname, adresse, email, telefonnummer);

		this.phonenumberP = new SimpleStringProperty(telefonnummer);
		this.nameP = new SimpleStringProperty(name);
		this.adressP = new SimpleStringProperty(adresse);
		this.mailadressP = new SimpleStringProperty(email);
		this.surnameP = new SimpleStringProperty(vorname);

	}
	// TODO Auto-generated constructor stub

	@Override
	public String getVorname() {
		// TODO Auto-generated method stub
		return surnameP.get();

	}

	@Override
	public void setVorname(String surname) {
		// TODO Auto-generated method stub
		this.surnameP.set(surname);

	}

	public SimpleStringProperty SurnameProperty() {
		return surnameP;
	}

	@Override
	public String getTelefonnummer() {
		// TODO Auto-generated method stub
		return phonenumberP.get();
	}

	@Override
	public void setTelefonnummer(String phonenumber) {
		// TODO Auto-generated method stub
		this.phonenumberP.set(phonenumber);
		;
	}

	public SimpleStringProperty PhoneProperty() {
		return phonenumberP;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return nameP.get();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.nameP.set(name);
		;
	}

	public SimpleStringProperty NameProperty() {
		return nameP;
	}

	@Override
	public String getAdresse() {
		// TODO Auto-generated method stub
		return adressP.get();
	}

	@Override
	public void setAdresse(String adress) {
		// TODO Auto-generated method stub
		this.adressP.set(adress);
	}

	public SimpleStringProperty AdressProperty() {
		return adressP;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return mailadressP.get();
	}

	@Override
	public void setEmail(String mailadress) {
		// TODO Auto-generated method stub
		this.mailadressP.set(mailadress);
	}

	public SimpleStringProperty MailProperty() {
		return mailadressP;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public static Callback<ObservableContactDetails, Observable[]> extractor() {
		return (ObservableContactDetails p) -> new Observable[] { p.MailProperty(), p.AdressProperty(),
				p.NameProperty(), p.SurnameProperty(), p.PhoneProperty() };
	}
}
