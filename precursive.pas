program factorial(input,output);
var number: real; {declaring variables}

{defining the factorial function}
function factorials(num: real): real;
var result: real;

	begin
		if (num = 0) then
			result := 1
		else
			result := num * factorials(num-1);
		factorials := result;
	end;
	
{start main program}
begin
	writeln( 'Enter an integer ');
	read(number);
	writeln(factorials(number));
end.