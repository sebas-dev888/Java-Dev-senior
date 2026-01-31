public class Fish extends Animal implements CanSwim {
    private String color;
    private Boolean fromSea;

    public Fish(String name, Integer age, String genre, String color, Boolean fromSea) {
        super(name, age, genre);
        this.color = color;
        this.fromSea = fromSea;
    }

    public String getColor() {
        return color;
    }

    public Boolean isFromSea() {
        return fromSea;
    }

    @Override
     public void swim(){
        System.out.printf("%s esta nadando%n", getName());
    }
    
     public boolean cantPutEggs(){
        return getGenre().equalsIgnoreCase("hembra");
    }

    @Override
    public void hunt() {
        System.out.printf("%s esta nadando, se cruza con el objetivo abre la boca y pum%n", getName());
    }

    @Override
    public void makeNoise() {
        System.out.printf("%s va silencioso%n", getName());
    }

}
