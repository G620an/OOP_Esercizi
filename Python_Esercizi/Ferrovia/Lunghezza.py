class Lunghezza():
    def __init__(self , l):
        if(l < 5.0 or l > 35.0):
            raise ValueError("Lunghezza non valida, non compresa tra 5 e 35")
        self._l = l

    def getLunghezza(self):
        return self._l

    def __eq__(self, other):
        if(other is None):
            return False
        if(self is other):
            return True
        if(isinstance(other, Lunghezza)):
            return self.getLunghezza() == other.getLunghezza()
        return False

    def __ne__(self, other):
        return not self == other

    def __gt__(self, other):
        if(other is not None and isinstance(other, Lunghezza)):
            return self.getLunghezza() > other.getLunghezza()
        raise TypeError("Lunghezza non valide")

    def __lt__(self , other):
        if(other is not None and isinstance(other , Lunghezza)):
            return self.getLunghezza() <= other.getLunghezza()
        raise TypeError("Lunghezza non valide")

    def __ge__(self , other):
        if(self == other):
            return True
        return self > other

    def __le__(self , other):
        if(self == other):
            return True
        return self < other