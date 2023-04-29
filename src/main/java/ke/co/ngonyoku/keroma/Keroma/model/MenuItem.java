package ke.co.ngonyoku.keroma.Keroma.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "menu_items")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false,
            length = 200
    )
    private String name;

    private String description;

    @Column(nullable = false)
    private double price;

    @ManyToMany(mappedBy = "menuItems")
    private List<Order> orders;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "menu_item_categories",
            joinColumns = @JoinColumn(name = "menu_item_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
    )
    private List<Category> categories;

    public MenuItem() {
        this.categories = new ArrayList<>();
    }

    public MenuItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categories = new ArrayList<>();
    }

    public MenuItem(Long id, String name, String description, double price, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.orders = orders;
        this.categories = new ArrayList<>();
    }
}

