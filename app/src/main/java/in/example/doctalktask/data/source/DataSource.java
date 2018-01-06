package in.example.doctalktask.data.source;

import java.util.List;

import in.example.doctalktask.data.models.User;
import io.reactivex.Single;

/**
 * Created by abhishektyagi on 06/01/18.
 */

public interface DataSource {

    Single<List<User>> getUsers(String name);
}
