
class Employee {

    constructor(builder) {
        this._id = builder.id;
        this._firstName = builder.firstName;
        this._lastName = builder.lastName;
        this._position = builder.position;
    }

    get id() {
        return this._id;
    }

    get firstname() {
        return this._firstName;
    }

    get lastName() {
        return this._lastName;
    }

    get position() {
        return this._position;
    }

    static get EmployeeBuilder() {
        class EmployeeBuilder {
            constructor(id) {
                this._id = id;
            }

            withFirstName(firstName) {
                this._firstName = firstName;
                return this;
            }

            withLastName(lastName) {
                this._lastName = lastName;
                return this;
            }

            withPosition(position) {
                this._position = position;
                return this;
            }

            build() {
                return new Employee(this);
            }
        }

        return EmployeeBuilder;
    }
}