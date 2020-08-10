package com.manhpd.peple_student_builder.using_lombok;

public class ApplicationLombok {

    public static void main(String[] args) {
        StudentLombok studentLombok = StudentLombok.builder()
                .school("Alphabet")
                .name("Google")
                .age(20)
                .build();
        System.out.println(studentLombok.toString());
    }

}
