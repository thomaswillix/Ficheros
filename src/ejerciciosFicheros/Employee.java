package ejerciciosFicheros;
/**
 *
 * @author Thomas Freitas
 */
public class Employee {
    String name;
    int age;
    int children;
    String maritalStatus;

    public Employee(String name, int age, int children, String maritalStatus) {
        this.name = name;
        this.age = age;
        this.children = children;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

}
