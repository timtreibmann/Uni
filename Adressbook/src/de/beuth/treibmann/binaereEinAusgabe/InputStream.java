package de.beuth.treibmann.binaereEinAusgabe;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import de.beuth.treibmann.Appointment;

public class InputStream {
	
	DataInputStream in;
	public InputStream(String filename)throws FileNotFoundException{
		in = new DataInputStream(new FileInputStream(filename));
	}
	public Appointment readAppointment() throws IOException{
		return (new Appointment(in.readInt(), in.readInt(), in.readUTF(), in.readUTF(), in.readUTF()));
	}
	public void close() throws IOException{
		in.close();
	}

}
