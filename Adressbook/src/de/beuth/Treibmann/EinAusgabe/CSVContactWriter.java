package de.beuth.Treibmann.EinAusgabe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import de.beuth.treibmann.Appointment;

public class CSVContactWriter {
	final static Charset ENCODING = StandardCharsets.UTF_8;

	public static void writeEntityList(List<Appointment> contacts, String filename, String splitter)
			throws IOException {
		Path path = Paths.get(filename);
		writeEntityList(contacts, path, splitter);
	}

	public static void writeEntityList(List<Appointment> contacts, Path path, String splitter) throws IOException {
		
		BufferedWriter bf = new BufferedWriter(new FileWriter(path.toFile()));
		for (Appointment contact : contacts) {
			bf.write(contactAsCSVLine(contact, splitter));
		}
		bf.close();
		
	}

	private static String contactAsCSVLine(Appointment c, String splitter) {
		return c.getStartZeit() + splitter + c.getEndZeit() + splitter + c.getGesamtDauer() + splitter
				+ c.getKategorie() + splitter + c.getBezeichnung() + splitter + c.getBeschreibung()+System.getProperty("line.separator");
	}
}
