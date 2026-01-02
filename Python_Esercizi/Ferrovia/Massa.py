class Massa:
    def __init__(self , m):
        if(m < 0.0 or m > 255.0):
            raise ValueError("Massa non valide, non compresa tra 0 e 255")
        self._m = m

    def __init__(self):
        self._ro = 0

    def getMassa(self):
        return self._m

    def __eq__(self, other):
        if(other is None): return False
        if(self is other): return True
        if(isinstance(other, Massa)):
            return self.getMassa() == other.getMassa()
        return False

    def __ne__(self, other):
        return not self == other

    def __str__(self):
        return "Massa: " + str(self.getMassa()) + "t"

    def __gt__(self, other):
        if(other is not None and isinstance(other, Massa)):
            return self.getMassa() > other.getMassa()
        raise TypeError("Massa non valide")

    def __lt__(self , other):
        if(other is not None and isinstance(other, Massa)):
            return self.getMassa() < other.getMassa()
        raise TypeError("Massa non valide")

    def __ge__(self , other):
        if(other == self):
            return True
        return self > other

    def __le__(self , other):
        if(other == self):
            return True
        return self < other

    def __hash__(self):
        return hash(self.getMassa())

