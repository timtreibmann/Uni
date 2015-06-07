package de.beuth.treibmann.Controller;

import javafx.scene.control.Alert;

public class AlertController {
	
	public void sendeWarnung(Alert alarm2, String title, String headerText, String ContextText) {

		alarm2.setTitle(title);
		alarm2.setHeaderText(headerText);
		alarm2.setContentText(ContextText);
		alarm2.setResizable(true);
		alarm2.showAndWait();

	}

}
