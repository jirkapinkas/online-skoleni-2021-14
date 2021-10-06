package cz.gopas.eshopweb.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryWithItemsDto {

    private int id;

    private String name;

    private List<ItemDto> items;

}
