package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.KahootModel;
import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.vista.PuntosVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonSiguienteVistaHandler implements EventHandler<ActionEvent> {

    Stage stage;
    KahootModel kahoot;
    DetectorDeVista  siguientePregunta;


    public BotonSiguienteVistaHandler(Stage stage, KahootModel kahoot) {

        this.stage = stage;
        this.kahoot = kahoot;
        siguientePregunta = new DetectorDeVista(kahoot);

    }

    @Override
    public void handle(ActionEvent actionEvent) {


        if (kahoot.ultimoJugador()){
            kahoot.calcularPuntosDelTurno();
            kahoot.proximaPreguntaDeTurno();
            siguientePregunta.siguienteVistaPregunta(new PuntosVista(stage, kahoot), stage);
        }else {
            kahoot.siguienteJugador();
            siguienteVista();

        }

    }

    public void siguienteVista() {
        switch (kahoot.preguntaDeTurno().tipoDePregunta()){

            case "VerdaderoYFalso":
                siguientePregunta.siguienteVistaPregunta((VerdaderoYFalso) kahoot.preguntaDeTurno(), stage);
                break;

            case "MultipleChoice" :
                siguientePregunta.siguienteVistaPregunta((MultipleChoice) kahoot.preguntaDeTurno(), stage);
                break;

            case "OrderedChoice" :
                siguientePregunta.siguienteVistaPregunta((OrderedChoice) kahoot.preguntaDeTurno(), stage);
                break;
            case "GroupChoice" :
                siguientePregunta.siguienteVistaPregunta((GroupChoice) kahoot.preguntaDeTurno(), stage);
                break;
        }
    }


}