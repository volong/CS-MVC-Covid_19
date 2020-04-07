package Model;

public class News {
    private int id;
    private String date;
    private String title;
    private String img;
    private String content;

    public News() {
    }

    public News(int id, String date, String title, String img, String content) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.img = img;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
