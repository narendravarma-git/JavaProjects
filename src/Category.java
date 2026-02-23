import java.sql.*;
import java.util.ArrayList;
class Records{
    int id;
    String item_name;
    String category;
    int available;
    float prices;

    Records(int id, String item_name, String category, int available, float prices){
        this.id = id;
        this.item_name = item_name;
        this.category = category;
        this.available = available;
        this.prices = prices;

    }
    void booksDB(){
        System.out.print(this.id+" ");
        System.out.print(this.item_name+" ");
        System.out.print(this.category+" ");
        System.out.print(this.available+" ");
        System.out.println(this.prices);
    }
}
public class Category {
    public static void main(String[] args) throws Exception {

        String sql = "select * from books";

        ArrayList<Records> books = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/website_db";
        String username = "root";
        String password = "mysql123";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            int id = rs.getInt(1);
            String item_name = rs.getString(2);
            String category = rs.getString(3);
            int available = rs.getInt(4);
            float price = rs.getFloat(5);
            Records records = new Records(id, item_name, category, available, price);
            books.add(records);
        }
        con.close();

        for(int i=0;i<books.size();i++){
            books.get(i).booksDB();
        }
        //this is a comment



    }
}