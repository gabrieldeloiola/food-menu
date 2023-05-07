package br.com.gabrielpessoa.foodmenu.domain;

import java.util.UUID;

public record FoodDTO(UUID id, String title, String image, Integer price) {
    public FoodDTO(Food food) {
        this(food.getId(), food.getTitle(), food.getImageUrl(), food.getPrice());
    }
}
