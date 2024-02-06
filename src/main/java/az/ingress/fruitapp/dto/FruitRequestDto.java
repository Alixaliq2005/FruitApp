package az.ingress.fruitapp.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FruitRequestDto {
    String name;

    String amount;

    String price;
}
