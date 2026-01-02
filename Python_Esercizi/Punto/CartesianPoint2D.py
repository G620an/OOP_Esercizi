from Punto.AbstractPoint2D import AbstractPoint2D

class CartesianPoint2D(AbstractPoint2D):
    def __init__(self, x, y):
        self._x = x
        self._y = y

    def getX(self):
        return self._x

    def getY(self):
        return self._y

