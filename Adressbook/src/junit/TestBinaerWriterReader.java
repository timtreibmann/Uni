package junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import de.beuth.treibmann.Appointment;
import de.beuth.treibmann.binaereEinAusgabe.InputStream;
import de.beuth.treibmann.binaereEinAusgabe.OutputStream;

public class TestBinaerWriterReader {
	
	private final String path="/home/tim/Uni/Programmieren/speicherbinaer.bin";
	private Appointment listeraus;
	private Appointment listeraus2;
	private OutputStream output1;
	private InputStream input1;
	private Appointment listerein;
	private Appointment listerein2;
	
	@Before
	public void setUp() throws FileNotFoundException{
		listeraus = new Appointment(10, 20, "Kategorie", "bezeichnung", "beschreibung");
		listeraus2 = new Appointment(11, 21, "hans", "peter", "groß");
		listerein = new Appointment(0, 0, "", "", "");
		listerein2 = new Appointment(0, 0, "", "", "");
		output1 =  new OutputStream(path);
		input1  = new InputStream(path);
		
	}

	@Test
	public void test() {
		try{
			output1.writeOutputStream(listeraus);
			output1.writeOutputStream(listeraus2);
			
			output1.close();
			listerein = input1.readAppointment();
			listerein2 = input1.readAppointment();
			input1.close();
			
		}catch(IOException iox){
			iox.printStackTrace();
			fail("IO Problem");
		}
		assertEquals(listeraus.getStartZeit(), listerein.getStartZeit());
		assertEquals(listeraus.getEndZeit(), listerein.getEndZeit());
		assertEquals(listeraus.getKategorie(), listerein.getKategorie());
		assertEquals(listeraus.getBezeichnung(), listerein.getBezeichnung());
		assertEquals(listeraus.getBeschreibung(), listerein.getBeschreibung());
		
		assertEquals(listeraus2.getStartZeit(), listerein2.getStartZeit());
		assertEquals(listeraus2.getEndZeit(), listerein2.getEndZeit());
		assertEquals(listeraus2.getKategorie(), listerein2.getKategorie());
		assertEquals(listeraus2.getBezeichnung(), listerein2.getBezeichnung());
		assertEquals(listeraus2.getBeschreibung(), listerein2.getBeschreibung());
		
	}

}
