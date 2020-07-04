import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Integer id;
    static String name;
    static String num;
    static String depar;
    static String job;
    static String role;
    static String phone;

    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSourse());
        while (true) {
            switch (menu()) {
                case 0:
                    System.out.println("欢迎你再次使用！");
                    return;
                case 1:
                    add(template);
                    break;
                case 2:
                    delete(template);
                    break;
                case 3:
                    update(template);
                    break;
                case 4:
                    query(template);
                    break;
                default:
                    System.out.println("选项输入错误");
                    break;
            }

        }


//        add(template);
//        delete(template);
//        update(template);
//        query(template);

    }


    public static int menu() {
        System.out.println("\t\t欢迎来到员工管理系统");
        for (int i = 0; i < 35; i++) {
            System.out.print("*");
        }
        System.out.println("\n1、增加员工信息\t\t2、删除员工信息");
        System.out.println("3、修改员工信息\t\t4、查询员工信息");
        System.out.println("0、退出系统");
        for (int i = 0; i < 35; i++) {
            System.out.print("*");
        }
        System.out.println("\n请选择：");
        int select = sc.nextInt();
        return select;
    }


    /**
     * 添加员工
     *
     * @param template
     */
    public static void add(JdbcTemplate template) {
        System.out.println("请输入员工信息（工号，姓名，账号，部门，职位，角色，联系方式）");
        id = sc.nextInt();
        name = sc.next();
        num = sc.next();
        depar = sc.next();
        job = sc.next();
        role = sc.next();
        phone = sc.next();
        String sql = "insert into user(id,name,num,depar,job,role,phone) values(?,?,?,?,?,?,?)";
        int count = template.update(sql, id, name, num, depar, job, role, phone);
        if (count == 1) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }


    /**
     * 删除员工信息
     *
     * @param template
     */
    public static void delete(JdbcTemplate template) {
        System.out.println("请输入您要删除员工的工号：");
        id = sc.nextInt();
        String sql = "delete from  user where id = ?";
        int count = template.update(sql, id);
        if (count == 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    /**
     * 修改员工信息
     *
     * @param template
     */

    public static void update(JdbcTemplate template) {
        System.out.println("请输入您要修改信息的员工的工号");
        id = sc.nextInt();
        String sql = "select * from user where id = ?";
        List<Map<String, Object>> list = template.queryForList(sql, id);
        if (list.isEmpty()) {
            System.out.println("不存在该员工");
        } else {
            System.out.println("请输入您要修改该员工的信息（姓名,账号,部门,职位,角色,联系方式）");
            name = sc.next();
            num = sc.next();
            depar = sc.next();
            job = sc.next();
            role = sc.next();
            phone = sc.next();
            String sql2 = "update user set name=?,num=?,depar=?,job=?,role=?,phone=? where id = ?";
            int count = template.update(sql2, name, num, depar, job, role, phone, id);
            if (count == 1) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
        }
    }

    /**
     * 查询所有员工信息
     *
     * @param template
     */
    public static void query(JdbcTemplate template) {
        System.out.println("请选择您要查询的类型：\n1、查询单个员工信息\n2、查询所有员工信息");
        int num = sc.nextInt();
        if (num == 2) {
            String sql = "select * from user ";
            List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
            for (User user : list) {
                System.out.println(user);
            }
        } else if (num == 1) {
            System.out.println("请输入您要查询员工的工号：");
            id = sc.nextInt();
            String sql = "select * from user where id = ?";
            List<Map<String, Object>> list = template.queryForList(sql, id);
            if (list.isEmpty()) {
                System.out.println("不存在该员工");
            } else {
                System.out.println(list);
            }
        }
    }
}




















