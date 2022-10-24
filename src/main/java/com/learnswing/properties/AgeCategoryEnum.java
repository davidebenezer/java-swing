package com.learnswing.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
public enum AgeCategoryEnum {
    BELOW18(1,"Under 18"),
    BETWEEN18AND65(2, "18 to 65"),
    ABOVE65(3, "Over 65");

    private final int id;
    private final String ageCategory;


    private AgeCategoryEnum(int id, String ageCategory){
        this.id = id;
        this.ageCategory = ageCategory;
    }

    @Override
    public String toString() {
        return this.getAgeCategory();
    }
}
