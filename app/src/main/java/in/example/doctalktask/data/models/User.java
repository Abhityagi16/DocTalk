package in.example.doctalktask.data.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by abhishektyagi on 06/01/18.
 */

public class User {

    private int id;
    private String login;

    @SerializedName("avatar_url")
    private String avatar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
