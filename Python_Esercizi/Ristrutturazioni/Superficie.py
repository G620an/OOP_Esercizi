
class Superficie:
    def __init__(self , superficie:float):
        if (superficie < 4.0) or (superficie > 1000.0):
            raise ValueError("Superficie non comprsa tra 4 e 1000")
        self._superficie = superficie

    def getSuperficie(self):
        return self._superficie

    def __eq__(self, other):
        if other is None:
            return False
        if other is self:
            return True
        if isinstance(other , Superficie):
            return self.getSuperficie() == other.getSuperficie()
        return False

    def __ne__(self, other):
        return not self == other

    def __hash__(self):
        return hash(self.getSuperficie())

    def __str__(self):
        return str(self.getSuperficie()) + "m^2"

    def __repr__(self):
        return self.__str__()