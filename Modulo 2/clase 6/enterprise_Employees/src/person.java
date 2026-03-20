public abstract class person {
    private String name;
    private Integer age;

    public person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public abstract void mostrarDatos();

    
}
