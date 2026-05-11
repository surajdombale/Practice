package practice;

public class Student {
    private Long id;
    private String name;
    private String city;

    public Student(Long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Student() {
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }    
    public void setCity(String city) {
        this.city = city;
    }
}
