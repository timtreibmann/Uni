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

public class CSVAppointmentReader {
	
	public static List<Appointment> readEntityList(String dateiname, String splitter) throws FileNotFoundException{
		Path source = Paths.get(dateiname);
		return readEntityList(source, splitter);
	}
	public static List<Appointment> readEntityList(Path source, String splitter) throws FileNotFoundException{
		List<Appointment> target = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(source.toFile()));
		try{
			String zeile;
				while((zeile=br.readLine())!=null){
					String[] sA = zeile.split(splitter);
					target.add(new Appointment(Integer.parseInt(sA[0]), Integer.parseInt(sA[1]), sA[3], sA[4], sA[5]));
				}
				br.close();
				}catch (IOException ex) {ex.printStackTrace(System.err);
		target.addAll(null);}
	
		return target;

}
}