import Punto.Point2D as Point2D
import math

class AbstractPoint2D(Point2D):
    def distanza(self , punto):
        return math.sqrt(math.pow(self.getX() - punto.getX(), 2) + math.pow(self.getY() - punto.getY()))

    def somma(self , punto):
        p = Point2D(self.getX() + punto.getX() , self.getY() + punto.getY())
        return p

    def copy(self):
        return Point2D(self.getX() , self.getY())

    def __eq__(self , other):
        if(other is None):
            return False
        if(self is other):
            return True
        if(isinstance(Point2D , other)):
            return self.getX() == other.getX() and self.getY() == other.getY()
        return False

    def __ne__(self , other):
        return not (self == other)

    def __str__(self):
        return "(" + str(self.getX()) + " ; " + str(self.getY()) + ")"

    def __hash__(self):
        return hash(self.__str__())