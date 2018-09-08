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
@CrossOrigin(
    origins = {"http://localhost:4200"},
    methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE}, maxAge = 4800)
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

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyBookById(@PathVariable("id") ObjectId id, @Valid
    @RequestBody Books books) {
        books.set_id(id);
        repository.save(books);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Books createBook(@Valid @RequestBody Books book) {
        book.set_id(ObjectId.get());
        repository.save(book);
        return book;
    }

}
