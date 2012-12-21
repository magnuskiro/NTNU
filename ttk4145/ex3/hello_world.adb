with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Strings.Unbounded;
use Ada.Strings.Unbounded;
with Ada.Command_Line;
use Ada.Command_Line;

procedure hello_world is
    
    name    :   String(1 .. 31);
    i       :   INTEGER;    
    
begin
    Until_Loop:
        loop
            Put("Please enter your name: ");
            Get_Line(name, i);
            if i < 2 then
                Put_Line("Name to short");
            elsif i >= 31 then
                Put_Line("Sorry, your name is too long, try a shorter one");
            else
                Put("The Hive Mind greets you, ");
                Put(name (1 .. i));
            end if;
            exit Until_Loop when i >= 2 and i <= 31;
    end loop Until_Loop;            
end hello_world;

