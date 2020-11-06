from .abs_decorator import AbsDecorator

class Red(AbsDecorator):
    @property
    def description(self):
        return self.car.description + ', Ferrari red'

    @property
    def cost(self):
        return self.car.cost + 1200.00