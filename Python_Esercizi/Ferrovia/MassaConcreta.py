from Ferrovia import Massa

class MassaConcreta(Massa):
    def __init__(self, m1):
        self._m1 = m1

    def getMassa(self):
        return self._m1

    class MassaFrenata(Massa):
        def __init__(self, m2):
            if(m2 < 0 or m2 > super().getMassa()):
            self._m2 = m2
