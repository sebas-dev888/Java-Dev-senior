public class Eagle extends Animal implements CanFly{
    private String type;

    public Eagle(String name, Integer age, String genre, String type) {
        super(name, age, genre);
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
    @Override
    public void fly(){
        System.out.printf("%s esta volando%n", getName());
    }

    public void squeal(){
        System.out.printf("%s esta chillando%n", getName());
    }

    public boolean cantPutEggs(){
        return getGenre().equalsIgnoreCase("hembra");
    }

    @Override
    public void hunt() {
       System.out.printf("%s esta volando, enuentra el objetivo yse lanza por el%n", getName());
    }

    @Override
    public void makeNoise() {
        squeal();
    }

}
