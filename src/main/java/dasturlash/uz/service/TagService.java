package dasturlash.uz.service;

import dasturlash.uz.dto.TagDTO;
import dasturlash.uz.entity.TagEntity;
import dasturlash.uz.exception.AppBadException;
import dasturlash.uz.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public TagEntity create(TagDTO dto) {
        Optional<TagEntity> optional = Optional.ofNullable(tagRepository.findByName(dto.getName()));
        if (optional.isPresent()) {
            throw new AppBadException("Tag already exist");
        }
        TagEntity entity = new TagEntity();
        entity.setName(dto.getName());
        entity.setCreatedDate(LocalDateTime.now());
        tagRepository.save(entity);
        return entity;
    }
}
