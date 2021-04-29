import util.DbUtil;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        DbUtil.selectProduct("select * from product");
//        DbUtil.selectProduct("select * from pc");
//        DbUtil.selectProduct("select * from laptop");


//        DbUtil.callFunction("{call add(?,?,?)}");

//        DbUtil.addPayType("{call add_pay_type(?,?,?)}", "123");
//        DbUtil.test("INSERT into product(maker,model,type) values('J','1111','PC'),('A','2222','Laptop')");

        DbUtil.test("delete from product where model='2222'");
    }
}
