{**********************************************
Sample Pascal program
***********************************************}
program linearSearch(input,output);
type
searchArray = array [1..20] of real;
procedure Introduction;
begin {Introduction}
writeln('This program reads numbers from a file called input.dat,');
writeln('sorts the numbers.');
end; {Introduction}
procedure sort(var store: searchArray);
{If you moved min out of this procedure, you will have to pass store}
function min(start: integer): integer;
var
i: integer;
tempMin: integer;
begin {min}
tempmin := start; {Note: case insensitive}
for i := start+1 to 20 do
if store[i] < store[tempMin] then
tempMin := i;
min := tempMin;
end; {min}
procedure swap(var l,r : real);
var
temp: real;
begin {swap}
temp := l;
l := r;
r := temp;
end; {swap}
var
i: integer;
begin {sort}
for i := 1 to 19 do
swap(store[i],store[min(i)]);
end; {sort}
procedure display(store: searchArray);
var
i: integer;
begin {display}
 for i := 1 to 20 do
writeln(store[i]:7:2);
end; {display}
procedure readInput(var store: searchArray);
var
infile : TEXT;
i : integer;
filename: String[100];
begin {readInput}
write('Please input the filename: ');
readln(filename);
assign(infile,filename);
reset(infile);
for i := 1 to 20 do
begin
read(infile,store[i]);
end;
end; {readInput}
var
s: searchArray;
begin {main}
introduction;
readInput(s);
sort(s);
writeln('Sorted numbers are as follows:');
display(s);
end. {main}