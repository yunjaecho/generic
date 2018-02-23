package max;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

/**
 * Created by USER on 2017-08-29.
 */
public class MaxGeneric {
    public static List<Employee> createEmployees() {
        return Arrays.asList(
                new Employee(1, "Peter Gibbons"),
                new Employee(2, "Samir Nagheenanajar"),
                new Employee(3, "Michael Bolton"),
                new Employee(4, "Milton Waddams")
        );
    }


    public static void main(String[] args) {
        List<Employee> employees = createEmployees();
        Employee maxId = employees.stream()
                .max(new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        return o1.getId() - o2.getId();
                    }
                }).orElse(Employee.DEFAULT_EMPLOYEE);

        Employee maxName = employees.stream()
                .max(new Comparator<Object>() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return o1.toString().compareTo(o2.toString());
                    }
                }).orElse(Employee.DEFAULT_EMPLOYEE);

        System.out.println("maxId : " + maxId.getId());
        System.out.println("maxName : " + maxName);

        maxId = employees.stream().max(comparingInt(Employee::getId)).orElse(Employee.DEFAULT_EMPLOYEE);
        maxName = employees.stream().max(comparing(Employee::getName)).orElse(Employee.DEFAULT_EMPLOYEE);

        System.out.println("maxId : " + maxId.getId());
        System.out.println("maxName : " + maxName);
    }



}
