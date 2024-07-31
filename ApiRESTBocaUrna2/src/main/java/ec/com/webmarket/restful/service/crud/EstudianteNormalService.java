package ec.com.webmarket.restful.service.crud;

import ec.com.webmarket.restful.domain.EstudianteNormal;
import ec.com.webmarket.restful.domain.Curso;
import ec.com.webmarket.restful.dto.v1.CursoDTO;
import ec.com.webmarket.restful.dto.v1.EstudianteNormalDTO;
import ec.com.webmarket.restful.persistence.EstudianteNormalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteNormalService {

    @Autowired
    private EstudianteNormalRepository estudianteNormalRepository;

    public List<EstudianteNormalDTO> findAll() {
        return estudianteNormalRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public EstudianteNormalDTO find(Long id) {
        return convertToDTO(estudianteNormalRepository.findById(id).orElse(null));
    }

    public EstudianteNormalDTO create(EstudianteNormalDTO dto) {
        EstudianteNormal estudianteNormal = convertToEntity(dto);
        return convertToDTO(estudianteNormalRepository.save(estudianteNormal));
    }

    public EstudianteNormalDTO update(EstudianteNormalDTO dto) {
        if (estudianteNormalRepository.existsById(dto.getId())) {
            EstudianteNormal estudianteNormal = convertToEntity(dto);
            return convertToDTO(estudianteNormalRepository.save(estudianteNormal));
        }
        return null;
    }

    private EstudianteNormalDTO convertToDTO(EstudianteNormal estudianteNormal) {
        if (estudianteNormal == null) {
            return null;
        }

        EstudianteNormalDTO dto = new EstudianteNormalDTO();
        dto.setId(estudianteNormal.getIdEstudianteNormal());
        dto.setCedula(estudianteNormal.getCedula());
        dto.setNombre(estudianteNormal.getNombre());
        dto.setApellido(estudianteNormal.getApellido());
        dto.setGenero(estudianteNormal.getGenero());
        dto.setEdad(estudianteNormal.getEdad());
        dto.setTelefono(estudianteNormal.getTelefono());
        dto.setCorreoInstitucional(estudianteNormal.getCorreoInstitucional());
        dto.setCurso(estudianteNormal.getCurso() != null ? convertCursoToDTO(estudianteNormal.getCurso()) : null);

        return dto;
    }

    private CursoDTO convertCursoToDTO(Curso curso) {
        if (curso == null) {
            return null;
        }
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getIdCurso());
        dto.setNombre(curso.getNombreCurso());
        return dto;
    }

    private EstudianteNormal convertToEntity(EstudianteNormalDTO dto) {
        if (dto == null) {
            return null;
        }

        EstudianteNormal estudianteNormal = new EstudianteNormal();
        estudianteNormal.setIdEstudianteNormal(dto.getId());
        estudianteNormal.setCedula(dto.getCedula());
        estudianteNormal.setNombre(dto.getNombre());
        estudianteNormal.setApellido(dto.getApellido());
        estudianteNormal.setGenero(dto.getGenero());
        estudianteNormal.setEdad(dto.getEdad());
        estudianteNormal.setTelefono(dto.getTelefono());
        estudianteNormal.setCorreoInstitucional(dto.getCorreoInstitucional());

        if (dto.getCurso() != null) {
            Curso curso = new Curso();
            curso.setIdCurso(dto.getCurso().getId());
            curso.setNombreCurso(dto.getCurso().getNombre());
            estudianteNormal.setCurso(curso);
        }

        return estudianteNormal;
    }
}
