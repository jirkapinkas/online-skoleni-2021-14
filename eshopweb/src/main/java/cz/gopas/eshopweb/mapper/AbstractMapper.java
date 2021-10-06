package cz.gopas.eshopweb.mapper;

import java.util.List;

public interface AbstractMapper <ENTITY, DTO> {

    ENTITY toEntity(DTO dto);
    List<ENTITY> toEntity(List<DTO> dto);

    DTO toDto(ENTITY entity);
    List<DTO> toDto(List<ENTITY> entities);

}
