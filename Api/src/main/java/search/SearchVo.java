package search;

public class SearchVo {

    private String title;
    private String description;

    public SearchVo() {
        // 기본 생성자
    }

    public SearchVo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SearchVo{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
