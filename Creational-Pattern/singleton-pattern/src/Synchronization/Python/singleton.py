# Singleton is used in cases such as logging or database operations, printer spoolers, and many others,
#  where there is a need to have only one instance that is available across the application to avoid conflicting
# requests on the same resource.

# Eager initialization
# class Singleton(object):
#     def __new__(self):
#         if not hasattr(self, 'instance'):
#             self.instance = super(Singleton, self).__new__(self)
        
#         return self.instance

# s = Singleton()
# print("", s)

# s1 = Singleton()

# print("Other singleton object: ", s1)


# Lazy initialization
class Singleton(object):
    __instance = None

    def __init__(self):
        if not Singleton.__instance:
            print("__init__() method called")
        else:
            print("Instance already created: ", self.getInstance())

    @classmethod    # or use annotation @staticmethod
    def getInstance(self):
        if not self.__instance:
            self.__instance = Singleton()

        return self.__instance

s = Singleton()
print("Object is created at ", s.getInstance())