public abstract class Animal {
    private String name;
    private Integer age;
    private String genre;
    public Animal(String name, Integer age, String genre) {
        this.name = name;
        this.age = age;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGenre() {
        return genre;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public abstract void makeNoise();

    public abstract void hunt();

    public void happyBirthday(){
        age++;
    }


}
