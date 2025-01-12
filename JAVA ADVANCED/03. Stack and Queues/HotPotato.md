# Hot Potato

-----------------------------------------------------------------------------------------------
Hot potato is a game in which children form a circle and start passing a hot potato. The counting starts with the first kid. Every nth toss the child left with the potato leaves the game. When a kid leaves the game, it passes the potato along to its next neighbor.
This continues until there is only one kid left.
---------------------------------------------------------------------------

![image](https://github.com/user-attachments/assets/ec9edff7-69f0-4f90-986c-020a9269c32c)

-------------------------------------------------------------------------------------------------

Create a program that simulates the game of Hot Potato. Print every kid that is removed from the circle. In the end, print the kid that is left last.
-------------------------------------------------------------------------------------------------
Illustration for the first example (Alva + James + William, n=2):

![image](https://github.com/user-attachments/assets/dcf6015d-baad-4ab7-b978-dd2b12e44a99)

--------------------------------------------------------------------------------------------------
# Hints
--------------------------------------------------------------------------------------------------
•	Enqueue all kids in a Queue<string>.
--------------------------------------------------------------------------------------------------
•	For each round do the following:
--------------------------------------------------------------------------------------------------
o	(n-1) times deque an element and enqueue it again.
--------------------------------------------------------------------------------------------------
o	Remove an element and print it (this is the nth element).
--------------------------------------------------------------------------------------------------
•	Repeat the above until the queue remains holding only 1 element.
--------------------------------------------------------------------------------------------------
