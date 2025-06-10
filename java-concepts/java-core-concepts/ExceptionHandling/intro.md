## Exception Handling:
    => Its a mechanism to handle runtime errors, so the normal flow of the application can be maintained.


## Types of Exceptions:
    1. Checked Exceptions: Checked at compile-time. Example: (IOException, SQLException).
    2. Unchecked Exceptions: Checked at runtime (subclass of RuntimeException) Example: NullPointerException, ArrayIndexOutOfBoundException.
    3. Errors: very serious problem not meant to be caught (e.g., OutOfMemoryError).


## Core keywords:
1. try      ->  code block to monitor exception.
2. catch    -> handle the exceptions.
3. finally  -> executes code regardless of exception
4. throw    -> used to explicitly throw an exception
5. throws   -> Declares exceptions that a method might throw.

