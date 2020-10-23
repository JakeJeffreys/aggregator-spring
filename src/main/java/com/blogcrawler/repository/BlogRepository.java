package com.blogcrawler.repository;

import com.blogcrawler.model.Blog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BlogRepository extends CrudRepository<Blog, Long> {

    @Query(value = "SELECT * FROM blog b where b.category = :category", nativeQuery = true)
    public Iterable<Blog> findAllByCategory(@Param("category") String category);

}