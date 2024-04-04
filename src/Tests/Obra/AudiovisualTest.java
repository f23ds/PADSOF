package Tests.Obra;

import Exposicion.TipoDeObra;
import Obra.*;
import java.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AudiovisualTest {

  private Audiovisual av;

  @BeforeEach
  void setUP() {
    av =
      new Audiovisual(
        "Sun in your head",
        "Wolf Vostell",
        1963,
        false,
        "SEG988976",
        1000,
        "El video muestra imagenes deformadas y manipuladas de John F. Kennedy, un desfile militar, presentadoras de noticias y politicos que se saludan, entre otras.",
        LocalTime.of(0, 5, 30),
        "n/a",
        0,
        0,
        0
      );

    assert (av != null);
  }

  @Test
  void testCargarPinturaDeFichero() {
    String obra =
      "AUDIOVISUAL;EXTERNA;Sun in your head;Wolf Vostell;1963;El video muestra imagenes deformadas y manipuladas de John F. Kennedy, un desfile militar, presentadoras de noticias y politicos que se saludan, entre otras.;1000;SEG188300;;;;00h05m30s;n/a;;;;;";

    Audiovisual av_aux = Audiovisual.cargarAudiovisualDeFichero(
      obra.split(";", -1)
    );

    assert (av_aux.getDuracion().getHour() == LocalTime.of(0, 5, 30).getHour());
    assert (
      av_aux.getDuracion().getMinute() == LocalTime.of(0, 5, 30).getMinute()
    );
    assert (
      av_aux.getDuracion().getSecond() == LocalTime.of(0, 5, 30).getSecond()
    );

    assert (av_aux.getTipoObra() == TipoDeObra.AUDIOVISUAL);

    assert (!av_aux.necesitaClimatizacion());
  }

  @Test
  void testGetDuracion() {
    assert (av.getDuracion().getHour() == LocalTime.of(0, 5, 30).getHour());
    assert (av.getDuracion().getMinute() == LocalTime.of(0, 5, 30).getMinute());
    assert (av.getDuracion().getSecond() == LocalTime.of(0, 5, 30).getSecond());
  }

  @Test
  void testGetTipoObra() {
    assert (av.getTipoObra() == TipoDeObra.AUDIOVISUAL);
  }

  @Test
  void testNecesitaClimatizacion() {
    assert (!av.necesitaClimatizacion());
  }

  @Test
  void testSetDuracion() {
    av.setDuracion(LocalTime.of(0, 6, 30));
    assert (av.getDuracion().getMinute() == 6);
  }
}
