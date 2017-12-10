package lab8.zad1Books;

import java.sql.*;

public class DB {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public void connect() throws SQLException {
        int count = 0;
        while(true) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/kstypa",
                        "kstypa","PJEzdnj8KM7KEwGT");
                break;
            } catch (SQLException ex) {
                // handle any errors
//                System.out.println("count = " + count);
                if(++count == 3) {
                    System.out.println("SQLException: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("VendorError: " + ex.getErrorCode());
                    throw ex;
                }

            } catch(Exception e){e.printStackTrace();}
        }

    }

    public void selectAll() {
        try {
            connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM books;");
            while (resultSet.next()) {
                printBookRecord();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            finallyClose(resultSet);
            finallyClose(statement);
        }
    }

    public void selectByAuthor(String name) {
        try {
            connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM books WHERE author LIKE '%" + name + "'" +
                    "AND author NOT LIKE '" + name + "';");
            while (resultSet.next()) {
                printBookRecord();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            finallyClose(resultSet);
            finallyClose(statement);
        }
    }

    public void selectByISBN(String isbn) {
        try {
            connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM books WHERE isbn = '" + isbn + "';");
            while (resultSet.next()) {
                printBookRecord();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            finallyClose(resultSet);
            finallyClose(statement);
        }
    }

    public void insertBook(String isbn, String title, String author, int year) {
        try {
            connect();
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO books (isbn, title, author, year)" +
                    "VALUES ('" + isbn + "', '" + title + "', '" + author + "', " + year + ");");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            finallyClose(statement);
        }
    }

    private void printBookRecord() throws SQLException {
        String isbn = resultSet.getString("isbn");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");
        int year = resultSet.getInt("year");
        System.out.println(isbn + " " + title + " " + author + " " + Integer.toString(year));
    }

    private void finallyClose(AutoCloseable closeable) {
        if(closeable != null) {
            try {
                closeable.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            closeable = null;
        }
    }
}
