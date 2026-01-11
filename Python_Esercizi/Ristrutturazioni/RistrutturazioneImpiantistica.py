from Ristrutturazioni import *

class RistrutturazioneImpiantistica(RistrutturazioneAbstract):
    def __init__(self , ID:Identificatore , nome:NomeProgetto , capOperai:CapacitaOperai , superficie:Superficie , budget:Budget , complessita:Complessita , computoMetrico:ComputoMetrico):
        self._ID = ID
        self._nome = nome
        self._capOperai = capOperai
        self._superficie = superficie
        self._budget = budget
        self._complessita = complessita

    def getID(self):
        return self._ID

    def getNomeProgetto(self):
        return self._nome

    def getCapacitaOperai(self):
        return self._capOperai

    def getSuperficie(self):
        return self._superficie

    def getBudget(self):
        return self._budget

    def getComplessita(self):
        return self._complessita

    def getComputoMetrico(self):
        return self._computoMetrico