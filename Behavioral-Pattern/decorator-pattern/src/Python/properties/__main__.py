from cars.economy import Economy


# Using properties - only one concrete class per model
# Drawbacks: more properties to implement per concrete class, the engine, the paint, and the upholstery properties
# and a more complicated constructor to accommodate the new properties

# What if the options's prices change?
# We need to open up the abstract based class and change the cost() method.

# What if we add interior color property?
# Open the abstract based class and the concrete classes accommodate the changes.

# Some principles that violates:
# Single Responsibility Principle
# Open-Closed Principle
# Interface Segregation Principle
# Dependency Inversion Principle
# Don't Repeat Yourself
def main():
    car1 = Economy('4 cyl', 'black', 'vinyl')
    car2 = Economy('6 cyl', 'red', 'leather')

    print('{}: ${}'.format(car1.description, car1.cost))
    print('{}: ${}'.format(car2.description, car2.cost))


if __name__ == '__main__':
    main()
