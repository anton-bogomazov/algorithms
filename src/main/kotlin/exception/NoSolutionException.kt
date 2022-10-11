package exception

class NoSolutionException(message: String) : Throwable(message)

fun noSolutionError(): Nothing = throw NoSolutionException("There is no solution")
