package user;

public class Book {
    private String name;
    private String author;
    private Integer count;

    public Book(String name, String author, Integer count) {
        this.name = name;
        this.author = author;
        this.count = count;
    }

    @Override
    public String toString() {
        return
                "Name = " + name + "\n" +
                "Author = " + author + "\n" +
                "Count = " + count +"\n";
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
