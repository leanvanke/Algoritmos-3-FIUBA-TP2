package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonRadioHandler implements EventHandler<ActionEvent> {

    private final Respuesta respuesta;
    private final Opcion opcion;

    public BotonRadioHandler(Respuesta respuesta, Opcion opcion) {
        this.respuesta = respuesta;
        this.opcion = opcion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.respuesta.eliminarOpciones();

        this.respuesta.agregarOpcion(opcion);

    }


}
