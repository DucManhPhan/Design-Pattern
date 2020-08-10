package com.manhpd.peple_student_builder.using_lombok_1;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class StudentL1 extends PeopleL1 {

    private String school;

}
