import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        // connects to the database
        Connection connection = DatabaseConnection.getInstance();
        try {
            Statement statement = connection.createStatement();
            // Users is a table in the database with an autoincrementing id, varchar username and a varchar password.
            // example code
            // statement.execute("CREATE TABLE IF NOT EXISTS Users (id INTEGER AUTO_INCREMENT PRIMARY KEY , username VARCHAR, password VARCHAR)");

            // Code for inserting a new user with admin for username and password for password
            // statement.execute("INSERT INTO Users(username, password) VALUES ('admin', 'password')");

            // selects all users and saves it to x
            ResultSet x = statement.executeQuery("SELECT * FROM Users");
            // points to the first value of x using the cursor
            x.next();
            // prints the string of the username
            System.out.println(x.getString("username"));
            // closes the connection (do this everytime you use the database)
            connection.close();
            // error catching
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }
}