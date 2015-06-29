package junit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import de.beuth.Treibmann.EinAusgabe.CSVAppointmentReader;
import de.beuth.Treibmann.EinAusgabe.CSVContactWriter;
import de.beuth.treibmann.Appointment;

/**
 * TestKlasse für die Klassen CSVAppointmentReader und CSVContactWriter.
 * 
 * @author tim
 *
 */

public class TestWriter {
	private final String path = "/home/tim/Uni/Programmieren/speicher.txt";
	private List<Appointment> liste;

	/**
	 * TestsetUp erzeugen. Es wird hier bereits eine Datei geschrieben.
	 * 
	 * @throws IOException
	 */
	@Before
	public void setUp() throws IOException {
		liste = new ArrayList<Appointment>();
		liste.add(new Appointment(10, 20, "Kategorie", "bezeichnung", "beschreibung"));
		liste.add(new Appointment(11, 21, "Mensch", "Hübsch", "Mahan"));
		CSVContactWriter.writeEntityList(liste, path, ":");
	}

	/**
	 * Testet ob die geschriebene Datei die korrekten Dateien enthält. Dies
	 * geschieht durch einlesen dieser Datei.
	 */
	@Test
	public void testlesen() {
		try {
			List<Appointment> liste2 = CSVAppointmentReader.readEntityList(path, ":");
			assertEquals(liste.get(0).getBeschreibung(), liste2.get(0).getBeschreibung());
			assertEquals(liste.get(0).getBezeichnung(), liste2.get(0).getBezeichnung());
			assertEquals(liste.get(0).getKategorie(), liste2.get(0).getKategorie());
			assertEquals(liste.get(0).getEndZeit(), liste2.get(0).getEndZeit());
			assertEquals(liste.get(0).getStartZeit(), liste2.get(0).getStartZeit());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
