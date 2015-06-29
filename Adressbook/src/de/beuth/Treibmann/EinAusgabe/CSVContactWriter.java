package de.beuth.Treibmann.EinAusgabe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import de.beuth.treibmann.Appointment;

/**
 * Diese Klasse dient zum Schreiben von AppointmentObjekten in eine Textdatei.
 * Dabei wird ein Pfad angegeben wo diese Datei hingeschrieben werden soll,
 * sowie ein Splitter welcher das Trennzeichen zwischen den einzelnen
 * Appointmentobjekten in der Textdatei darstellt.
 * 
 * @author tim
 * @version 1.0
 */

public class CSVContactWriter {
	final static Charset ENCODING = StandardCharsets.UTF_8;

	/**
	 * Einfache Schreibmethode die die Methode public static void
	 * writeEntityList(List<Appointment> contacts, Path path, String splitter)
	 * aufruft.
	 * 
	 * @param contacts
	 *            Liste der Appointmentobjekte
	 * @param filename
	 *            Name der Datei
	 * @param splitter
	 *            Trennzeichen zwischen den Appointmentobjekten in der Textdatei
	 * @throws IOException
	 *             Wird geworfen wenn Dateiname nicht verfügbar ist / erstellt
	 *             werden kann.
	 */
	public static void writeEntityList(List<Appointment> contacts, String filename, String splitter)
			throws IOException {
		Path path = Paths.get(filename);
		writeEntityList(contacts, path, splitter);
	}

	/**
	 * SchreibMethode von AppointmentObjekten in eine Textdatei. Dabei wird ein
	 * BuffererdWriter erstellt und jedes AppointmentObjekt über diesen Buffer
	 * in die Textdatei geschrieben. In der Methode wird außerdem die Methode
	 * private static String contactAsCSVLine(Appointment c, String splitter)
	 * aufgerufen.
	 * 
	 * @param contacts
	 *            Liste der Appointmentobjekte
	 * @param filename
	 *            Name der Datei
	 * @param splitter
	 *            Trennzeichen zwischen den Appointmentobjekten in der Textdatei
	 * @throws IOException
	 *             Wird geworfen wenn Dateiname nicht verfügbar ist / erstellt
	 *             werden kann.
	 */
	public static void writeEntityList(List<Appointment> contacts, Path path, String splitter) throws IOException {

		BufferedWriter bf = new BufferedWriter(new FileWriter(path.toFile()));
		for (Appointment contact : contacts) {
			bf.write(contactAsCSVLine(contact, splitter));
		}
		bf.close();

	}

	/**
	 * Diese Methode dient dazu, die einzelnen Eigenschaft eines
	 * Appointmentobjektes in die richtige Reihenfolge zu schreiben.
	 * 
	 * @param c Appointmentobjekt
	 * @param splitter	Trennzeichen
	 * @return Appointmentobjekt als String in der gewünschten Reihenfolge.
	 */

	private static String contactAsCSVLine(Appointment c, String splitter) {
		return c.getStartZeit() + splitter + c.getEndZeit() + splitter + c.getGesamtDauer() + splitter
				+ c.getKategorie() + splitter + c.getBezeichnung() + splitter + c.getBeschreibung()
				+ System.getProperty("line.separator");
	}
}
