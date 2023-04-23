package test.Library;

import java.io.*;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public Library(){};

    public Library(ArrayList<Book> books){
        this.books = books;
    }

    public void addBook(Book b){
        books.add(b);
    }

    public void loadFromTextFile(String path) throws IOException {
        try {
            this.books = new ArrayList<>();
            BufferedReader in = new BufferedReader(new FileReader(path));
            String line = in.readLine();
            in.close();
            this.books = new ArrayList<>();
            String[] booksRowData = line.split(";");
            for (String data : booksRowData) {
                String[] book = data.split("-");
                books.add(new Book(book[0], book[1], Integer.parseInt(book[2])));
            }
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }


    }

    public void saveToTextFile(String path) throws IOException {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(path));
            out.println(this.toString());
            out.flush();
            out.close();
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public ArrayList<Book> findAllBooksAfterYear(Integer year){
        ArrayList<Book> result = new ArrayList<>();
        for(Book b : books){
            if(b.getYear() > year) result.add(b);
        }
        return result;
    }

    public Book findBook(String name) throws BookException{
        Book result = null;
        for(Book b : books){
            if(b.getName().equals(name)) result = b;
        }
        if(result == null) throw new BookException("Book with this name not found");
        return result;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Book b : books){
            sb.append(b.toString()).append(";");
        }
        return sb.toString();
    }

}
