package com.learnswing.properties;

import lombok.Getter;

@Getter
public enum EmploymentCategoryEnum {
    EMPLOYED(1,"Employed"),
    SELF_EMPLOYED(2, "Self-Employed"),
    UNEMPLOYED(3, "UnEmployed");

    private final int id;
    private final String employmentCategory;


    private EmploymentCategoryEnum(int id, String employmentCategory){
        this.id = id;
        this.employmentCategory = employmentCategory;
    }

    @Override
    public String toString() {
        return this.getEmploymentCategory();
    }
}
