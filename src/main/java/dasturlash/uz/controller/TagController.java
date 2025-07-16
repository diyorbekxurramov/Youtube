package dasturlash.uz.controller;

import dasturlash.uz.dto.TagDTO;
import dasturlash.uz.service.TagService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @PostMapping("/admin")
    public ResponseEntity<TagDTO> create(@Valid @RequestBody TagDTO dto) {
        return ResponseEntity.ok((TagDTO) tagService.create(dto));
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<TagDTO> update(@PathVariable("id") Integer id,
                                              @Valid @RequestBody TagDTO newDto) {
        return ResponseEntity.ok(tagService.update(id, newDto));
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(tagService.delete(id));
    }


    @GetMapping("/list")
    public ResponseEntity<List<TagDTO>> getAll() {
        List<TagDTO> tagList = tagService.getAll();
        return ResponseEntity.ok(tagList);
    }



}
