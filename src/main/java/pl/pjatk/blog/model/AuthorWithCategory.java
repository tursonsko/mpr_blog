package pl.pjatk.blog.model;

public class AuthorWithCategory {
    private String authorName;
    private String categoryName;
    private int count;

    public AuthorWithCategory(String authorName, String categoryName, int count) {
        this.authorName = authorName;
        this.categoryName = categoryName;
        this.count = count;
    }

    public AuthorWithCategory() {

    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}