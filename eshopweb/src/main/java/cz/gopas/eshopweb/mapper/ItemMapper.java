package cz.gopas.eshopweb.mapper;

import cz.gopas.eshopweb.dto.ItemDto;
import cz.gopas.eshopweb.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item toEntity(ItemDto dto);
    List<Item> toEntity(List<ItemDto> dto);

    ItemDto toDto(Item entity);
    List<ItemDto> toDto(List<Item> entities);

}
