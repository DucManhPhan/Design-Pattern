

class Vendor(object):
    def __init__(self, name, number, street):
        self._name = name
        self._number = number
        self._street = street

    @property
    def name(self):
        return self._name

    @property
    def number(self):
        return self._number
    
    @property
    def street(self):
        return self._street