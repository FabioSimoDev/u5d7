package simonellifabio.blogging.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import simonellifabio.blogging.entities.BlogPost;
import simonellifabio.blogging.services.BlogPostsService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostsController {
    @Autowired
    private BlogPostsService blogPostsService;

    @GetMapping
    public List<BlogPost> getAllPosts(){
        return blogPostsService.getBlogPosts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost createBlogPost(@RequestBody BlogPost body){
        System.out.println(body);
        return blogPostsService.saveBlogPost(body);
    }

    @GetMapping("/{id}")
    public BlogPost getById(@PathVariable UUID id){
        if(blogPostsService.findById(id) == null){
            System.out.println("damn");
        }
        return blogPostsService.findById(id);
    }

    @PutMapping("/{id}")
    public BlogPost findByIdAndUpdate(@PathVariable UUID id, @RequestBody BlogPost body){
        return blogPostsService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID id){
        blogPostsService.findByIdAndDelete(id);
    }
}
