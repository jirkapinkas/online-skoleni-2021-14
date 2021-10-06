package cz.gopas.eshopweb.dto;

import lombok.Data;

@Data
public class ItemWithCategoryDto {

    private int id;

    private String name;

    private String description;

    private double price;

    private CategoryDto category;

}
