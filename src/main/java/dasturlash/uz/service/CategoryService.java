package dasturlash.uz.service;

import dasturlash.uz.dto.CategoryDTO;
import dasturlash.uz.entity.CategoryEntity;
import dasturlash.uz.exception.AppBadException;
import dasturlash.uz.repository.CategoryRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category create(CategoryDTO dto) {
        CategoryRepository repository;
        Optional<CategoryEntity> optional = categoryRepository.findByCategoryKey(dto.getCategoryKey());
        if (optional.isPresent()) {
            throw new AppBadException("Category key already exist");
        }
        CategoryEntity entity = new CategoryEntity();
        entity.setNameUz(dto.getNameUz());
        entity.setNameRu(dto.getNameRu());
        entity.setNameEn(dto.getNameEn());
        entity.setCategoryKey(dto.getCategoryKey());
        entity.setCreatedDate(LocalDateTime.now());
        return (Category) dto;


    }

    public CategoryDTO update(Integer id, CategoryDTO newDto) {// Jahon
        Optional<CategoryEntity> optional = categoryRepository.findByIdAndVisibleIsTrue(id);
        if (optional.isEmpty()) {
            throw new AppBadException("Category not found");
        }
        Optional<CategoryEntity> keyOptional = categoryRepository.findByCategoryKey(newDto.getCategoryKey()); // Jahon
        if (keyOptional.isPresent() && !id.equals(keyOptional.get().getId())) {
            throw new AppBadException("CategoryKey present");
        }
        // 1-Jahon,2-Iksodiyot,3-Sport
        CategoryEntity entity = optional.get();
        entity.setNameUz(newDto.getNameUz());
        entity.setNameRu(newDto.getNameRu());
        entity.setNameEn(newDto.getNameEn());
        entity.setCategoryKey(newDto.getCategoryKey());
        entity.setCreatedDate(LocalDateTime.now());
        categoryRepository.save(entity);

        newDto.setId(String.valueOf(entity.getId()));
        return newDto;
    }

    public Boolean delete(Integer id) {
        return categoryRepository.updateVisibleById(id) == 1;
    }


    public List<CategoryDTO> getAll() {
        List<CategoryEntity> entityList = categoryRepository.findAllByVisibleIsTrue();

        return entityList.stream().map(entity -> {
            CategoryDTO dto = new CategoryDTO();
            dto.setId(String.valueOf(entity.getId()));
            dto.setCategoryKey(entity.getCategoryKey());
            dto.setNameUz(entity.getNameUz());
            dto.setNameRu(entity.getNameRu());
            dto.setNameEn(entity.getNameEn());
            return dto;
        }).collect(Collectors.toList());
    }

}

