package dasturlash.uz.repository;

import dasturlash.uz.entity.CategoryEntity;
import dasturlash.uz.entity.TagEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<TagEntity, Integer> {
    Optional<TagEntity> findByIdAndVisibleIsTrue(Integer id);

    Optional<TagEntity> findByTagKey(String key);
    @Transactional
    @Modifying
    @Query("update TagEntity set visible = false where id = ?1")
    int updateVisibleById(Integer id);

    List<TagEntity> findAllByVisibleIsTrue();
}








