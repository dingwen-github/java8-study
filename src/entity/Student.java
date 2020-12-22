package entity;
import java.io.Serializable;

/**
 * @program:
 * @description: Student entity
 * @author: dingwen
 * @create: 2020/12/21 14:07
 **/
public class Student implements Serializable {
    private static final long serialVersionUID = -4233769639008758823L;
    private String name;
    private String gender;
    private String id;

    public Student() {
    }

   public Student(String name, String gender, String id) {
        this.name = name;
        this.gender = gender;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Student other = (Student) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "student: id=" + this.id + "name: " + this.name + "gender: " + this.gender;
    }
}
