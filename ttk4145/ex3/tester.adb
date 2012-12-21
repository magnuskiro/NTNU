with Ada.Text_IO, Ada.Integer_Text_IO, Ada.Float_Text_IO;
use Ada;
use Ada.Text_IO, Ada.Integer_Text_IO, Ada.Float_Text_IO;

procedure tester is

    function Power (X: Positive; N: Positive) return Integer is
    begin
        if N=1 then
            return(X);
        else
            return (X*Power(X,N-1));
        end if;
    end Power;
    
    Number: Positive;
    Exponent: Positive;
    
begin
    Put("Enter a float number and a positive exponent");
    Get(Number);
    Get(Exponent);
    Put("The answer is");
    Put(Power(Number, Exponent), Exp=>0);
end tester;
