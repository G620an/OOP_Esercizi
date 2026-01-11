import re

class CodiceProgetto:
    def __init__(self , cp:str):
        if (cp is None) or not(re.match("[a-zA-Z0-9]+" , cp)):
            raise ValueError("Codice non valido")
        self._cp = cp

    def getCodiceProgetto(self):
        return self._cp

    def __eq__(self , other):
        if other is None:
            return False
        if other is self:
            return True
        if isinstance(other, CodiceProgetto):
            return self.getCodiceProgetto() == other.getCodiceProgetto()
        return False

    def __ne__(self , other):
        return not self == other

    def __hash__(self):
        return hash(self.getCodiceProgetto())

    def __str__(self):
        return self.getCodiceProgetto()

    def __repr__(self):
        return self.__str__()