package domain;

public class User {
    private Integer id;
    private String name ;
    private String num;
    private String depat;
    private String job;
    private String role;
    private String phone;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", depat='" + depat + '\'' +
                ", job='" + job + '\'' +
                ", role='" + role + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDepat() {
        return depat;
    }

    public void setDepat(String depat) {
        this.depat = depat;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
