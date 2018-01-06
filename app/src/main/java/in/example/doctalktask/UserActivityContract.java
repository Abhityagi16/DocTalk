package in.example.doctalktask;

import java.util.List;

import in.example.doctalktask.data.models.User;

/**
 * Created by abhishektyagi on 06/01/18.
 */

public interface UserActivityContract {
    interface View extends BaseView<Presenter> {
        void addUsers(List<User> users);
    }

    interface Presenter extends BasePresenter {
        void loadUsers(String name);
    }
}
