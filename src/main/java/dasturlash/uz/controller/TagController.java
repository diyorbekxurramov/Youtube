package dasturlash.uz.controller;

import dasturlash.uz.dto.TagDTO;
import dasturlash.uz.entity.TagEntity;
import dasturlash.uz.service.TagService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tag")
public class TagController {
@Autowired
    private TagService tagService;
@PostMapping("/admin")
public ResponseEntity<TagEntity> create(@Valid @RequestBody TagDTO dto) {
    return ResponseEntity.ok(tagService.create(dto));
}

}
