public class Duck extends Animal implements CanFly, CanRun, CanSwim{
    private String color;

    public Duck(String name, Integer age, String genre, String color) {
        super(name, age, genre);
        this.color = color;
    }

    @Override
     public void fly(){
        System.out.printf("%s esta volando%n", getName());
    }

    @Override
     public void run(){
        System.out.printf("%s esta corriendo%n", getName());
    }

    public boolean cantPutEggs(){
        return getGenre().equalsIgnoreCase("hembra");
    }

    @Override
    public void swim(){
        System.out.printf("%s esta nadando%n", getName());
    }

    public String getColor(){
        return color;
    }

    @Override
    public void makeNoise() {
        System.out.printf("%s hace CUAK CUAK%n", getName());
    }

    @Override
    public void hunt() {
       System.out.printf("%s va nadando se posa sobre el pez y mete la cabeza para tomarlo%n", getName());
    }
    
}
