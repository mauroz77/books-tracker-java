package bookstrackerjava.bookstrackerjava.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * ...
 *
 * @author Mauricio Martinez Jimenez
 * @version 1.0
 */

@Data
public class Books {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    public ObjectId _id;
    private String title;
    private String author;
    private String genre;
    private String status;
    private String description;

    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }
}
