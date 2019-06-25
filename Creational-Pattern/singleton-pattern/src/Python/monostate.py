# Singleton design pattern says that there should be one and only one object of a class.
# In fact, what a programmer needs is to have instances sharing the same state.
# --> Alex Martelli suggests that developers should be bothered about the state and behaviour rather than the identity.
# --> As the concept is based on all objects sharing the same state, it is also known as the Monostate pattern.

# First way
# class Borg:
#     __share_state = {"1": "2"}

#     def __init__(self):
#         self.x = 1

#         # In Python, __dict__ stores the state of every objects of a class.
#         self.__dict__ = self.__share_state
#         pass

# b = Borg()
# b1 = Borg()
# b.x = 4

# print("Borg object 'b': ", b) # b and b1 are distinct objects
# print("Borg object 'b1': ", b1)
# print("Object State 'b': ", b.__dict__) # b and b1 share same state
# print("Object State 'b1': ", b1.__dict__)


# Second way: use __new__ method
class Borg(object):
    __share_state = {}

    # __new__ method is responsible for the creation of the object instance.
    def __new__(self, *args, **kwargs):
        obj = super(Borg, self).__new__(self, *args, **kwargs)
        obj.__dict__ = self.__share_state

        return obj

