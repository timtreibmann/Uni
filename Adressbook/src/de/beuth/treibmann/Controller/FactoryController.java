package de.beuth.treibmann.Controller;

import de.beuth.treibmann.EditingCell;
import de.beuth.treibmann.EditingCellList;
import de.beuth.treibmann.View.BenutzerOberflaeche;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class FactoryController {
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void init(BenutzerOberflaeche benutzeroberfläche){
		Callback<TableColumn, TableCell> cellFactory = new Callback<TableColumn, TableCell>() {
			public TableCell call(TableColumn p) {

				return new EditingCell();
			}
		};
		Callback<ListView, ListCell> cellFactoryLV = new Callback<ListView, ListCell>() {
		
			@Override
			public ListCell call(ListView param) {
				return new EditingCellList();
			}
		};
		
		benutzeroberfläche.getFirstNameCol().setCellFactory(cellFactory);
		benutzeroberfläche.getLastNameCol().setCellFactory(cellFactory);
		benutzeroberfläche.getAdress().setCellFactory(cellFactory);
		benutzeroberfläche.getEmailCol().setCellFactory(cellFactory);
		benutzeroberfläche.getTelefonnumber().setCellFactory(cellFactory);
		benutzeroberfläche.getListView().setCellFactory(cellFactoryLV);
		
	}

}
