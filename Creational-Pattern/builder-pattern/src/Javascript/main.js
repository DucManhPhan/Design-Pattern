const { Employee } = require('./Employee.js');


let emp = new Employee.EmployeeBuilder(12)
                        .withFirstName("Obama")
                        .withLastName("Barack")
                        .withPosition("Former President")
                        .build();