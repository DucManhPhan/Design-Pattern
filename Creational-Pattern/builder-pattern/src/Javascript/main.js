const Employee = require('./Employee.js');


let emp = Employee.EmployeeBuilder(12)
                        .withFirstName("Obama")
                        .withLastName("Barack")
                        .withPosition("Former President")
                        .build();