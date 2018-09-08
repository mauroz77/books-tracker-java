package bookstrackerjava.bookstrackerjava;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
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

    @RequestMapping("/hi")
    String getHi()
    {
        return "hi";
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Book> getAllBooks()
    {
        Book b1 = new Book();
        b1.setAuthor("Author1");
        b1.setTitle("Title1");
        b1.setStatus("Reading");
        b1.setGenre("Fiction");
        b1.setDescription("Oe");
        return Arrays.asList(b1);
    }

    @RequestMapping(method = RequestMethod.POST)
    void insertBook(Book book)
    {

    }

    @RequestMapping(method = RequestMethod.PUT)
    void updateBook(Book book)
    {

    }

}
