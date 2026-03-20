public class Employee extends person {
    private Double salary;
    private Directive manager;

    public Employee(String name, Integer age, Double salary) {
        super(name, age);
        this.salary = salary;
    }
    
    public Double getSalary() {
        return salary;
    }

    public void setManager(Directive manager) {
        this.manager = manager;
    }
    public Directive getManager() {
        return manager;
    }
    
    @Override
    public void mostrarDatos() {
        System.out.printf("Empleado: %s, edad: %d, salario: $ %,f%n",
         getName(), getAge(),getSalary());
        
    }
}
