package challenge.alura.apiforo.domain.topico;

import challenge.alura.apiforo.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    private LocalDateTime fecha;

    private Boolean estado;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Topico(Usuario usuario, String mensaje, Curso curso, String titulo) {
        this.titulo = titulo;
        this.curso = curso;
        this.mensaje = mensaje;
        this.usuario = usuario;
        this.estado = true;
        this.fecha = LocalDateTime.now();
    }

    public void desactivarTopico(){
        this.estado = false;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {

        if(datosActualizarTopico.titulo()!=null){
            this.titulo = datosActualizarTopico.titulo();
            if(datosActualizarTopico.mensaje()!=null){
                this.mensaje = datosActualizarTopico.mensaje();
                if(datosActualizarTopico.curso()!=null){
                    this.curso = datosActualizarTopico.curso();
                    this.fecha = LocalDateTime.now();
                }
            }
        }


    }
}
