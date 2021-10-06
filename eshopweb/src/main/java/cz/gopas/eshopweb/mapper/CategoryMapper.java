package cz.gopas.eshopweb.mapper;

import cz.gopas.eshopweb.dto.CategoryWithItemsDto;
import cz.gopas.eshopweb.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends AbstractMapper<Category, CategoryWithItemsDto> {
}
