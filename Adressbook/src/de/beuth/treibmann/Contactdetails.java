/**
 * 
 */
package de.beuth.treibmann;

/**
 * @author tim treibmann
 *
 */
public class Contactdetails {

	private String name;
	private String vorname;
	private String adresse;
	private String email;
	private String telefonnummer;

	public Contactdetails(String name, String vorname, String adresse, String email, String telefonnummer) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.adresse = adresse;
		this.email = email;
		this.telefonnummer = telefonnummer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	@Override
	public String toString() {

		return name + "" + vorname + "" + adresse + "" + email + "" + telefonnummer;

	}

}
