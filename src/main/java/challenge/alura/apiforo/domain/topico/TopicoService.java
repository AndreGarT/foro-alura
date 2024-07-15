package challenge.alura.apiforo.domain.topico;

import challenge.alura.apiforo.domain.usuario.UsuarioRepository;
import challenge.alura.apiforo.infra.errores.ValidacionIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public DatosRespuestaTopico registrar(DatosRegistroTopico datosRegistroTopico) {

        if(!usuarioRepository.findById(datosRegistroTopico.idUsuario()).isPresent()){
            throw new ValidacionIntegridad("Este id para usuario no fue encontrado!");
        }

        var usuario = usuarioRepository.findById(datosRegistroTopico.idUsuario()).get();
        var topico = new Topico(usuario, datosRegistroTopico.mensaje(), datosRegistroTopico.curso(), datosRegistroTopico.titulo());

        topicoRepository.save(topico);

        return new DatosRespuestaTopico(topico);
    }

    public DatosRespuestaTopico actualizar(Long id, DatosActualizarTopico datosActualizarTopico){

        if(!topicoRepository.existsById(id)){
            throw new ValidacionIntegridad("Este id de Topico no ha sido encontrado!");
        }

        Topico topico = topicoRepository.getReferenceById(id);
        topico.actualizarDatos(datosActualizarTopico);
        return new DatosRespuestaTopico(topico);
    }

}
