%%
%%  Authors:
%%    Christian Schulte <schulte@imit.kth.se>
%%      LECS, IMIT, KTH - Royal Institute of Technology
%%      Stockholm, Sweden
%%
%%  Copyright:
%%    Christian Schulte, 2002
%%
%%  Last change:
%%    $Date: 2002/07/24 14:23:31 $ by $Author: schulte $
%%    $Revision: 1.5 $
%%
%%  Purpose:
%%    Datalogi II, Lab A, Visualizing the shunting station
%%

declare

proc {Visualize States}
   %% Dimensions for graphics
   N  = {Max ({Length States.1.main} +
         {Length States.1.trackA} +
         {Length States.1.trackB}) 4}
           % Maximal number of wagons per track
   W  = 55 % Width of a wagon
%   WD = 5  % Space between wagons
   H  = 45 % Height of a wagon
%   HD = 5  % Space between wagon and track border
   B  = 25 % Border around tracks
   %% Window structure
   T    = {New Tk.toplevel tkInit(title:'Train Shunting Visualizer')}
   F    = {New Tk.frame tkInit(parent:T)}
   %% Buttons with logic
   Pos  = {NewCell 1} % Stores the state currently displayed
   Prev = {New Tk.button tkInit(parent: F
            text:   'Prev'
            action:
               proc {$}
                  I I1={Exchange Pos I}
               in
                  if I==2 then
                {Prev tk(configure state:disabled)}
                  end
                  I1=I-1
                  {Next tk(configure state:normal)}
                  {Show {Nth States I1}}
               end
            state: disabled
                )}
   Next = {New Tk.button tkInit(parent: F
            text:   'Next'
            action:
               proc {$}
                  I I1={Exchange Pos I}
               in
                  if I+1=={Length States} then
                {Next tk(configure state:disabled)}
                  end
                  I1=I+1
                  {Prev tk(configure state:normal)}
                  {Show {Nth States I1}}
               end
            state: if {Length States}==1 then
                 disabled
                   else
                 normal
                   end

                )}
   %% Important coordinates
   Y0  = B+0
   Y1  = B+H
   Y2  = B+2*H
   Y25 = Y2 + H div 2
   Y3  = B+3*H
   Y4  = B+4*H
   Y5  = B+5*H
   X0  = B+0
   X1  = B+N*W
   X2  = X1 + H div 2 + H div 4
   X3  = X1 + 2*H+10
   X31 = X1 + 2*H
   X4  = X3 + N*W

   %% The drawing area
   C = {New Tk.canvas tkInit(parent: T
              bg:     wheat
              width:  X4+B
              height: 2*B+5*H)}
/*
   %% Routines for drawing a single wagon
   proc {Wagon X Y T}
      {C tk(create rectangle X+WD Y+HD X+W-WD Y+H-HD
       fill:grey)}
      {C tk(create text X+W div 2 Y + H div 2 text:T)}
   end
*/
   %% Routines for drawing a single wagon
   proc {Wagon X Y T}
      N Engine
   in
      N = ({Atom.toString T}.1 - 96) mod 11
      Engine = {New Tk.image tkInit(type:photo file:'images/'#N#'.gif')}
      {C tk(create image X+W div 2 Y+H div 2 image:Engine)}
      {C tk(create text X+W div 2 Y anchor:n text:T)}
   end

   %% Display a state
   proc {Show State}

      %% Display each track
      proc {Main Ws}
    {List.forAllInd {Reverse Ws}
     proc {$ I T}
        {Wagon X1-I*W Y2 T}
     end}
      end

      proc {One Ws}
    {List.forAllInd Ws
     proc {$ I T}
        {Wagon X3+(I-1)*W Y0 T}
     end}
      end

      proc {Two Ws}
    {List.forAllInd Ws
     proc {$ I T}
        {Wagon X3+(I-1)*W Y4 T}
     end}
      end

   in
      %% Reset drawing
      {C tk(delete all)}
      %% Create tracks
      {C tk(create polygon
       X0 Y2 X0 Y3 X1 Y3  X31 Y5 X4 Y5
       X4 Y4-1 X3 Y4-1 X2 Y25 X3 Y1 X4 Y1
       X4 Y0 X31 Y0 X1 Y2  X0 Y2
       fill:    white
       outline: black)}
      %% Create railroads
      %{C tk(create line  X0 Y2+25 X1 Y2+25 width:2)}
      {C tk(create line  X0 Y3-4 X1+3 Y3-4 width:2)}
      {C tk(create line  X1+2 Y3-4 X31+2 Y5-4 width:2)}
      {C tk(create line  X31+2 Y5-4 X4 Y5-4 width:2)}
      {C tk(create line  X1+2 Y3-4 X31+2 Y1-4 width:2)}
      {C tk(create line  X31+2 Y1-4 X4 Y1-4 width:2)}

      %% Label tracks
      {C tk(create text X0+10 Y2-10 anchor:w text:'Main')}
      {C tk(create text X3+10 Y0-10 anchor:w text:'One')}
      {C tk(create text X3+10 Y4-10 anchor:w text:'Two')}
      %% Draw trains
      {Main State.main}
      {One  State.trackA}
      {Two  State.trackB}
   end

in
   {Tk.batch [grid(F row:0 column:0)
         pack(Prev Next side:left padx:5#m pady:2#m)
         grid(C row:1 column:0)]}
   {Show States.1}
end
