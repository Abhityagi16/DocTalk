package in.example.doctalktask.data.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import in.example.doctalktask.data.models.User;

/**
 * Created by abhishektyagi on 06/01/18.
 */

public class ApiResponse {
    @SerializedName("total_count")
    private int totalCount;

    private List<User> items;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<User> getItems() {
        return items;
    }

    public void setItems(List<User> items) {
        this.items = items;
    }
}
