from Punto import AbstractPoint2D
import math

class PolarPoint2D(AbstractPoint2D):
    def __init__(self, x, y):
        self._ro = math.sqrt(x*x + y*y)
        self._tetha = math.atan2(y, x)

    def getX(self):
        return self._ro * math.cos(self._tetha)

    def getY(self):
        return self._ro * math.sin(self._tetha)

    def getRo(self):
        return self._ro

    def getTetha(self):
        return self._tetha