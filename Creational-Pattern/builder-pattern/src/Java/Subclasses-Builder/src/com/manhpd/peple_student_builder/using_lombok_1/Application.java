package com.manhpd.peple_student_builder.using_lombok_1;

public class Application {

    public static void main(String[] args) {
        PupilL1 pupilL1 = PupilL1.builder()
                .name("pupil with Super builder")
                .age(5)
                .school("Pupil SuperBuilder school")
                .something("something with Pupil SuperBuilder")
                .build();
        System.out.println(pupilL1.toString());
    }

}
