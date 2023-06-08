package fr.epita.enumerations;

public enum PassengerClassEnum {
    FIRST_CLASS("1st"),
    SECOND_CLASS("2nd"),
    THIRD_CLASS("3rd");
    private String className;
    PassengerClassEnum(String name){
        this.className = name;
    }
}
