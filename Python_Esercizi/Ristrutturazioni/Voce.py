class Voce:
    def __init__(self, descrizione:str , qta:float , prezzoUnitario:float , operai:int):
        if (qta < 0.0) or (prezzoUnitario < 0.0) or (operai < 0.0):
            raise ValueError("Voce non valido")
        self._descrizione = descrizione
        self._qta = qta
        self._prezzoUnitario = prezzoUnitario
        self._operai = operai

    def getOperai(self):
        return self._operai

    def getDescrizione(self):
        return self._descrizione

    def getPrezzoUnitario(self):
        return self._prezzoUnitario

    def getQta(self):
        return self._qta

    def __eq__(self, other):
        if other is None:
            return False
        if self is other:
            return True
        if isinstance(other, Voce):
            return self.getDescrizione() == other.getDescrizione() and\
                   self.getPrezzoUnitario() == other.getPrezzoUnitario() and\
                   self.getQta() == other.getQta() and\
                   self.getOperai() == other.getOperai()
        return False

    def __ne__(self, other):
        return not self == other

    def __hash__(self):
        return hash(self.getDescrizione())

    def __str__(self):
        return "Descrizione: " + self.getDescrizione() + ", Quantità: " + str(self.getQta()) + ", Prezzo Unitario: " + str(self.getPrezzoUnitario()) +\
                ", Operai: " + str(self.getOperai())

    def __repr__(self):
        return self.__str__()