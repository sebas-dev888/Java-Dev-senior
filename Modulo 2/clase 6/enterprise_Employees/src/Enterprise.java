public class Enterprise {
    private String name;
    private Employee[] employees;
    private Cliente[] client;


    public Enterprise(String name) {
        this.name = name;
        this.employees = new Employee[50];
        this.client = new Cliente[100];
    }

    public String getName() {
        return name;
    }
    public Cliente[] getClient() {
        return client;
    }
    public Employee[] getEmployees() {
        return employees;
    }
    public void addEmployee (int index, Employee employee){
        employees[index] = employee;
    }

    public void addCliente(int index, Cliente cliente){
        client[index] = cliente;
    }

}
