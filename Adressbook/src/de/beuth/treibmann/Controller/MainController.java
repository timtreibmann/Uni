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
	private PruefeEingabeController pruefeEingabeController;

	public MainController() {
		benutzeroberflaeche = new BenutzerOberflaeche();
		adressbook = new Adressbook();
		factoryController = new FactoryController();
		handlerController = new HandlerController();
		einfuegeController = new EinfuegeController();
		pruefeEingabeController = new PruefeEingabeController();
		
	}

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		benutzeroberflaeche.start(primaryStage);
		
		factoryController.init(benutzeroberflaeche);
		handlerController.init(benutzeroberflaeche,adressbook, pruefeEingabeController);
		
		handlerController.fuegeeinEingabeFelder(benutzeroberflaeche, adressbook, pruefeEingabeController);
		einfuegeController.setData(benutzeroberflaeche, adressbook);
		handlerController.rechtsKlicken(benutzeroberflaeche, adressbook);
		adressbook.search(adressbook.getData(), benutzeroberflaeche.getSearch(), benutzeroberflaeche.getTable());
		handlerController.onclickMenueTable(benutzeroberflaeche, adressbook);
		handlerController.onclickMenueTree(benutzeroberflaeche);
		handlerController.onclickMenueList(benutzeroberflaeche, adressbook);
		handlerController.fuegeEinBlank(benutzeroberflaeche, adressbook);
		
	}



	
}
