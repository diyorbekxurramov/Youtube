package dasturlash.uz.controller;


import dasturlash.uz.dto.profile.ProfileUpdateDTO;
import dasturlash.uz.dto.profile.ProfileUpdateDetailDTO;
import dasturlash.uz.dto.profile.ProfileUpdatePasswordDTO;
import dasturlash.uz.service.ProfileService;
import dasturlash.uz.util.PageUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("")
    public ResponseEntity<dasturlash.uz.dto.profile.ProfileDTO> create(@Valid @RequestBody dasturlash.uz.dto.profile.ProfileDTO dto) {
        return ResponseEntity.ok(profileService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<dasturlash.uz.dto.profile.ProfileDTO> update(@PathVariable("id") Integer id,
                                                                       @Valid @RequestBody ProfileUpdateDTO dto) { // ADMIN
        return ResponseEntity.ok(profileService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<dasturlash.uz.dto.profile.ProfileDTO> byId(@PathVariable("id") Integer id) { // ADMIN
        return ResponseEntity.ok(profileService.getById(id));
    }

    @PutMapping("/detail")
    public ResponseEntity<dasturlash.uz.dto.profile.ProfileDTO> updateDetail(
            @RequestHeader("ProfileId") Integer currentProfileId,
            @Valid @RequestBody ProfileUpdateDetailDTO dto) { // ANY
        return ResponseEntity.ok(profileService.updateDetail(currentProfileId, dto));
    }

    @GetMapping("/pagination")
    public ResponseEntity<PageImpl<dasturlash.uz.dto.profile.ProfileDTO>> pagination(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok(profileService.pagination(PageUtil.page(page), size));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(profileService.delete(id));
    }

    @PutMapping("/password")
    public ResponseEntity<Boolean> password(@RequestHeader("ProfileId") Integer currentProfileId,
                                            @Valid @RequestBody ProfileUpdatePasswordDTO dto) {
        return ResponseEntity.ok(profileService.updatePassword(currentProfileId, dto));
    }

   /* @PostMapping("/filter") // ADMIN
    public ResponseEntity<Page<ProfileDTO>> filter(@RequestBody ProfileFilterDTO filter,
                                                   @RequestParam(value = "page", defaultValue = "1") int page,
                                                   @RequestParam(value = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok(profileService.filter(filter, page - 1, size));
    }*/


}
