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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Books> getAllBooks()
    {
        return repository.findAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void modifyBookById(
        @Valid
        @RequestBody Books books) {
        repository.save(books);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Books createBook(@Valid @RequestBody Books book) {
        book.set_id(ObjectId.get());
        repository.save(book);
        return book;
    }

    @RequestMapping(value = "/deletion", method = RequestMethod.POST)
    public Books deleteBook(@Valid @RequestBody Books book) {
        repository.delete(book);
        return book;
    }

}
