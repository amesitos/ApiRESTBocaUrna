package ec.com.webmarket.restful.service.crud;

import ec.com.webmarket.restful.domain.Mesa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import ec.com.webmarket.restful.dto.v1.MesaDTO;
import ec.com.webmarket.restful.persistence.MesaRepository;


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
        Mesa mesa = convertToEntity(dto);
        return convertToDTO(mesaRepository.save(mesa));
    }

    public MesaDTO update(MesaDTO dto) {
        if (mesaRepository.existsById(dto.getId())) {
            Mesa mesa = convertToEntity(dto);
            return convertToDTO(mesaRepository.save(mesa));
        }
        return null;
    }

    private MesaDTO convertToDTO(Mesa mesa) {
        if (mesa == null) {
            return null;
        }

        MesaDTO dto = new MesaDTO();
        dto.setId(mesa.getIdMesa());
        dto.setNombre(mesa.getNombreMesa());
        dto.setUbicacion(mesa.getUbicacion());

        return dto;
    }

    private Mesa convertToEntity(MesaDTO dto) {
        if (dto == null) {
            return null;
        }

        Mesa mesa = new Mesa();
        mesa.setIdMesa(dto.getId());
        mesa.setNombreMesa(dto.getNombre());
        mesa.setUbicacion(dto.getUbicacion());

        return mesa;
    }
}
