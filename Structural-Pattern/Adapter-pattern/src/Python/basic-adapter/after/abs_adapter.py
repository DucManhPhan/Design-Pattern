import abc

class AbsAdapter(metaclass=abc.ABCMeta):
    def __init__(self, adaptee):
        self._adaptee = adaptee

    @property
    def adaptee(self):
        return self._adaptee

    @abc.abstractproperty
    def name(self):
        pass

    @abc.abstractproperty
    def address(self):
        pass