// Get sum from x to y using simple recursion
def getSumFromXtoY(x: Int, y: Int): Int = {
  if (x == y) {
    return y;
  }

  x + getSumFromXtoY(x + 1, y)
}

// Get sum of squares from x to y using match pattern
def getSumOfSquaresFromXtoY(x: Int, y: Int): Int = {
  (x < y) match {
    case false => x * x;
    case true => x * x + getSumOfSquaresFromXtoY(x + 1, y);
  }
}

getSumFromXtoY(1, 4)
getSumOfSquaresFromXtoY(1, 4)

// Get sum of squares using map and reduce
List(1, 2, 3, 4).map(x => x * x).reduce((x, y) => x + y)

// Define summation functions using higher order functions
def defineSummationFunction(f: Int => Int):
(Int, Int) => Int = {
  def sumF(x: Int, y: Int): Int = {
    if (x > y) 0 else f(x) + sumF(x + 1, y)
  }

  sumF
}

def sumOfSquares = defineSummationFunction(x => x * x)
sumOfSquares(1, 4)


