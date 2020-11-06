from cars.economy_4cyl_white_vinyl import Economy4CylWhiteVinyl
from cars.economy_6cyl_white_vinyl import Economy6CylWhiteVinyl

# Using subclasses - One subclass per model/options combo
# So we have thousands of combinations --> subclass explosion
def main():
    car1 = Economy4CylWhiteVinyl()
    car2 = Economy6CylWhiteVinyl()

    print(car1.description, car1.cost)
    print(car2.description, car2.cost)


if __name__ == '__main__':
    main()
