with Ada.Text_IO;
with Ada.Integer_Text_IO;
with Ada.Numerics.Generic_Elementary_Functions;
use Ada.Text_IO;
use Ada.Integer_Text_IO;
use Ada.Numerics.Generic_Elementary_Functions;

procedure fibonacci is
    function fib (N:INTEGER) return Integer is
    begin
        return ( (1+Sqrt(5))**N -(1-Sqrt(5))**N ) / ((2**N) * Sqrt(5));
    end fib;
    N:INTEGER;
begin
    Put("enter n");
    Get(N);
    Put(fib(N));
end fibonacci;
