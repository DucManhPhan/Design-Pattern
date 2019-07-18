from abc import ABC, abstractmethod

class BaseModel(ABC):

    def __init(self):
        pass

    @abstractmethod
    def insert(self, dto):
        raise NotImplementedError