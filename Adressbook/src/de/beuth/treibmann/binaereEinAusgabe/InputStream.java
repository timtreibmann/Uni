package de.beuth.treibmann.binaereEinAusgabe;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import de.beuth.treibmann.Appointment;

/**
 * Einleseklasse für Binäre Datein
 * 
 * @author tim
 *
 */
public class InputStream {

	DataInputStream in;

	/**
	 * Konstruktor der Klasse Inputstream. Initialisiert ein
	 * DataInputStremaobjekt anhand der Parameter.
	 * 
	 * @param filename
	 *            Dateiname
	 * @throws FileNotFoundException
	 *             Wird geworfen wenn Datei nicht gefunden wurde.
	 */
	public InputStream(String filename) throws FileNotFoundException {
		in = new DataInputStream(new FileInputStream(filename));
	}

	/**
	 * Methode die Appointmentobjekte einliest, in einer bestimmten Reihenfolge.
	 * 
	 * @return Ein Appointmentobjekt
	 * @throws IOException
	 *             Wird geworfen, wenn ein IO Fehler auftritt.
	 */
	public Appointment readAppointment() throws IOException {
		return (new Appointment(in.readInt(), in.readInt(), in.readUTF(), in.readUTF(), in.readUTF()));
	}

	/**
	 * Methode die das DataInputStreamObjekt schließt.
	 * 
	 * @throws IOException
	 *             Wird geworfen, wenn ein IO Fehler auftritt.
	 */
	public void close() throws IOException {
		in.close();
	}

}
