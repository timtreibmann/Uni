	package de.beuth.Treibmann.EinAusgabe;
	
	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.nio.file.Path;
	import java.nio.file.Paths;
	import java.util.ArrayList;
	import java.util.List;
	import de.beuth.treibmann.Appointment;
	
	
	/**
	 * Diese Klasse dient zum Einlesen von Appointmentdokumenten. Dabei wird ein
	 * Pfad/Dateiname eingelesen, sowie ein Splitter, welcher das Trennzeichen in
	 * der abgespeicherten Appointmentdatei vorgibt und die einzelnen Appointments
	 * trennt.
	 * 
	 * @author tim
	 * @version 1.0
	 *
	 */
	
	public class CSVAppointmentReader {
	
		/**
		 * Einfache ReadMethode die die Methode public static List
		 * <Appointment> readEntityList(Path source, String splitter) aufruft
		 * 
		 * @param dateiname
		 *            Dateiname
		 * @param splitter
		 *            Trenner innerhalb der geschriebenen Datei zwischen den
		 *            einzelnen Appointment Objekten
		 * @return Eine Liste von AppointmentObjekten
		 * @throws FileNotFoundException
		 *             Wird geworfen wenn Datei nicht gefunden wurde
		 */
		
		public static List<Appointment> readEntityList(String dateiname, String splitter) throws FileNotFoundException {
			Path source = Paths.get(dateiname);
			return readEntityList(source, splitter);
		}
	
		/**
		 * Readmethode für AppointmentObjekte aus einer Textdatei. Es wird aus der
		 * angegebenen Textdatei gelesen. Nach jedem Splitter wird ein neues
		 * Zielobjekt erstellt und gegebennenfalls Parameter geparst. Kann
		 * zusätzlich IOException werfen. Diese wird aber in der Methode gefangen.
		 * 
		 * @param dateiname
		 *            Dateiname
		 * @param splitter
		 *            Trenner innerhalb der geschriebenen Datei zwischen den
		 *            einzelnen Appointment Objekten
		 * @return Eine Liste von AppointmentObjekten
		 * @throws FileNotFoundException
		 *             Wird geworfen wenn Datei nicht gefunden wurde
		 */
	
		public static List<Appointment> readEntityList(Path source, String splitter) throws FileNotFoundException {
			List<Appointment> target = new ArrayList<>();
			BufferedReader br = new BufferedReader(new FileReader(source.toFile()));
			try {
				String zeile;
				while ((zeile = br.readLine()) != null) {
					String[] sA = zeile.split(splitter);
					target.add(new Appointment(Integer.parseInt(sA[0]), Integer.parseInt(sA[1]), sA[3], sA[4], sA[5]));
				}
				br.close();
			} catch (IOException ex) {
				ex.printStackTrace(System.err);
				target.addAll(null);
			}
	
			return target;
	
		}
	}