\insert List.oz

declare

fun {SplitTrain Xs Y}
   Pos = {Position Xs Y}
   Hs = {Take Xs Pos-1}
   Ts = {Drop Xs Pos}
in
   Hs#Ts
end

fun {Find Xs Ys}
   case Ys of nil then
      nil
   [] Y | Yr then Hs Ts in
      Hs#Ts = {SplitTrain Xs Y}
      one({Length Ts}+1) |
      two({Length Hs}) |
      one(~({Length Ts}+1)) |
      two(~({Length Hs})) |
      {Find {Append Ts Hs} Yr}
   end
end
