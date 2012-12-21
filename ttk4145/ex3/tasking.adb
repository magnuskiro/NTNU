with Ada.Text_IO, Ada.Integer_Text_IO;
use Ada.Text_IO, Ada.Integer_Text_IO;

procedure Tasking is

   task Hello;
   task body Hello is
   begin
     loop
	    Put_Line("Hello");
	    delay 1.0;
     end loop;
   end Hello;

   task World;
   task body World is
   begin
     loop
         Put_Line("World");
	     delay 2.0;
     end loop;
   end World;

begin
    null;
end Tasking;
