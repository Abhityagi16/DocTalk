package in.example.doctalktask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import in.example.doctalktask.data.models.User;

public class UserListActivity extends AppCompatActivity implements UserActivityContract.View {

    private RecyclerView mRecyclerView;
    private UserListAdapter mAdapter;
    private UserListPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new UserListPresenter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager
                .VERTICAL, false);

        mRecyclerView = findViewById(R.id.user_list);
        mAdapter = new UserListAdapter(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

        final EditText search = findViewById(R.id.editText);
        Button action = findViewById(R.id.search);
        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = search.getText().toString();
                if (!name.isEmpty()) {
                    mPresenter.loadUsers(name);
                }
            }
        });

    }

    @Override
    public void addUsers(List<User> users) {
        mAdapter.loadNewUsers(users);
    }
}
