package max;

/**
 * Created by USER on 2017-08-29.
 */
public class Employee {
    public static final Employee DEFAULT_EMPLOYEE = new Employee(0, "No Name");

    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
