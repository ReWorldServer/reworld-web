package ReWorld.controller;

import ReWorld.dto.TypeDTO;
import ReWorld.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class TypeController {

    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    // GET all
    @GetMapping
    public ResponseEntity<List<TypeDTO>> getAllTypes() {
        return ResponseEntity.ok(typeService.getAllTypes());
    }

    // GET by id
    @GetMapping("/{id}")
    public ResponseEntity<TypeDTO> getTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(typeService.getTypeById(id));
    }

    // POST create
    @PostMapping
    public ResponseEntity<TypeDTO> createType(@RequestBody TypeDTO dto) {
        return ResponseEntity.ok(typeService.createType(dto));
    }

    // PUT update
    @PutMapping("/{id}")
    public ResponseEntity<TypeDTO> updateType(@PathVariable Long id, @RequestBody TypeDTO dto) {
        return ResponseEntity.ok(typeService.updateType(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<TypeDTO> deleteType(@PathVariable Long id) {
        return ResponseEntity.ok(typeService.deleteType(id));
    }
}
