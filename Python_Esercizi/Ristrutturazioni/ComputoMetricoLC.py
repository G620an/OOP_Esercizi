from Ristrutturazioni import *

class Nodo:
    def __init__(self , info):
        self.info = info
        self.next = None

class Iterator:
    def __init__(self, radice:Nodo):
        self.radice = radice

    def __next__(self):
        if self.radice is None:
            raise StopIteration
        else:
            ret = self.radice.info
            self.radice = self.radice.next
            return ret

class ComputoMetricoLC(ComputoMetrico):
    def __init__(self):
        self._testa = None
        self._coda = None
        self._l = 0

    def aggiungiInTesta(self , info):
        n = Nodo(info)
        if(self._l == 0):
            self._testa = n
            self._coda = n
            self._l += 1
            return
        n.next = self._testa
        self._testa = n
        self._l += 1

    def aggiungiInCoda(self , info):
        n = Nodo(info)
        if(self._l == 0):
            self.aggiungiInTesta(info)
        self._coda.next = n
        self._coda = n
        self._l += 1

    def __len__(self):
        return self._l

    def __iter__(self):
        return Iterator(self._testa)


