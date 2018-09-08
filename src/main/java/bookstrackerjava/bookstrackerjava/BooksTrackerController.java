package bookstrackerjava.bookstrackerjava;

import bookstrackerjava.bookstrackerjava.model.Books;
import bookstrackerjava.bookstrackerjava.repositories.BooksRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * ...
 *
 * @author Mauricio Martinez Jimenez
 * @version 1.0
 */
@RestController
@RequestMapping("/books")

public class BooksTrackerController
{

    @Autowired
    private BooksRepository repository;

    @RequestMapping("/hi")
    String sayHi()
    {
        return "hi";
    }

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Books> getAllBooks()
    {
        return repository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyBookById(@PathVariable("id") ObjectId id, @Valid
    @RequestBody Books books) {
        books.set_id(id);
        repository.save(books);
    }

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Books createBook(@Valid @RequestBody Books book) {
        book.set_id(ObjectId.get());
        repository.save(book);
        return book;
    }

}
