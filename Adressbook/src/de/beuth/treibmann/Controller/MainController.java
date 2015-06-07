package de.beuth.treibmann.Controller;

import de.beuth.treibmann.Adressbook;
import de.beuth.treibmann.View.BenutzerOberflaeche;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainController extends Application {

	private BenutzerOberflaeche benutzeroberflaeche;
	private Adressbook adressbook;
	private FactoryController factoryController;
	private HandlerController handlerController;
	private EinfuegeController einfuegeController;

	public MainController() {
		benutzeroberflaeche = new BenutzerOberflaeche();
		adressbook = new Adressbook();
		factoryController = new FactoryController();
		handlerController = new HandlerController();
		einfuegeController = new EinfuegeController();
		
	}

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		benutzeroberflaeche.start(primaryStage);
		
		factoryController.init(benutzeroberflaeche);
		handlerController.init(benutzeroberflaeche, adressbook);
		handlerController.fuegeeinEingabeFelder(benutzeroberflaeche, adressbook);
		einfuegeController.setData(benutzeroberflaeche, adressbook);
		handlerController.rechtsKlicken(benutzeroberflaeche, adressbook);
		adressbook.search(adressbook.getData(), benutzeroberflaeche.getSearch(), benutzeroberflaeche.getTable());
		
		
	}



	
}
