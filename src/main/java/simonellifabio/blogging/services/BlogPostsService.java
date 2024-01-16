package simonellifabio.blogging.services;

import org.springframework.stereotype.Service;
import simonellifabio.blogging.entities.BlogPost;
import simonellifabio.blogging.exceptions.ItemNotFoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class BlogPostsService {
    private List<BlogPost> blogPosts = new ArrayList<>();

    public List<BlogPost> getBlogPosts(){
        return this.blogPosts;
    }

    public BlogPost saveBlogPost(BlogPost blogPost){
        blogPost.setId(UUID.randomUUID());
        this.blogPosts.add(blogPost);
        return blogPost;
    }

    public BlogPost findById(UUID id) {
        return this.blogPosts.stream()
                .filter(blogPost -> blogPost.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public BlogPost findByIdAndUpdate(UUID id, BlogPost blogPost){
        BlogPost found = findById(id);
        if(found != null){
            found.setId(id);
            found.setTitle(blogPost.getTitle());
            found.setCategory(blogPost.getCategory());
            found.setCover(blogPost.getCover());
            found.setContent(blogPost.getContent());
            found.setReadTime(blogPost.getReadTime());
        }else{
            throw new ItemNotFoundException(id);
        }
        return found;
    }

    public void findByIdAndDelete(UUID id){
        this.blogPosts.removeIf(current -> current.getId().equals(id));
    }
}
