package in.example.doctalktask;

import java.util.List;

import in.example.doctalktask.data.models.User;
import in.example.doctalktask.data.source.UserDao;
import in.example.doctalktask.data.source.remote.RemoteDataSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by abhishektyagi on 06/01/18.
 */

public class UserListPresenter implements UserActivityContract.Presenter {

    private UserDao mUserDao;

    private UserActivityContract.View mUserView;

    public UserListPresenter(UserActivityContract.View
                                     chatFragmentView) {
        mUserView = chatFragmentView;
        mUserDao = UserDao.getInstance(RemoteDataSource.getInstance());
    }

    @Override
    public void loadUsers(String name) {
        mUserDao.getUsers(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BiConsumer<List<User>, Throwable>() {
                    @Override
                    public void accept(List<User> users, Throwable throwable) throws Exception {
                        mUserView.addUsers(users);
                    }
                });
    }
}
