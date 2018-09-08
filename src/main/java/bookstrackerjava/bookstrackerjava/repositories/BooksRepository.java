package bookstrackerjava.bookstrackerjava.repositories;

import bookstrackerjava.bookstrackerjava.model.Books;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ...
 *
 * @author Mauricio Martinez Jimenez
 * @version 1.0
 */
public interface BooksRepository extends MongoRepository<Books, String>
{
    Books findBy_id(ObjectId _id);
}
