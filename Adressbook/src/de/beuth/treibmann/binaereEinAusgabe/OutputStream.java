package de.beuth.treibmann.binaereEinAusgabe;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import de.beuth.treibmann.Appointment;

public class OutputStream {

	DataOutputStream out;
	public OutputStream(String filename)throws FileNotFoundException{
		out = new DataOutputStream(new FileOutputStream(filename));
	}
	public void writeOutputStream(Appointment ap)throws IOException{
		out.writeInt(ap.getStartZeit());
		out.writeInt(ap.getEndZeit());
		out.writeUTF(ap.getKategorie());
		out.writeUTF(ap.getBezeichnung());
		out.writeUTF(ap.getBeschreibung());
	}
	public void close() throws IOException {
		out.close();
	}
}
