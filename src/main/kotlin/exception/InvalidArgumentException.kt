package exception

class InvalidArgumentException(message: String) : Throwable(message)

fun invalidArgumentError(message: String): Nothing = throw InvalidArgumentException(message)
