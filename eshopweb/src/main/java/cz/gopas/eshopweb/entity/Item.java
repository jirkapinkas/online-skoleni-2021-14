package cz.gopas.eshopweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NamedEntityGraph(name = Item.GRAPH_ITEM_CATEGORY, attributeNodes = {
        @NamedAttributeNode(value = "category")
})
// @Table(name = "item")
public class Item {

    public static final String GRAPH_ITEM_CATEGORY = "Graph.Item.Category";

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
