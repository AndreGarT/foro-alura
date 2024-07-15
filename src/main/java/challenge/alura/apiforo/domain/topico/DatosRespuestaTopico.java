package challenge.alura.apiforo.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        Long idUsuario,
        String mensaje,
        String titulo,
        Curso curso,
        LocalDateTime fecha
) {
    public DatosRespuestaTopico(Topico topico) {
        this(topico.getId(), topico.getUsuario().getId(), topico.getMensaje(), topico.getTitulo(), topico.getCurso(), topico.getFecha());
    }
}
