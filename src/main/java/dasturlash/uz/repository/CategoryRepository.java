package dasturlash.uz.repository;

import dasturlash.uz.entity.CategoryEntity;
import dasturlash.uz.enums.AppLanguageEnum;
import jakarta.transaction.Transactional;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    Optional<CategoryEntity> findByIdAndVisibleIsTrue(Integer id);

    Optional<CategoryEntity> findByCategoryKey(String key);
   @Transactional
    @Modifying
    @Query("update CategoryEntity set visible = false where id = ?1")
    int updateVisibleById(Integer id);

    @Query("SELECT c.id AS id, " +
            "CASE :lang " +
            "   WHEN 'uz' THEN c.nameUz " +
            "   WHEN 'ru' THEN c.nameRu " +
            "   WHEN 'en' THEN c.nameEn " +
            "END AS name, " +
            "c.categoryKey AS categoryKey " +
            "FROM CategoryEntity c ")
            List<CategoryMapper> getByLang(@Param("lang") AppLanguageEnum Lang);

    List<CategoryEntity> findAllByVisibleIsTrue();
}

//List<CategoryEntity> getAllByOrderSorted();






