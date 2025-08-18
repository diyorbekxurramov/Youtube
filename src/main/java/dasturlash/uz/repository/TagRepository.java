package dasturlash.uz.repository;

import dasturlash.uz.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository  extends JpaRepository<TagEntity,Long> {
    TagEntity findByName(String name);

    //Optional<TagEntity> findByName(String name);
}
