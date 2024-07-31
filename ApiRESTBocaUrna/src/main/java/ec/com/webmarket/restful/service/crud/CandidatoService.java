package ec.com.webmarket.restful.service.crud;

import ec.com.webmarket.restful.domain.Candidato;
import ec.com.webmarket.restful.dto.v1.CandidatoDTO;
import ec.com.webmarket.restful.persistence.CandidatoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public List<CandidatoDTO> findAll() {
        return candidatoRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public CandidatoDTO find(Long id) {
        return convertToDTO(candidatoRepository.findById(id).orElse(null));
    }

    public CandidatoDTO create(CandidatoDTO dto) {
        Candidato candidato = convertToEntity(dto);
        return convertToDTO(candidatoRepository.save(candidato));
    }

    public CandidatoDTO update(CandidatoDTO dto) {
        if (candidatoRepository.existsById(dto.getIdCandidato())) {
            Candidato candidato = convertToEntity(dto);
            return convertToDTO(candidatoRepository.save(candidato));
        }
        return null;
    }

    private CandidatoDTO convertToDTO(Candidato candidato) {
        if (candidato == null) {
            return null;
        }

        CandidatoDTO dto = new CandidatoDTO();
        dto.setIdCandidato(candidato.getIdCandidato());
        dto.setCedula(candidato.getCedula());
        dto.setNombre(candidato.getNombre());
        dto.setApellido(candidato.getApellido());
        dto.setEdad(candidato.getEdad());
        dto.setGenero(candidato.getGenero());
        dto.setCorreoInstitucional(candidato.getCorreoInstitucional());
        dto.setLista(candidato.getLista());
        dto.setCargo(candidato.getRol());

        return dto;
    }

    private Candidato convertToEntity(CandidatoDTO dto) {
        if (dto == null) {
            return null;
        }

        Candidato candidato = new Candidato();
        candidato.setIdCandidato(dto.getIdCandidato());
        candidato.setCedula(dto.getCedula());
        candidato.setNombre(dto.getNombre());
        candidato.setApellido(dto.getApellido());
        candidato.setEdad(dto.getEdad());
        candidato.setGenero(dto.getGenero());
        dto.setCorreoInstitucional(candidato.getCorreoInstitucional());
        candidato.setLista(dto.getLista());
        candidato.setRol(dto.getCargo());

        return candidato;
    }
}
