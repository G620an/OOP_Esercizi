import re

class NomeProgetto:
    def __init__(self , nome:str):
        if nome is None:
            raise ValueError("Nome Progetto nullo")

        if (len(nome) < 4) or (len(nome) > 24) or not(re.match("\w+" , nome)): #\w serve a dire che il nome è del tipo Ciao_Mondo oppure cIAOMondo_
            raise ValueError("Nome Progetto non valido")

        self._nome = nome

    def getNome(self):
        return self._nome

    def __eq__(self, other):
        if other is None:
            return False
        if other is self:
            return True
        if isinstance(other , NomeProgetto):
            return other.getNome() == self.getNome()
        return False

    def __ne__(self , other):
        return not self == other

    def __hash__(self):
        return hash(self.getNome())

    def __str__(self):
        return self.getNome()

    def __repr__(self):
        return self.__str__()