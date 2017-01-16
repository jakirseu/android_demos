package me.jakir.jsontogson;

/**
 * Created by Jack on 1/16/2017.
 */

public class Post {

    String title;
    String excerpt;

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", excerpt='" + excerpt + '\'' +
                '}';
    }
}
