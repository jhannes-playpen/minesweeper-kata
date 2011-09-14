A field of N x M squares is represented by N lines of 
exactly M characters each. The character '*' represents 
a mine and the character '.' represents no-mine. 

Example input (a 4 x 3 mine-field of 12 squares, 2 of
which are mines)

4 3
*...
..*.
....

Your task is to write a program to accept this input and
produce as output a hint-field of identical dimensions 
where each square is a * for a mine or the number of 
adjacent mine-squares if the square does not contain a mine. 

Example output (for the above input)
*211
12*1
0111

Acceptance test:
"*...", "....", ".*..", "...."  => 	"*100", "2210", "1*10", "1110"
"**...", ".....", ".*..." => "**100", "33200", "1*100"

http://codingdojo.org/cgi-bin/wiki.pl?KataMinesweeper
https://github.com/JonJagger/cyberdojo/blob/master/filesets/kata/Mine%20Field%20(**)/instructions
