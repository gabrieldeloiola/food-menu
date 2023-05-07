package br.com.gabrielpessoa.foodmenu.controller;

import br.com.gabrielpessoa.foodmenu.domain.Food;
import br.com.gabrielpessoa.foodmenu.domain.FoodDTO;
import br.com.gabrielpessoa.foodmenu.repository.FoodRepository;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    private FoodRepository foodRepository;

    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @GetMapping("/listfood")
    public List<FoodDTO> listFoodOptions() {
        return foodRepository.findAll().stream().map(FoodDTO::new).toList();
    }

    @Transactional
    @PostMapping("/savefood")
    public void saveFood(@RequestBody FoodDTO data) {
        Food foodData = new Food(data);
        foodRepository.save(foodData);
    }
}
