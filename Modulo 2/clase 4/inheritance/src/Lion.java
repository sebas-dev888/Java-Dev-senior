public class Lion extends Animal implements CanRun{

    private String color;

    public Lion(String name, Integer age, String genre, String color) {
        super(name, age, genre);
        this.color = color;
    }
    
    public String getColor() {
        return color;
    }

    public void roar(){
        System.out.printf("%s esta rugiendo%n", getName());
    }
    
    @Override
    public void run(){
        System.out.printf("%s esta corriendo%n", getName());
    }

    @Override
    public void hunt() {
        System.out.printf("%s se esconde, se mueve sigilosamente y ataca%n", getName());
    }

    @Override
    public void makeNoise() {
        roar();
    }
}
