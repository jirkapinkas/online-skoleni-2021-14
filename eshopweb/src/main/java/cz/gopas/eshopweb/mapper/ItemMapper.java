package cz.gopas.eshopweb.mapper;

import cz.gopas.eshopweb.dto.ItemWithCategoryDto;
import cz.gopas.eshopweb.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper extends AbstractMapper<Item, ItemWithCategoryDto> {

}
