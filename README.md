# SnakeGame

Mark loves playing games, Gluttonous snake( an old game in NOKIA era ) is one of his favourites.
However, after playing gluttonous snake so many times, he finally got bored with the original rules.
In order to bring new challenge to this old game, Mark introduced new rules :
    1. The ground is a grid, with n rows and m columns(1 <= n, m <= 500).
    2. Each cell contains a value v (-1 ≤vi≤99999), if v is -1, then this cell is blocked, and the snake
       can not go through, otherwise, after the snake visited this cell, you can get vpoint.
    3. The snake can start from any cell along the left border of this ground and travel until itfinally
       stops at one cell in the right border.
    4. During this trip, the snake can only go up/down/right, and can visit each cell onlyonce.
       Special cases :
       a. Even in the left border and right border, the snake can go up anddown.
       b. When the snake is at the top cell of one column, it can still go up, which demands the player to
          pay all current points , then the snake will be teleported to the bottom cell of this column and vice versa.
After creating such a new game, Mark is confused how to get the highest score. Please help him to write a program to solve this problem.

Input::-
The first line contains two integers n (rows) and m (columns), (1 <= n, m <= 500), separated by a
single space.
Next n lines describe the grid. Each line contains m integers vi (-1 ≤vi ≤99999)
vi = -1 means the cell is blocked.

Output:-
Output the highest score you can get. If the snake can not reach the right side, output -1.
Limits
• Memory limit per test : 256 megabytes
• Time limit per test : The faster the better

Compile & Environment:-
C++
g++ Main.cc -o Main -fno-asm -Wall -lm --static -std=c++0x -DONLINE_JUDGE
Java
Java 7
Maximum stack size is 50m
