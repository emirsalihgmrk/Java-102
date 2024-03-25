package OtherSubjects;

public enum Enum {
    //Nesneleri main metodu içerisinde değil enum içinde oluşturuyoruz.
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7);
    private int day;
    Enum(int day){
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public void getDayName(){
        String dayName = null;
        switch (this){
            case SUNDAY -> dayName = "SUNDAY";
            case MONDAY -> dayName = "MONDAY";
            case TUESDAY -> dayName = "TUESDAY";
            case WEDNESDAY -> dayName = "WEDNESDAY";
            case THURSDAY -> dayName = "THURSDAY";
            case FRIDAY -> dayName = "FRIDAY";
            case SATURDAY -> dayName = "SATURDAY";
        }
        System.out.println(dayName);
    }

    public static void main(String[] args) {
        Enum.SUNDAY.getDayName();
    }
}
