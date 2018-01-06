package in.example.doctalktask;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import in.example.doctalktask.data.models.User;

/**
 * Created by abhishektyagi on 06/01/18.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private Context mContext;

    private List<User> mUsers;

    public UserListAdapter(Context context) {
        this.mContext = context;
        mUsers = new ArrayList<>();
    }

    public void loadNewUsers(List<User> users) {
        mUsers = users;
        notifyDataSetChanged();
    }




    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, null);

        return new UserViewHolder(view);
    }


    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = mUsers.get(position);
        Picasso.with(mContext).load(user.getAvatar()).into(holder.userImage);
        holder.userName.setText(user.getLogin());
    }


    @Override
    public int getItemCount() {

        return mUsers == null ? 0 : mUsers.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView userImage;
        TextView userName;

        UserViewHolder(View itemView) {

            super(itemView);
            userImage = itemView.findViewById(R.id.userImage);
            userName = itemView.findViewById(R.id.userName);
        }
    }
}
