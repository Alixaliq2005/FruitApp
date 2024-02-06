package az.ingress.fruitapp.controller;

import az.ingress.fruitapp.dto.FruitRequestDto;
import az.ingress.fruitapp.dto.FruitResponseDto;
import az.ingress.fruitapp.service.FruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fruit")
public class FruitController {

    private final FruitService fruitService;

    @PostMapping("/create")
    public FruitResponseDto create( @RequestBody FruitRequestDto fruitRequestDto){
        return fruitService.create(fruitRequestDto);
    }

    @GetMapping
    public ResponseEntity<List<FruitResponseDto>> findAll() {
        return new ResponseEntity<>(fruitService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FruitResponseDto> findById(@PathVariable Long id){
        return new ResponseEntity<> (fruitService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FruitResponseDto> update(@PathVariable Long id,
                                                   @RequestBody FruitRequestDto fruitRequestDto){
        return  new ResponseEntity<> (fruitService.update(id,fruitRequestDto),(HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        fruitService.delete(id);
    }
}
