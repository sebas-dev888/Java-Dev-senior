public class App {
    public static void main(String[] args) throws Exception {
        //creacion empleados agg a company y a directivos
        var company = new Enterprise("Sebasdev888");
        var sebas = new Directive("Sebas", 19, 10_000d, "CEO");
        company.addEmployee(0, sebas);

        var luisa = new Employee("luisa", 20, 2_000d);
        company.addEmployee(1, luisa);
        luisa.setManager(sebas);
        sebas.addEmployee(0, luisa);

        var manuel = new Employee("manuel", 20, 1_000d);
        company.addEmployee(2, manuel);
        manuel.setManager(sebas);
        sebas.addEmployee(1, manuel);
        // agg y creacion de clientes
        var santiago = new Cliente("santiago", 21, "3106960305");
        company.addCliente(0, santiago);


        var employees = company.getEmployees();
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null){
            employees[i].mostrarDatos();
            }
        }

        var client = company.getClient();
        for (int i = 0; i < client.length; i++) {
            if(client[i] != null){
            client[i].mostrarDatos();
            }
        }
    }
}
