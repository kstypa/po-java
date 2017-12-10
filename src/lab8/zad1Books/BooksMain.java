package lab8.zad1Books;

import lab1.javaIn.*;

public class BooksMain {
    public static void main(String[] args) {
        DB db = new DB();
//        db.selectByAuthor("Murakami");
//        System.out.println("");
//        db.selectByISBN("1234567891239");
//        db.insertBook("1234567890111", "SampleTitle1", "SampleAuthor1", 2017);
//        db.selectByISBN("1234567890111");

        System.out.println("1 - SELECT ALL");
        System.out.println("2 - SELECT BY ISBN");
        System.out.println("3 - SELECT BY AUTHOR");
        System.out.println("4 - INSERT");
        int a = JIn.getInt();
        String isbn, title, author;
        int year;
        switch (a) {
            case 1: db.selectAll();
                    break;
            case 2: isbn = JIn.getString();
                    db.selectByISBN(isbn);
                    break;
            case 3: author = JIn.getString();
                    db.selectByAuthor(author);
                    break;
            case 4: isbn = JIn.getString();
                    title = JIn.getString();
                    author = JIn.getString();
                    year = JIn.getInt();
                    db.insertBook(isbn, title, author, year);
                    break;
            default: System.exit(1);
        }
    }
}
