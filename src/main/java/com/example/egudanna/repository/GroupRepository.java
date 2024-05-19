package com.example.egudanna.repository;

import com.example.egudanna.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

//    @Query("select g.category.genre from Group g where g.id= : groupId")
//    String findCategoryGenreById(@Param("groupId") Long groupId);

    @Query("select g.name, c.genre from Group g join g.category c where g.id= : groupId")
    List<Object[]> findCategoryGenres(Long groupId);
}
