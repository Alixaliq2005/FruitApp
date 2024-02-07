package az.ingress.fruitapp.service;

import az.ingress.fruitapp.dto.FruitRequestDto;
import az.ingress.fruitapp.dto.FruitResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FruitService {
    FruitResponseDto create(FruitRequestDto fruitRequestDto);

    List<FruitResponseDto> findAll();

    FruitResponseDto findById(Long id);

    FruitResponseDto update(Long id, FruitRequestDto fruitRequestDto);

    void delete(Long id);
}
