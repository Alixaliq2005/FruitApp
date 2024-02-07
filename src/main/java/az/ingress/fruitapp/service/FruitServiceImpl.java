package az.ingress.fruitapp.service;

import az.ingress.fruitapp.dto.FruitRequestDto;
import az.ingress.fruitapp.dto.FruitResponseDto;
import az.ingress.fruitapp.entity.Fruit;
import az.ingress.fruitapp.repository.FruitRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository;
    private final ModelMapper modelMapper;

    public FruitResponseDto create(FruitRequestDto fruitRequestDto) {
        Fruit fruit = Fruit.builder ()
                .amount (fruitRequestDto.getAmount ())
                .name (fruitRequestDto.getName ())
                .price (fruitRequestDto.getPrice ())
                .build ();
        Fruit fruit1 = fruitRepository.save (fruit);


        return FruitResponseDto.builder ()
                .amount (fruit1.getAmount ())
                .id (fruit1.getId ())
                .name (fruit1.getName ())
                .price (fruit1.getPrice ())
                .build ();
    }


    public List<FruitResponseDto> findAll() {
        return fruitRepository
                .findAll ()
                .stream ()
                .map (fruit -> modelMapper.map (fruit, FruitResponseDto.class))
                .collect (Collectors.toList ());
    }

    public FruitResponseDto findById(Long id) {
        Fruit fruit = fruitRepository.findById (id)
                .orElseThrow (() -> new RuntimeException ("Not found fruit" + id));
        return modelMapper.map (fruit, FruitResponseDto.class);
    }


    public FruitResponseDto update(Long id, FruitRequestDto fruitRequestDto) {
        fruitRepository.findById (id).orElseThrow (() -> new RuntimeException (
                String.format ("not found fruit in update " + id)));

        Fruit fruit = modelMapper.map (fruitRequestDto, Fruit.class);
        fruit.setId (id);
        return modelMapper.map (fruitRepository.save (fruit), FruitResponseDto.class);
    }

    public void delete(Long id) {
        fruitRepository.deleteById (id);
    }


}