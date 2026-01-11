from Ristrutturazioni import Ristrutturazione as R

class RistrutturazioneAbstract(R):
    def __init__(self):
        pass

    def __eq__(self , other):
        if other is None:
            return False
        if self is other:
            return True
        if isinstance(other , R):
            return self.getID() == other.getID()
        return False

    def __ne__(self , other):
        return not self == other

    def __hash__(self):
        return self.getID().__hash__()

    def __str__(self):
        return "Identificatore: " + self.getID() + ", Nome: " + self.getNomeProgetto() + ", Capacità Operai: " + self.getCapacitaOperai() +\
            ", Superficie: " + self.getSuperficie() + ", Budget: " + self.getBudget() + ", Complessità: " + self.getComplessita() +\
            ", Computo Metrico: " + self.getComputoMetrico()

    def __repr__(self):
        return self.__str__()

    def __gt__(self , other):
        return self.getID() > other.getID()

    def __ge__(self , other):
        return self.getID() >= other.getID()

    def __lt__(self , other):
        return self.getID() < other.getID()

    def __le__(self , other):
        return self.getID() <= other.getID()

    def verifica(self):
        op = self.getComputoMetrico().getOperaiTotale()
        b = self.getComputoMetrico().getCostoTotale()
        if (self.getCapacitaOperai().getCapacita() < op) or (self.getBudget().getBudget() < b):
            return False
        return True