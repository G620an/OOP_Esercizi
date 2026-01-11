from Ristrutturazioni import Voce
class ComputoMetrico:
    def __init__(self):
        pass

    def aggiungiVoce(self , descrizione:str , qta:float , prezzoUnitario:float , operai:int):
        pass

    def rimuoviVoce(self , descrizione:str):
        pass

    def __iter__(self):
        pass

    def getPrezzo(self , index:int):
        if index < 0:
            raise IndexError("Errore indice negativo")
        i = 0
        for v in self:
            if i == index:
                return v.getPrezzoUnitario() * v.getQta()
        raise IndexError("Errore indice fuori dal range")

    def getOperai(self , index:int):
        if index < 0:
            raise IndexError("Errore indice negativo")
        i = 0
        for v in self:
            if i == index:
                return v.getOperai()
        raise IndexError("Errore indice fuori dal range")

    def calcolaCostoTotale(self):
        s = 0.0
        for v in self:
            s += v.getPrezzoUnitario() * v.getQta()
        return s

    def getOperaiTotale(self):
        p = 0
        for v in self:
            p += v.getOperai()
        return p


