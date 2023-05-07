package br.com.gabrielpessoa.foodmenu.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "food")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String imageUrl;
    private Integer price;

    public Food(FoodDTO data) {
        this.title = data.title();
        this.imageUrl = data.image();
        this.price = data.price();
    }
}
