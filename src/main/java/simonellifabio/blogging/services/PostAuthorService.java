package simonellifabio.blogging.services;

import org.springframework.stereotype.Service;
import simonellifabio.blogging.entities.BlogPost;
import simonellifabio.blogging.entities.PostAuthor;
import simonellifabio.blogging.exceptions.ItemNotFoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class PostAuthorService {
    List<PostAuthor> postAuthors = new ArrayList<>();


    public List<PostAuthor> findAll(){
        return this.postAuthors;
    }

    public PostAuthor findById(UUID id){
        return this.postAuthors.stream()
                .filter(postAuthor -> postAuthor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public PostAuthor findByIdAndUpdate(UUID id, PostAuthor postAuthor){
        PostAuthor found = findById(id);
        if(found != null){
            found.setId(id);
            found.setAvatar(postAuthor.getAvatar());
            found.setName(postAuthor.getName());
            found.setEmail(postAuthor.getEmail());
            found.setSurname(postAuthor.getSurname());
            found.setDateOfBirth(postAuthor.getDateOfBirth());
        }else{
            throw new ItemNotFoundException(id);
        }
        return found;
    }

    public void findByIdAndDelete(UUID id){
        this.postAuthors.removeIf(current -> current.getId().equals(id));
    }

    public PostAuthor savePostAuthor(PostAuthor postAuthor){
        postAuthor.setId(UUID.randomUUID());
        this.postAuthors.add(postAuthor);
        return postAuthor;
    }
}
