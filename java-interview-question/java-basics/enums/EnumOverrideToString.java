enum WEEKDAY{
    //enum variables.
    MONDAY, TUESDAY, WEDNESDAY, THRUSDAY, FRIDAY, SATURDAY, SUNDAY

    //override the toString().
    @Override
    public String toString(){
        return switch(this){
            case MONDAY: yield "Day 1";
            case TUESDAY: yield "Day 2";
            case WEDNESDAY: yield "Day 3";
            case THRUSDAY: yield "Day 4";
            case FRIDAY: yield "Day 5";
            case SATURDAY: yield "Day 6";
            case SUNDAY: yield "Day 7";
        }
    }
}
class EnumOverrideToString{
    public static void main(String[] args){
        System.out.println(WEEKDAY.MONDAY);
        System.out.println(WEEKDAY.TUESDAY.toString())
        System.out.println(WEEKDAY.WEDNESDAY.name());
    }
}