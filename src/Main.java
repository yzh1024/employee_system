import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Integer id;
    static String name;
    static String num;
    static String depat;
    static String job;
    static String role;
    static String phone;

    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSourse());
//        add(template);
//        delete(template);
        update(template);

    }

    /**
     * 添加员工
     * @param template
     */
    public static void add(JdbcTemplate template) {
        System.out.println("请输入员工信息（工号，姓名，账本，部门，职位，角色，联系方式）");
        id = sc.nextInt();
        name = sc.next();
        num = sc.next();
        depat = sc.next();
        job = sc.next();
        role = sc.next();
        phone = sc.next();
        String sql = "insert into user(工号,姓名,账号,部门,职位,角色,联系方式) values(?,?,?,?,?,?,?)";
        template.update(sql, id, name, num, depat, job, role, phone);
    }


    /**
     * 删除员工信息
     * @param template
     */
    public static void delete(JdbcTemplate template) {
        System.out.println("请输入您要删除员工的工号：");
        id = sc.nextInt();
        String sql = "delete from  user where 工号 = ?";
        template.update(sql,id);
    }

    public static void update(JdbcTemplate template) {
        System.out.println("请输入您要修改信息的员工的工号");
        id = sc.nextInt();
        String sql = "select * from user where 工号 = ?";
        Map<String, Object> map = template.queryForMap(sql,id);
        System.out.println(map);
    }
}




















