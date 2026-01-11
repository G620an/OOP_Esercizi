from enum import Enum

class Complessita(Enum):
    BASSO = 1
    SCARSO = 2
    MEDIO = 3
    ALTO = 4
    MOLTO_ALTO = 5

    def __str__(self):
        return str(self.value)

    def __repr__(self):
        return self.__str__()