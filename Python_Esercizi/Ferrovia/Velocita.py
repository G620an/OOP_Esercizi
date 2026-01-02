from Ferrovia.Lunghezza import Lunghezza


class Velocita:
    def __Init__(self , kmh):
        if(kmh < 0):
            raise ValueError("Valore minore di zero")
        self._kmh = kmh

    def getKhm(self):
        return self._kmh

    def __eq__(self , other):
        if(other is None): return False
        if(self is other): return True
        if(isinstance(other , Velocita)):
            return self.getKhm() == other.getKhm()
        return False

    def __ne__(self , other):
        return not self == other

    def __lt__(self , other):
        if(other is not None and isinstance(other , Lunghezza)):
            return self.getKhm() < other.getLunghezza()
        raise TypeError("Lunghezza non valide")

    def __gt__(self , other):
        if(other is not None and isinstance(other , Lunghezza)):
            return self.getKhm() > other.getLunghezza()
        raise TypeError("Lunghezza non valide")

    def __le__(self , other):
        if(self == other): return True
        return self < other

    def __ge__(self , other):
        if(self == other): return True
        return self > other 
