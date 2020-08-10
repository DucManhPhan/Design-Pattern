package com.manhpd.peple_student_builder.using_lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PeopleLombok {

    private String name;

    private int age;

    @Override
    public String toString() {
        return "name: " + this.name + ", age: " + this.age;
    }

}
