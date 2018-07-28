package deepanshu.example.com.mynote.entities;

import android.net.Uri;

/**
 * Created by Deepanshu on 28-07-2018.
 */

public class User {
    private String email;
    private String name;
    private Uri profileImageUrl;

    public User(String email, String name, Uri profileImageUrl) {
        this.email = email;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(Uri profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
