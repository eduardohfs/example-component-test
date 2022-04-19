package component.test.exemple.infrastructure.fruit.mappers;

import component.test.exemple.domain.entities.Nutritions;
import component.test.exemple.infrastructure.fruit.domain.NutritionsResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface NutritionMapper {
    Nutritions toNutrition(NutritionsResponse nutritions);
}
