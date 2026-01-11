import re
class CILA:
    def __init__(self , cila:str):
        if (cila is None) or not(re.match("[a-zA-Z0-9]+"), cila):
            raise ValueError("Codice non valido")
        self._cila = cila

    def getCILA(self):
        return self._cila

    def __eq__(self , other):
        if other is None:
            return False
        if self is other:
            return True
        if isinstance(other, CILA):
            return self.getCILA() == other.getCILA()
        return False

    def __ne__(self , other):
        return not self == other

    def __hash__(self):
        return hash(self.getCILA())

    def __str__(self):
        return self.getCILA()

    def __repr__(self):
        return self.__str__()