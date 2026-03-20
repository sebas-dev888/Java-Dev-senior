public class Cliente extends person {
    private String contacPhone;

    public Cliente(String name, Integer age, String contacPhone) {
        super(name, age);
        this.contacPhone = contacPhone;
    }
    
    public void setContacPhone(String contacPhone) {
        this.contacPhone = contacPhone;
    }
    public String getContacPhone() {
        return contacPhone;
    }

    @Override
    public void mostrarDatos() {
        System.out.printf("Cliente: %s, edad: %d, telefono contacto: %s%n", 
       getName(), getAge(), getContacPhone());
    }
}
