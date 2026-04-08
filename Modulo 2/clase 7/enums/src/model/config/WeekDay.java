package model.config;
public enum WeekDay {
    MONDAY(1 , "lunes"),
    TUESDAY(2, "martes"), 
    WEDNESDAY(3, "miercoles"), 
    THURSDAY(4, "jueves"), 
    FRIDAY(5, "viernes"), 
    SATURDAY(6, "sabado"), 
    SUNDAY(7, "domingo");

    private Integer num;
    private String name;

    WeekDay(Integer num, String name){
        this.name = name;
        this.num = num;

    }

    public String getName() {
        return name;
    }
    public Integer getNum() {
        return num;
    }

    @Override
    public String toString() {

        return getName();
    }
}
