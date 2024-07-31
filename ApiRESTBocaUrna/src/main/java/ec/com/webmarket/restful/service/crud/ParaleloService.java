package ec.com.webmarket.restful.service.crud;

import ec.com.webmarket.restful.domain.Paralelo;
import ec.com.webmarket.restful.dto.v1.ParaleloDTO;
import ec.com.webmarket.restful.persistence.ParaleloRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParaleloService {

    @Autowired
    private ParaleloRepository paraleloRepository;

    public List<ParaleloDTO> findAll() {
        return paraleloRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public ParaleloDTO find(Long id) {
        return convertToDTO(paraleloRepository.findById(id).orElse(null));
    }

    public ParaleloDTO create(ParaleloDTO dto) {
        Paralelo paralelo = convertToEntity(dto);
        return convertToDTO(paraleloRepository.save(paralelo));
    }

    public ParaleloDTO update(ParaleloDTO dto) {
        if (paraleloRepository.existsById(dto.getIdParalelo())) {
            Paralelo paralelo = convertToEntity(dto);
            return convertToDTO(paraleloRepository.save(paralelo));
        }
        return null;
    }

    private ParaleloDTO convertToDTO(Paralelo paralelo) {
        if (paralelo == null) {
            return null;
        }

        ParaleloDTO dto = new ParaleloDTO();
        dto.setIdParalelo(paralelo.getIdParalelo());
        dto.setNombre(paralelo.getNombre());

        return dto;
    }

    private Paralelo convertToEntity(ParaleloDTO dto) {
        if (dto == null) {
            return null;
        }

        Paralelo paralelo = new Paralelo();
        paralelo.setIdParalelo(dto.getIdParalelo());
        paralelo.setNombre(dto.getNombre());

        return paralelo;
    }
}
