Project Description
This Java OOP project models a simple university system using abstraction, inheritance, and interfaces. It defines Person (with Student and Lecturer subclasses) and Course (with SimpleCourse), and uses Display and Contactable interfaces to enforce consistent behavior.
The program now collects details from the user at runtime (instead of hardcoded values), creates objects, and displays their information.
Exceptions Implemented
The main method includes structured exception handling:

IllegalArgumentException
Caught to handle invalid data scenarios gracefully, with a user-friendly message.

Exception (generic catch)
Catches any unexpected runtime issues to prevent program crashes.

finally block
Ensures the Scanner is always closed, releasing resources safely.

Changes Made to Main.java (Compared to Original)

* Replaced hardcoded objects with dynamic user input using Scanner.
* Added prompts for Student, Lecturer, and Course details.
* Wrapped main logic in try/catch/finally for error handling.
* Added user-friendly error messages in catch blocks.
* Ensured resource cleanup by closing the scanner in finally.
