package model;


public class Student {
    private int id;
    private String name;
    private String lastname;
    private String email;
    private int careerId;
    private String careerName;

    public Student(){}

    public Student(int id, String name, String lastname, String email, int careerId, String careerName){
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.careerId = careerId;
        this.careerName = careerName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public int getCareerId() {
        return careerId;
    }

    public String getCareerName() {
        return careerName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCareerId(int careerId) {
        this.careerId = careerId;
    }

    public void setCareerName(String careerName) {
        this.careerName = careerName;
    }
}
