class Budget:
    def __init__(self , budget:float):
        if budget < 10000.00 :
            raise ValueError('Budget deve essere maggiore di 10.000€')
        self._budget = budget

    def getBudget(self):
        return self._budget

    def __eq__(self , other):
        if other is None:
            return False
        if self is other:
            return True
        if isinstance(other , Budget):
            return self.getBudget() == other.getBudget()
        return False

    def __ne__(self , other):
        return not self == other

    def __hash__(self):
        return hash(self.getBudget())

    def __str__(self):
        return str(self.getBudget()) + "€"

    def __repr__(self):
        return self.__str__()