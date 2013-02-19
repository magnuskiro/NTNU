\insert 'NewPortObject.oz'
\insert 'NewPortObject2.oz'

declare
%Task1
fun {MathAgent}
    {NewPortObject 0 
        fun {$ N Message}
            case Message of 
            add(X) then N+X
            [] sub(X) then N-X
            [] mult(X) then N*X
            [] divide(X) then N div X
            [] get(X) then Z=N
            N
        end
    end}
end

MathPObj = {MathAgent}
{Send MathPObj add(3)}
{Send MathPObj sub(7)}
{Browse {Send MathPObj get($)}} % displays ~4
{Send MathPObj add(27)}
{Browse {Send MathPObj get($)}} % displays 23
MathPObj2 = {MathAgent}
{Send MathPObj2 mult(27)}
{Browse {Send MathPObj2 get($)}} % displays 0

%Task2
declare
% Messages sent to the Dating Service
% seeking(MySex MeDescription OtherSex OtherDescription ResponsePort)
% Messages sent by the Dating service on ResponsePort
% list(CompatiblePeople)
% match(CompatiblePerson)
%% The port object factory

fun {CheckCompatible A B C D}
   A==B andthen C==D
end

fun {NewDatingService}
    {NewPortObject
    state(women:nil men:nil)
    fun {$ state(women:Women men: Men) Message}
        case Message of 
            seeking(MySex MeDesc OtherSex OtherDesc ResponsePort) then
            local
                OtherSexList = if OtherSex==male then Men else Women end
                Compatible = {Filter    
                                OtherSexList
                                fun {$ Seeking(_ Them DesiredSex DesiredDesc _)}           
                                    MySex == DesiredSex
                                    andthen
                                    {CheckCompatible MyDesc DesiredDesc OtherDesc Them}
                                end}
            in
                if Compatible \= nil
                then
                    {Send ResponsePort list(Compatible)}
                    for seeking (_ _ _ _ RP) in Compatible do
                        {Send RP match(Mysex OtherSex OtherDesc ResponsePort)}
                    end
                end
                state(women: if Mysex==Female then Message|Women else Women end men: if MySex==male then Message|Men else Men end)
            end
        end
    end
    }
end

DatingService = {NewDatingService}

fun {NewClient Name MySex MyDesc OtherSex OtherDesc}
    RP = {NewPortObject2
        proc {$ Msg}
            {Browse Name#’ got ’#Msg}
        end}
in
    {Send DatingService seeking(MySex MyDesc OtherSex OtherDesc RP)}
    RP
end

Alice = {NewClient ’Alice’ female blond male dark}
Bob = {NewClient ’Bob’ male dark female blond}
Candice = {NewClient ’Candice’ female blond male dark}
Dale = {NewClient ’Dale’ male dark female blond}
Elise = {NewClient ’Elise’ female brunette male blond}
Fred = {NewClient ’Fred’ male blond female brunette}
{Browse done}


%Task3
proc {ServerProc Msg}
    {Browse servergot(Msg)}
    case Msg
    of add(X Y ?Z) then
        Z=X+Y
    [] sub(X Y ?Z) then
        Z=X-Y
    [] mult(X Y ?Z) then
        Z=X*Y
    [] divide(X Y ?Z) then
        Z=X div Y
    end
end

Server = {NewPortObject2 ServerProc}

proc {ClientProc Msg}
    {Browse clientgot(Msg)}
    case Msg
    of work(?Y) then Y1 Y2 Y3 Y4 in
        {Send Server add(10 10 Y1)} % prints servergot(add(10 10 20))
        {Wait Y1}
        {Send Server sub(10 10 Y2)} % prints servergot(sub(10 10 0))
        {Wait Y2}
        {Send Server mult(10 10 Y3)} % prints servergot(mult(10 10 100))
        {Wait Y3}
        {Send Server divide(10 10 Y4)} % prints servergot(divide(10 10 1))
        {Wait Y4}
        Y=Y1+Y2+Y3+Y4
    end
end

Client = {NewPortObject2 ClientProc}
{Browse {Send Client work($)}} % prints 121

%Task 4 
% A)
% When adding a callback to an RMI function you can then access the original function passed to the RMI function. 
% orgFunction() calls RemoteFunction(orgFunction) whic then can execute orgFunction()

% B)
% When adding a callback to an RMI there is more then one way to do this. It can be done with the help of threads, record continuation or procedure continuation. 

%Task 5
%A)
fun {IntLister S E}
    if S == E then
        nil
    else
        {Delay 1000}
        S|{IntLister S+1 End}
    end
end

%B)
fun {Sum S Stream}
    case Stream of nil then
        S
    [] H|T then
        S|{Sum H+S T}
    end
end

%testing code for Task 5
local X in
    thread X = {IntLister 0 10} end
    thread Y = {Sum 0 X} end
    {Browse Y}
end

%Task 6
%A)
% Interleaving execution is when all threads take turns computing. We have one global sequence og computations in this case. 

%B)
% First a thread have to be ready. It is ready when it has all the information it needs to execute a computational step. Then the scheduler chooses one of the ready threads and computes the next computational step. 


