package de.beuth.treibmann;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Ein Adressbuch speichert Kontaktdaten in Form eines Contactdetails-Objekt und
 * ermöglicht es dem Benutzer neue Kontakte anzulegen, alte Kontakte zu löschen,
 * alte Kontake zu editieren, nach bestehenden Kontakten zu suchen. Außerdem
 * werden zwei weitere Methoden zur Verfügung gestellt, die es ermöglichen
 * bestimmte Kontakte zurückgeben oder nachzuschauen ob ein bestimmter Schlüssel
 * von einem Kontakt bereit benutzt wird.
 * 
 * @author tim treibmann
 *
 */
public interface AdressbookInterface {

	/**
	 * Es wird ein Contactdetails entsprechend des passenden Schlüssels
	 * zurückgeben. Bei der Übergabe eines validen Schlüssels wird das
	 * entsprechende Contactdetails-Objekt zurück gegeben.
	 * 
	 * @param key
	 *            Ein Schlüssel, der aus Name und/oder Vorname des Kontaktes
	 *            besteht.
	 * @return Ein Contactdetails, welches den Schlüsselparameter beinhaltet.
	 */
	public Contactdetails getDetails(String key);

	/**
	 * Es wird geprüft ob der übergebene Schlüssel bereits von einem
	 * abgespeicherten Contactdetails-Objekt benutzt wird. Sollte dies der Fall
	 * sein wird true zurückgeliefert. Ist der übergebene Schlüssel nicht von
	 * einem Contactdetails-Objekt in Benutzung wird false zurückgeliefert.
	 * 
	 * @param key
	 *            Ein Schlüssel, der aus Name und/oder Vorname des Kontaktes
	 *            besteht.
	 * @return True wenn der Schlüssel in Benutzung ist. False wenn der
	 *         Schlüssel nicht in Benutzung ist.
	 */
	public boolean keyInUse(String vorname, String nachname, ObservableList<Contactdetails> dataKey);

	/**
	 * Es wird ein Contactdetails-Objekt übergeben und dem Adressbuch
	 * hinzugeführt.
	 * 
	 * @param details
	 *            Ein Contactdetails-Objekt, welches einen Kontakt
	 *            repräsentiert.
	 */
	public boolean addDetails(ArrayList<TextField> textfield, BenutzerOberflaeche bnf);

	/**
	 * Es wird ein bestehendes Contactdetails-Objekt anhand des übergebenden
	 * Schlüssels aufgesucht und die Kontakteigenschaften mit den neuen
	 * übergebenden Contactdetails-Eigenschaften überschrieben.
	 * 
	 * @param oldKey
	 *            Ein Schlüssel der das entsprechende Contactdetails-Objekt
	 *            identifiziert.
	 * @param newDetails
	 *            Ein Contactdetails-Objekt, welches die Änderungen des zu
	 *            bearbeitenden gewünschten Kontaktes enthält.
	 */
	public void changeDetails(String oldKey, Contactdetails newDetails);

	/**
	 * Anhand eines übergebenden Begriffes wird das entsprechende
	 * Kontaktdetails-Objekt gesucht. Dabei wird nicht nur anhand des Schlüssels
	 * sondern anhand aller Eigenschaften des Kontaktes gesucht.
	 * 
	 * @param keyPrefix
	 *            Suchbegriff anhand dessen das entsprechende
	 *            Contactdetails-Objekt gesucht wird.
	 * @return Ein Contactdetails-Objekt, welches den keyPrefix enthält.
	 */
	public void search(ObservableList<Contactdetails> data1, TextField search, TableView<Contactdetails> table);

	/**
	 * Gibt die Anzahl aller Kontakteinträge zurück.
	 * 
	 * @return Einen Int-Wert, welcher die Anzahl aller Kontakte widerspiegelt.
	 */
	public int getNumberOfEntries();

	/**
	 * Es wird ein Kontakt aus dem Adressbuch gelöscht, welches den übergebenden
	 * Schlüssel besitzt.
	 * 
	 * @param key
	 *            Ein Schlüssel, welcher zur Identifikation des entsprechenden
	 *            Kontaktes dient.
	 */
	public void removeDetails(String key);

	

	

	

	

	

}
