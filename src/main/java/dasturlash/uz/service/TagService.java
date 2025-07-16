package dasturlash.uz.service;

import dasturlash.uz.dto.TagDTO;
import dasturlash.uz.entity.TagEntity;
import dasturlash.uz.exception.AppBadException;
import dasturlash.uz.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public TagDTO create(TagDTO dto) {
        TagRepository repository;
        Optional<TagEntity> optional = tagRepository.findByTagKey(dto.getTagKey());
        if (optional.isPresent()) {
            throw new AppBadException("Tag key already exist");
        }
        TagEntity entity = new TagEntity();
        entity.setTagKey(dto.getTagKey());
        entity.setCreatedDate(LocalDateTime.now());
        return dto;


    }

    public TagDTO update(Integer id, TagDTO newDto) {// Jahon
        Optional<TagEntity> optional = tagRepository.findByIdAndVisibleIsTrue(id);
        if (optional.isEmpty()) {
            throw new AppBadException("Tag not found");
        }
        Optional<TagEntity> keyOptional = tagRepository.findByTagKey(newDto.getTagKey()); // Jahon
        if (keyOptional.isPresent() && !id.equals(keyOptional.get().getId())) {
            throw new AppBadException("TagKey present");
        }
        // 1-Jahon,2-Iksodiyot,3-Sport
        TagEntity entity = optional.get();
        entity.setTagKey(newDto.getTagKey());
        entity.setCreatedDate(LocalDateTime.now());
        tagRepository.save(entity);

        newDto.setId(String.valueOf(entity.getId()));
        return newDto;
    }

    public Boolean delete(Integer id) {
        return tagRepository.updateVisibleById(id) == 1;
    }



    public List<TagDTO> getAll() {
        List<TagEntity> entityList = tagRepository.findAllByVisibleIsTrue();

        return entityList.stream().map(entity -> {
            TagDTO dto = new TagDTO();
            dto.setId(String.valueOf(entity.getId()));
            dto.setTagKey(entity.getTagKey());
            return dto;
        }).collect(Collectors.toList());
    }

}

