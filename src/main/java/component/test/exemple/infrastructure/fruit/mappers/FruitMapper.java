package component.test.exemple.infrastructure.fruit.mappers;

import component.test.exemple.domain.entities.Fruit;
import component.test.exemple.infrastructure.fruit.domain.FruitResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface FruitMapper {
    Fruit toFruit(FruitResponse fruitResponse);

    List<Fruit> toFruitList(List<FruitResponse> fruitResponse);
}
