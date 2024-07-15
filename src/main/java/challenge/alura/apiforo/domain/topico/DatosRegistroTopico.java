package challenge.alura.apiforo.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotNull
        Long idUsuario,
        @NotBlank
        String mensaje,
        @NotNull
        Curso curso,
        @NotBlank
        String titulo
) {
}
