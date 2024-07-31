package ec.com.webmarket.restful.service.crud;

import ec.com.webmarket.restful.domain.Curso;

import ec.com.webmarket.restful.domain.EstudianteNormal;
import ec.com.webmarket.restful.domain.Paralelo;
import ec.com.webmarket.restful.dto.v1.CursoDTO;
import ec.com.webmarket.restful.dto.v1.EstudianteNormalDTO;
import ec.com.webmarket.restful.dto.v1.ParaleloDTO;
import ec.com.webmarket.restful.persistence.EstudianteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<EstudianteNormalDTO> findAll() {
        return estudianteRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public EstudianteNormalDTO find(Long id) {
        return convertToDTO(estudianteRepository.findById(id).orElse(null));
    }

    public EstudianteNormalDTO create(EstudianteNormalDTO dto) {
        EstudianteNormal estudiante = convertToEntity(dto);
        return convertToDTO(estudianteRepository.save(estudiante));
    }

    public EstudianteNormalDTO update(EstudianteNormalDTO dto) {
        if (estudianteRepository.existsById(dto.getIdEstudiante())) {
            EstudianteNormal estudiante = convertToEntity(dto);
            return convertToDTO(estudianteRepository.save(estudiante));
        }
        return null;
    }

    private EstudianteNormalDTO convertToDTO(EstudianteNormal estudiante) {
        if (estudiante == null) {
            return null;
        }

        EstudianteNormalDTO dto = new EstudianteNormalDTO();
        dto.setIdEstudiante(estudiante.getIdEstudiante());
        dto.setCedula(estudiante.getCedula());
        dto.setNombre(estudiante.getNombre());
        dto.setApellido(estudiante.getApellido());
        dto.setEdad(estudiante.getEdad()); 
        dto.setGenero(estudiante.getGenero());
        dto.setCorreoInstitucional(estudiante.getCorreoInstitucional());
        dto.setCurso(estudiante.getCurso() != null ? convertCursoToDTO(estudiante.getCurso()) : null);
        dto.setParalelo(estudiante.getParalelo() != null ? convertParaleloToDTO(estudiante.getParalelo()) : null);
        
        
        return dto;
    }

    private CursoDTO convertCursoToDTO(Curso curso) {
        if (curso == null) {
            return null;
        }
        CursoDTO dto = new CursoDTO();
        dto.setIdCurso(curso.getIdCurso());
        dto.setNombre(curso.getNombre());
        return dto;
    }

    private ParaleloDTO convertParaleloToDTO(Paralelo paralelo) {
        if (paralelo == null) {
            return null;
        }
        ParaleloDTO dto = new ParaleloDTO();
        dto.setIdParalelo(paralelo.getIdParalelo());
        dto.setNombre(paralelo.getNombre());
        return dto;
    }

    private EstudianteNormal convertToEntity(EstudianteNormalDTO dto) {
        if (dto == null) {
            return null;
        }

        EstudianteNormal estudiante = new EstudianteNormal();
        estudiante.setIdEstudiante(dto.getIdEstudiante());
        estudiante.setCedula(dto.getCedula());
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setEdad(dto.getEdad());  
        estudiante.setGenero(dto.getGenero());
        estudiante.setCorreoInstitucional(dto.getCorreoInstitucional());
        estudiante.setCurso(dto.getCurso() != null ? convertDTOToCurso(dto.getCurso()) : null);
        estudiante.setParalelo(dto.getParalelo() != null ? convertDTOToParalelo(dto.getParalelo()) : null);
        

        return estudiante;
    }

    private Curso convertDTOToCurso(CursoDTO dto) {
        if (dto == null) {
            return null;
        }
        Curso curso = new Curso();
        curso.setIdCurso(dto.getIdCurso());
        curso.setNombre(dto.getNombre());
        return curso;
    }

    private Paralelo convertDTOToParalelo(ParaleloDTO dto) {
        if (dto == null) {
            return null;
        }
        Paralelo paralelo = new Paralelo();
        paralelo.setIdParalelo(dto.getIdParalelo());
        paralelo.setNombre(dto.getNombre());
        return paralelo;
    }
}

