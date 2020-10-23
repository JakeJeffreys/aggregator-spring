package com.blogcrawler.controller;

import com.blogcrawler.model.Blog;
import com.blogcrawler.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class BlogController {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @GetMapping("/blogs")
    public Iterable<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    @PostMapping("/blog")
    void addBlog(@RequestBody Blog blog) {
        blogRepository.save(blog);
    }

    @GetMapping("/blogs/category")
    public Iterable<Blog> getBlogsByCategory(@RequestParam("category") String category) {
        return blogRepository.findAllByCategory(category);
    }
}
