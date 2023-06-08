package fr.epita.enumerations;

public enum SexEnum {

    MALE("male"),
    FEMALE("female");
    private String sex;
    SexEnum(String sex){
        this.sex= sex;
    }
}
