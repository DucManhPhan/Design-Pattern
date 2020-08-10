package com.manhpd.peple_student_builder.using_lombok;

import lombok.Builder;
import lombok.Getter;

@Getter
public class StudentLombok extends PeopleLombok {

    private String school;

    @Builder
    public StudentLombok(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }

    @Override
    public String toString() {
        return super.toString() + ", school: " + this.school;
    }

}
