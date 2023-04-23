package test.Library;

public class Book {
    private String name;
    private String author;
    private Integer year;

    public Book(String name, String author, int year) {
        this.name = name;
        this.year = year;
        this.author = author;
    }

    public String getName(){
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYear(){
        return year;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("-").append(author).append("-").append(year);
        return sb.toString();
    }

}
