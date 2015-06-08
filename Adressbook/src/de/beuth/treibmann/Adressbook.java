/**
 * 
 */
package de.beuth.treibmann;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * @author tim für mahan2
 *
 */
public class Adressbook implements AdressbookInterface {

	private ObservableList<Contactdetails> data = FXCollections.observableArrayList(
			new Contactdetails("Meister", "Jacob", "Straße 21", "jacob.smith@example.com", "12346"),
			new Contactdetails("Johnson", "Isabella", "Weg 82", "isabella.johnson@example.com", "43545435"),
			new Contactdetails("Williams", "Ethan", "Blusenstraße 21", "ethan.williams@example.com", "744546465"),
			new Contactdetails("Jones", "Emma", "Berlinerstr. 56", "emma.jones@example.com", "7867863"),
			new Contactdetails("Brown", "Michael", "Schlossweg 90", "michael.brown@example.com", "123123"));

	private ObservableList<String> dataList = FXCollections.observableArrayList();

	public void createObListforListView() {
		dataList.clear();
		for (Contactdetails cd : data) {

			dataList.add(cd.getName());
		}
		;

	}

	public void updateData(ObservableList<Contactdetails> data, ObservableList<String> dataList) {
		int i = 0;
		for (Contactdetails cd : data) {
			cd.setName(dataList.get(i));
			i++;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.beuth.treibmann.AdressbookInterface#getDetails(java.lang.String)
	 */
	public Contactdetails getDetails(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.beuth.treibmann.AdressbookInterface#keyInUse(java.lang.String)
	 */

	public boolean keyInUse(String vorname, String nachname, ObservableList<Contactdetails> dataKey) {
		for (Contactdetails contactdetails : dataKey) {

			if (contactdetails.getVorname().equals(vorname) && contactdetails.getName().equals(nachname)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.beuth.treibmann.AdressbookInterface#addDetails(de.beuth.treibmann.
	 * Contactdetails)
	 */

	public void addDetails(Contactdetails contactdetails) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.beuth.treibmann.AdressbookInterface#changeDetails(java.lang.String,
	 * de.beuth.treibmann.Contactdetails)
	 */

	public void changeDetails(String oldKey, Contactdetails newDetails) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.beuth.treibmann.AdressbookInterface#search(java.lang.String)
	 */

	public void searchListView(ObservableList<String> data1, TextField search, ListView<String> listview) {
		FilteredList<String> filteredData = new FilteredList<>(data1, p -> true);
		search.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(person -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				// Compare first name and last name of every person with filter
				// text.
				String lowerCaseFilter = newValue.toLowerCase();
				if (person.toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			} );
		} );
	}

	public void search(ObservableList<Contactdetails> data1, TextField search, TableView<Contactdetails> table) {

		// 1. Wrap the ObservableList in a FilteredList (initially display all
		// data).
		FilteredList<Contactdetails> filteredData = new FilteredList<>(data1, p -> true);

		// 2. Set the filter Predicate whenever the filter changes.
		search.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(person -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				// Compare first name and last name of every person with filter
				// text.
				String lowerCaseFilter = newValue.toLowerCase();
				if (person.getVorname().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches first name.
				} else if (person.getName().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches last name.
				} else if (person.getEmail().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches email.
				} else if (person.getAdresse().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches adresse.
				} else if (person.getTelefonnummer().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches telefonnummer.
				}

				return false; // Does not match.
			} );
		} );

		// 3. Wrap the FilteredList in a SortedList.
		SortedList<Contactdetails> sortedData = new SortedList<>(filteredData);

		// 4. Bind the SortedList comparator to the TableView comparator.
		sortedData.comparatorProperty().bind(table.comparatorProperty());

		// 5. Add sorted (and filtered) data to the table.

		table.setItems(sortedData);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.beuth.treibmann.AdressbookInterface#getNumberOfEntries()
	 */

	public int getNumberOfEntries() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.beuth.treibmann.AdressbookInterface#removeDetails(java.lang.String)
	 */

	public void removeDetails(String key) {
		// TODO Auto-generated method stub

	}

	public ObservableList<Contactdetails> getData() {
		return data;
	}

	public void setData(ObservableList<Contactdetails> data) {
		this.data = data;
	}

	public ObservableList<String> getDataList() {
		return dataList;
	}

	public void setDataList(ObservableList<String> dataList) {
		this.dataList = dataList;
	}

}
