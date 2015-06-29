package de.beuth.treibmann.binaereEinAusgabe;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import de.beuth.treibmann.Appointment;

/**
 * Diese Klasse schreibt AppointmentObjekte als Binaeredateien.
 * 
 * @author tim
 *
 */

public class OutputStream {

	DataOutputStream out;

	/**
	 * Konstruktur der Klasse Outputstream. Initialisiert ein
	 * DataOutputStreamObjekt.
	 * 
	 * @param filename
	 *            Dateiname
	 * @throws FileNotFoundException
	 *             Wird geworfen, wenn keine Datei gefunden wurde.
	 */
	public OutputStream(String filename) throws FileNotFoundException {
		out = new DataOutputStream(new FileOutputStream(filename));
	}

	/**
	 * Diese Methode schreibt, das als Parameter übergebene AppointmentObjekt
	 * als Binärdatei über den DataOutputstream.
	 * 
	 * @param ap AppointmentObjekt
	 * @throws IOException Wird geworfen, wenn ein IO Problem auftritt.
	 */
	public void writeOutputStream(Appointment ap) throws IOException {
		out.writeInt(ap.getStartZeit());
		out.writeInt(ap.getEndZeit());
		out.writeUTF(ap.getKategorie());
		out.writeUTF(ap.getBezeichnung());
		out.writeUTF(ap.getBeschreibung());
	}

	/**
	 * Methode die das DataOutputStreamObjekt schließt.
	 * 
	 * @throws IOException
	 *             Wird geworfen, wenn ein IO Fehler auftritt.
	 */
	public void close() throws IOException {
		out.close();
	}
}
