package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonRadioHandler;
import edu.fiuba.algo3.controlador.BotonResponderHandler;
import edu.fiuba.algo3.controlador.BotonSiguienteHandler;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.KahootModel;

public class MultipleChoiceVista extends VBox {

    private Stage stage;
    private Respuesta respuesta;
    private KahootModel kahoot;

    public MultipleChoiceVista(Stage stage, KahootModel kahoot) { //prueba para ver la vista de una pregunta MultipleChoice

        this.stage = stage;
        this.kahoot = kahoot;

        this.crearModelo();

        stage.setTitle("Kahoot Algos 3");

        Text turnoDelJugador = new Text(kahoot.jugadorDeTurno().nombre());

        Text tipoDePregunta = new Text("MultipleChoice Clasico");
        tipoDePregunta.setFont(Font.font("Arial", FontWeight.BLACK, 36));
        Text pregunta = new Text(" 2+2=..? ");
        pregunta.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        pregunta.setFill(Color.BLUE);

        FlowPane flowpane = new FlowPane();
        flowpane.setHgap(50);
        flowpane.setAlignment(Pos.CENTER);

        for (int i=0; i<kahoot.mostrarOpcionesDeTurno().size();i++) {
            RadioButton opcionRB = new RadioButton(kahoot.mostrarOpcionesDeTurno().get(i).contenido());
            flowpane.getChildren().add(opcionRB);
            BotonRadioHandler botonRadioHandler = new BotonRadioHandler(respuesta,kahoot.mostrarOpcionesDeTurno().get(i));
            opcionRB.setOnAction(botonRadioHandler);

        }

        Text puntaje1 = new Text("Puntaje: "+ respuesta.puntajeDelJugador());
        puntaje1.setFont(Font.font("Arial", FontWeight.BLACK, 20));

        Button responder = new Button("Responder");
        BotonResponderHandler botonResponderHandler = new BotonResponderHandler(kahoot,puntaje1,responder);
        responder.setOnAction(botonResponderHandler);

        Button continuar = new Button("Siguiente");
        BotonSiguienteHandler botonSiguienteHandler = new BotonSiguienteHandler(stage,kahoot);
        continuar.setOnAction(botonSiguienteHandler);

        this.getChildren().addAll(turnoDelJugador,tipoDePregunta,pregunta,puntaje1,flowpane,responder,continuar);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

    }


    public void crearModelo(){

        Respuesta respuestaJugador1 = new Respuesta(kahoot.jugadorDeTurno());
        kahoot.cargarRespuestas(respuestaJugador1);

        this.respuesta = respuestaJugador1;

    }

}


