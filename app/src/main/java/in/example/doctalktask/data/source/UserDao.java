package in.example.doctalktask.data.source;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import in.example.doctalktask.data.models.User;
import io.reactivex.Single;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by abhishektyagi on 06/01/18.
 */

public class UserDao implements DataSource {

    @Nullable
    private static UserDao INSTANCE = null;
    private final DataSource mRemoteDataSource;

    private final DataSource mLocalDataSource = null;        //Since we are not storing data
    // locally we
    // won't be using this

    private UserDao(@NonNull DataSource remoteDataSource) {
        mRemoteDataSource = checkNotNull(remoteDataSource);

    }

    public static UserDao getInstance(@NonNull DataSource remoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new UserDao(remoteDataSource);
        }
        return INSTANCE;
    }

    @Override
    public Single<List<User>> getUsers(String name) {
        return mRemoteDataSource.getUsers(name);
    }
}
