
class CapacitaOperai:
    def __init__(self , capacita:int):
        if capacita < 0:
            raise ValueError("ERRORE! Capacità negativa")
        self._capacita = capacita

    def getCapacita(self):
        return self._capacita

    def __eq__(self , other):
        if other is None:
            return False
        if other is self:
            return True
        if isinstance(other , CapacitaOperai):
            return self.getCapacita() == other.getCapacita()
        return False

    def __ne__(self , other):
        return not self == other

    def __hash__(self):
        return hash(self.getCapacita())

    def __str__(self):
        return str(self.getCapacita())

    def __repr__(self):
        return self.__str__()