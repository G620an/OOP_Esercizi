from Ristrutturazioni import *


class ComputoMetricoImpl(ComputoMetrico):
    def __init__(self):
        self._Voci = []

    def aggiungiVoce(self , descrizione:str , qta:float , prezzoUnitario:float , operai:int):
        v = Voce(descrizione, qta, prezzoUnitario, operai)
        self._Voci.append(v)

    def cercaVoce(self , descrizione:str):
        for v in self:
            if v.descrizione==descrizione:
                return v
        return None

    def rimuoviVoce(self , descrizione:str):
        v = self.cercaVoce(descrizione)
        if v is None:
            return False
        return self._Voci.remove(v)

    def __iter__(self):
        return self._Voci.__iter__()

    def __repr__(self):
        s = ""
        for v in self:
            s += v + "\n"
        return s