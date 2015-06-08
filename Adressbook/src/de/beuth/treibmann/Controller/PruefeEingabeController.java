package de.beuth.treibmann.Controller;

import java.util.ArrayList;
import java.util.regex.Pattern;

import de.beuth.treibmann.View.BenutzerOberflaeche;
import javafx.scene.control.TextField;

public class PruefeEingabeController {
	
	public boolean checkDetails(ArrayList<TextField> textfield, BenutzerOberflaeche bnf) {

		boolean isRichtig = false;

		for (TextField textField2 : textfield) {

			if (textField2.getPromptText().contains("Vorname")) {
				isRichtig = isName(textField2.getText());
				bnf.getAddVorName().setStyle("-fx-background-color: none");
				bnf.getAddVorName().setStyle("-fx-innerborder-color: grey");
				if (!isRichtig) {
					bnf.getAddVorName().setStyle("-fx-background-color: red");
				}
			}
			if (isRichtig && textField2.getPromptText().contains("Nachname")) {
				isRichtig = isName(textField2.getText());
				bnf.getAddNachname().setStyle("-fx-background-color: none");
				bnf.getAddNachname().setStyle("-fx-innerborder-color: grey");
				if (!isRichtig) {
					bnf.getAddNachname().setStyle("-fx-background-color: red");
				}
			}
			if (isRichtig && textField2.getPromptText().contains("Adresse")) {
				isRichtig = isAdresse(textField2.getText());
				bnf.getAddAdresse().setStyle("-fx-background-color: none");
				bnf.getAddAdresse().setStyle("-fx-innerborder-color: grey");
				if (!isRichtig) {
					bnf.getAddAdresse().setStyle("-fx-background-color: red");
				}
			}
			if (isRichtig && textField2.getPromptText().contains("Email")) {
				isRichtig = isEmail(textField2.getText());
				bnf.getAddEmail().setStyle("-fx-background-color: none");
				bnf.getAddEmail().setStyle("-fx-innerborder-color: gray");
				if (!isRichtig) {
					bnf.getAddEmail().setStyle("-fx-background-color: red");
				}
			}
			if (isRichtig && textField2.getPromptText().contains("Telefonnummer")) {
				isRichtig = isTelefonnummer(textField2.getText());
				bnf.getAddTelefonnummer().setStyle("-fx-background-color: none");
				bnf.getAddTelefonnummer().setStyle("-fx-innerborder-color: grey");
				if (!isRichtig) {
					bnf.getAddTelefonnummer().setStyle("-fx-background-color: red");
				}
			}
			
		}
		return isRichtig;

	}

	public boolean isName(String string) {
		return Pattern.matches("[A-Za-z]*", string);
	}

	public boolean isAdresse(String string) {
		return Pattern.matches(
				"[A-Za-z]*[-]{0,1}[A-Za-z]*\\s[0-9]*[A-Za-z]{0,1}|[A-Za-z]*[-]{0,1}[A-Za-z]*\\s[A-Za-z]*[.]{0,1}\\s[0-9]*",
				string);
	}

	public boolean isEmail(String string) {
		return Pattern.matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
				string);
	}

	public boolean isTelefonnummer(String string) {
		return Pattern.matches("[0-9]*", string);
	}

}
