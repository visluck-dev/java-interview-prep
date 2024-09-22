import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary + "]";
    }

    @Override
    public int hashCode()
    {
        return 1;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)return false;
        if (getClass() != obj.getClass())return false;
        Employee emp =  (Employee)obj;

        if(emp.department.equals(this.department) )return true;

        return false;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", "IT", 5000),
                new Employee(2, "Jane", "HR", 6000),
                new Employee(3, "Mike", "IT", 7000),
                new Employee(4, "Sara", "HR", 5500),
                new Employee(5, "Tom", "Finance", 8000)
        );

        Map<String, Optional<Employee>> mp= employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.maxBy(
                        Comparator.comparingDouble(Employee::getSalary)
                    )
                )
        );

        // Group employees by department and find the highest salary employee in each department
        Map<String, Optional<Employee>> highestPaidByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

        // Display the highest paid employee in each department
        highestPaidByDept.forEach((department, employee) -> {
            System.out.println("Department: " + department + ", Highest Paid Employee: " + employee.get());
        });

        Predicate<Integer>p= x->x%2==0;

        p.test(10);

        Function<Integer, Double> converter = Integer::doubleValue;
       Double x =  converter.apply(10);

        Consumer<Integer> c= System.out::println;



        c.accept(20);

    }
}
