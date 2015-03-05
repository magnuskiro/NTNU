\insert 'List.oz'
declare
fun {FewFind Xs Ys}
   case Ys of nil then
      nil
   [] Y | Yr then
      X | Xr = Xs in
      if Y==X then
	 {FewFind Xr Yr}
      else
	 Hs Ts in
	 Hs#Ts = {SplitTrain Xs Y}
	 one({Length Ts}+1) |
	 two({Length Hs}) |
	 one(~({Length Ts}+1)) |
	 two(~({Length Hs})) |
	 {FewFind {Append Ts Hs} Yr}
      end
   end
end
