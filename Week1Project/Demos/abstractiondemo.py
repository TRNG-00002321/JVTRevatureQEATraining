from abc import ABC, abstractmethod
import math

class Shape(ABC):
    @abstractmethod
    def Shape(self):
        pass

    @abstractmethod
    def Area(self):
        pass

class Circle(Shape):
    def __init__(self, num):
        self.radius = num

    def Shape(self):
        return "Circle"

    def Area(self):
        return int(math.pi * self.radius**2)

class Rectangle(Shape):
    def __init__(self, num1, num2):
        self.height = num1
        self.width = num2

    def Shape(self):
        return "Rectangle"

    def Area(self):
        return int(self.height * self.width)

class Triangle(Shape):
    def __init__(self, num1, num2, num3):
        self.side1 = num1
        self.side2 = num2
        self.side3 = num3

    def Shape(self):
        return "Triangle"

    def Area(self):
        s = 0.5 * (self.side1 + self.side2 + self.side3)
        return int((s * (s - self.side1) * (s - self.side2) * (s - self.side3)) ** 0.5)

circle = Circle(5)
print(circle.Shape())
print(circle.Area())

rectangle = Rectangle(3, 4)
print(rectangle.Shape())
print(rectangle.Area())

triangle = Triangle(3, 4, 5)
print(triangle.Shape())
print(triangle.Area())

# The following would fail because can't instantiate an abstract class (ykt)
# shape = Shape()
# print(shape.Shape())