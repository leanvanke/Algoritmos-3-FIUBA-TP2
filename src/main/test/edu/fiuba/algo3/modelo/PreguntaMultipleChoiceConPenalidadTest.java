package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.MultipleChoiceConPenalidad;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PreguntaMultipleChoiceConPenalidadTest {

    @Test
    public void testUnaPreguntaMultipleChoiceClasicoPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){


        Opcion opcionCorrecta = new Opcion("4",true);
        Opcion opcionCorrecta2 = new Opcion("2^2",true);
        Opcion opcionIncorrecta = new Opcion("8",false);
        Opcion opcionIncorrecta2 = new Opcion("Pez",false);

        ArrayList<Opcion> opciones = new ArrayList<Opcion>(Arrays.asList(opcionCorrecta,opcionCorrecta2,opcionIncorrecta,opcionIncorrecta2));

        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(" 2+2=..? ", opciones);

        ArrayList<Opcion> opcionesCorrectas = new ArrayList<Opcion>(Arrays.asList(opcionCorrecta2,opcionCorrecta));

        assertTrue(multipleChoiceConPenalidad.opcionesCorrectas().containsAll(opcionesCorrectas));

    }

    @Test
    public void testUnaPreguntaMultipleChoiceClasicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Opcion opcionCorrecta = new Opcion("4",true);
        Opcion opcionCorrecta2 = new Opcion("2^2",true);
        Opcion opcionIncorrecta = new Opcion("8",false);
        Opcion opcionIncorrecta2 = new Opcion("Pez",false);

        ArrayList<Opcion> opciones = new ArrayList<Opcion>(Arrays.asList(opcionCorrecta,opcionCorrecta2,opcionIncorrecta,opcionIncorrecta2));

        MultipleChoiceConPenalidad multipleChoiceConPenalidad = new MultipleChoiceConPenalidad(" 2+2=..? ", opciones);

        Respuesta respuestaJugador1 = new Respuesta();
        Respuesta respuestaJugador2 = new Respuesta();
        respuestaJugador1.agregarOpcion(opcionCorrecta);
        respuestaJugador1.agregarOpcion(opcionCorrecta2);
        respuestaJugador1.agregarOpcion(opcionIncorrecta);
        respuestaJugador1.agregarOpcion(opcionIncorrecta2);

        respuestaJugador2.agregarOpcion(opcionIncorrecta);
        respuestaJugador2.agregarOpcion(opcionCorrecta);
        respuestaJugador2.agregarOpcion(opcionCorrecta2);

        respuestaJugador1.agregarJugador(jugador1);
        respuestaJugador2.agregarJugador(jugador2);

        multipleChoiceConPenalidad.asignarPuntaje(respuestaJugador1);
        multipleChoiceConPenalidad.asignarPuntaje(respuestaJugador2);

        assertEquals(0,jugador1.puntaje());
        assertEquals(1,jugador2.puntaje());

    }


}
