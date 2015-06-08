package junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.beuth.treibmann.Adressbook;
import de.beuth.treibmann.View.BenutzerOberflaeche;
import de.beuth.treibmann.Contactdetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

public class AdressBookTest {

	private Adressbook proband;

	private ObservableList<Contactdetails> obList;
	private ArrayList<TextField> txList;
	@Mock
	private Contactdetails vorhandenDetails;
	@Mock
	private BenutzerOberflaeche bnf;

	private final String nameNichtVorhanden = "Meier";
	private final String nameVorhanden = "Schulz";
	private final String vorNameNichtVorhanden = "Micha";
	private final String vorNameVorhanden = "Seppel";

	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		proband = new Adressbook();
		obList = FXCollections.observableArrayList(vorhandenDetails);
		txList = new ArrayList<TextField>();

		when(vorhandenDetails.getVorname()).thenReturn(vorNameVorhanden);
		when(vorhandenDetails.getName()).thenReturn(nameVorhanden);

	}

	@Test
	public void testKeyInUseTrue() {

		assertTrue(proband.keyInUse(vorNameVorhanden, nameVorhanden, obList));

	}

	@Test
	public void testKeyInUseFalse() {
		assertFalse(proband.keyInUse(vorNameNichtVorhanden, nameNichtVorhanden, obList));
	}

//	@Test
//	public void testIsName() {
//		assertTrue(proband.isName("Peter"));
//		ArrayList<String> liste = new ArrayList<String>();
//		liste.addAll(Arrays.asList("Peter2", "-Peter", " Peter"));
//		for (String string : liste) {
//
//			boolean invalid = proband.isName(string);
//			assertFalse(invalid);
//		}
//	}
//
//	@Test
//	public void testIsAdresse() {
//		ArrayList<String> liste = new ArrayList<String>();
//		liste.addAll(Arrays.asList("Erstestrasse 3", "Gute Str. 3", "Erste-Gute 23"));
//		for (String string : liste) {
//
//			boolean valid = proband.isAdresse(string);
//			assertTrue(valid);
//		}
//
//	}
//
//	@Test
//	public void testIsEmail() {
//		ArrayList<String> listeTrue = new ArrayList<String>();
//		listeTrue.addAll(Arrays.asList("tina@yahoo.com", "tina-100@yahoo.com", "tina.100@yahoo.com", "tina111@tina.com",
//				"tina-100@tina.net", "tina.100@tina.com.au", "tina@1.com", "tina@gmail.com.com", "tina+100@gmail.com",
//				"tina-100@yahoo-test.com"));
//		for (String string : listeTrue) {
//
//			boolean valid = proband.isEmail(string);
//			assertTrue(valid);
//		}
//
//		ArrayList<String> listeFalse = new ArrayList<String>();
//		listeFalse.addAll(Arrays.asList("tina", "tina@.com.my", "tina123@gmail.a", "tina123@.com", "tina123@.com.com",
//				".tina@tina.com", "tina()*@gmail.com", "tina@%*.com", "tina..2002@gmail.com", "tina.@gmail.com",
//				"tina@tina@gmail.com", "tina@gmail.com.1a"));
//		for (String string : listeFalse) {
//
//			boolean invalid = proband.isEmail(string);
//			assertFalse(invalid);
//		}
//	}
//
//	@Test
//	public void testIsTelefonnummer() {
//		assertTrue(proband.isTelefonnummer("3242234234"));
//		assertFalse(proband.isTelefonnummer("2324a243242"));
//	}

	@Test
	public void testaddDetails() {

		//
		// when(bnf.getAddVorName().getPromptText()).thenReturn("Vorname");
		//
		// proband.addDetails(txList, bnf);
		// verify(bnf).getAddVorName().setStyle(anyString());

	}

}
