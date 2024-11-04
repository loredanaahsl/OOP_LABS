# LAB1: Working with classes
## Objective.
Building confidence and connection with Java by designing classes, creating diverse objects, exploring modules and packages, and mastering Git essentials.
our end solution should write the files.

# Task 1: Objects & Object Interaction #
## Task 1 Goals: ##
- See how a class can create different objects with different attributes from the same class template.
- Learn how objects can interact with other objects, through a comparison method in the class.
- Code reuse.
## Task 1 Description: ##
- Create a Display class following the given UML diagram. (constructors, setters & getters are ignored).
- Instantiate 3 display objects of type Display, and compare the objects. The printed result is descriptive and verbose, of how the monitors stand one against another. Which is bigger, which is sharper, or if the interest is in both size and sharpness, use compareWithMonitor.
# Task 2: Program arguments and Text parsing. #
## Task 2 Goals: ##
- Learn about class reuse. (The painful way or the easy way).
- Learn how you can pass command line arguments to a program.
- Learn more about language capabilities and text parsing through a fun challenge.
## Task 2 Description: ##
- Make use of the String[] args of main method. Through args variable, get the name and location of the .txt file to be processed. Reuse the class you already wrote (or write from scratch/modify the existing one) ex:
- Once you get the text from the .txt file, create a class to represent the txt file ex:
- Print the object of textData info in the main() method.
# Task 3: Class composition ##
## Task 3 Goals: ##
- Learn about class composition. 
- Practice List iteration.
## Task 3 Description: ##
Reuse the Display Class and create an Assistant Class that holds Display data. The Assistant will help you make a choice of Display object by giving you the info about the monitors assigned to the Assistant (constructor, setters & getters ignored)
- assignDisplay(Display d): Adds a Display object to the assignedDisplays list.
- assist(): Iterates through the assignedDisplays list, comparing each Display object sequentially:
  - Start with the first Display object.
  - Compare it to the next Display object in the list.
  - Continue this process until all Display objects have been compared.
- buyDisplay: Removes a display from the list of displays, returning the reference to that display.
## Task 4: Bonus Task, almost there ##
## Task 4 Goals: ##
- Once again, time to add new functionality to a previous task.
- For this task, update the task 2 to handle multiple text files from String args[] and print the TextData of each passed file.</br>
</br>Made it this far? Your path sure was fun, and I know the effort was also great experience, see you at the next laboratory.- pdf lab file