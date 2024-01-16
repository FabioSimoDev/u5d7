package simonellifabio.blogging.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import simonellifabio.blogging.entities.PostAuthor;
import simonellifabio.blogging.services.PostAuthorService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("authors")
public class PostAuthorController {
    @Autowired
    PostAuthorService postAuthorService;

    @GetMapping
    public List<PostAuthor> findAllAuthors(){
        return postAuthorService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostAuthor savePostAuthor(@RequestBody PostAuthor postAuthor){
        System.out.println(postAuthor);
        return postAuthorService.savePostAuthor(postAuthor);
    }

    @GetMapping("/{id}")
    public PostAuthor findById(@PathVariable UUID id){
        return postAuthorService.findById(id);
    }

    @PutMapping("/{id}")
    public PostAuthor findByIdAndUpdate(@PathVariable UUID id, @RequestBody PostAuthor postAuthor){
        return postAuthorService.findByIdAndUpdate(id, postAuthor);
    }

    @DeleteMapping("/{id}")
    public void findByIdAndDelete(@PathVariable UUID id){
        postAuthorService.findByIdAndDelete(id);
    }
}
