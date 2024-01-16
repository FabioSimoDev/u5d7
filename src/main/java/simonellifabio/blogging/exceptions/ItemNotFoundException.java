package simonellifabio.blogging.exceptions;

import java.util.UUID;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(UUID id){
        super("non è stato trovato nessun elemento corrispondente all'id: " + id.toString());
    }
}
