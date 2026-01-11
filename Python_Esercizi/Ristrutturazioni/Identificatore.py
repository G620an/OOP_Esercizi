import re

class Identificatore:
    def __init__(self , id:str):
        if id is None:
            raise ValueError("Identificatore non valido")
        if re.match("[A-Z][0-9]{3]-[0-9]{4}" , id):
            self._id = id
        else:
            raise ValueError("Identificatore non valido")

    def getId(self):
        return self._id

    def __eq__(self , other):
        if other is None:
            return False
        if self is other:
            return True
        if isinstance(other , Identificatore):
            return self.getId() == other.getId()
        return False

    def __ne__(self , other):
        return not self == other

    def __hash__(self):
        return hash(self.getId())

    def __str__(self):
        return self.getId()

    def __repr__(self):
        return self.__str__()

    def __gt__(self , other):
        return self.getId() > other.getId()

    def __ge__(self , other):
        if(self == other):
            return True
        else:
            return self > other

    def __lt__(self , other):
        return self.getId() < other.getId()

    def __le__(self , other):
        if(self == other):
            return True
        else:
            return self < other
