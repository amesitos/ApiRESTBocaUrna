package ec.com.webmarket.restful.service.crud;

import ec.com.webmarket.restful.domain.Mesa;
import ec.com.webmarket.restful.dto.v1.MesaDTO;
import ec.com.webmarket.restful.persistence.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public List<MesaDTO> findAll() {
        return mesaRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public MesaDTO find(Long id) {
        return convertToDTO(mesaRepository.findById(id).orElse(null));
    }

    public MesaDTO create(MesaDTO dto) {
        Mesa mesaElectoral = convertToEntity(dto);
        return convertToDTO(mesaRepository.save(mesaElectoral));
    }

    public MesaDTO update(MesaDTO dto) {
        if (mesaRepository.existsById(dto.getIdMesa())) {
            Mesa mesaElectoral = convertToEntity(dto);
            return convertToDTO(mesaRepository.save(mesaElectoral));
        }
        return null;
    }

    private MesaDTO convertToDTO(Mesa mesaElectoral) {
        if (mesaElectoral == null) {
            return null;
        }

        MesaDTO dto = new MesaDTO();
        dto.setIdMesa(mesaElectoral.getIdMesa());
        dto.setNumMesa(mesaElectoral.getNumMesa());
        dto.setRecinto(mesaElectoral.getRecinto());

        return dto;
    }

    private Mesa convertToEntity(MesaDTO dto) {
        if (dto == null) {
            return null;
        }

        Mesa mesaElectoral = new Mesa();
        mesaElectoral.setIdMesa(dto.getIdMesa());
        mesaElectoral.setNumMesa(dto.getNumMesa());
        mesaElectoral.setRecinto(dto.getRecinto());

        return mesaElectoral;
    }
}
