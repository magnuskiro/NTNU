declare

%a
fun {Length Xs}
   case Xs of nil then
      0
   [] _|T then
      1+{Length T}
   end
end

%b
fun {Take Xs N}
   if N<1 then
      nil
   else
      case Xs of nil then
	 nil
      [] H|T then
	 H|{Take T N-1}
      end
   end
end

%c
fun {Drop Xs N}
   if N<1 then
      Xs
   else
      case Xs of nil then
	 nil
      [] _|T then
	 {Drop T N-1}
      end
   end
end

%d
fun {Append Xs Ys}
   case Xs
   of nil then
      Ys
   [] H|T then
      H|{Append T Ys}
   end
end

%e
fun {Member Xs Y}
   case Xs of nil then
      false
   [] H|T then
      if H==Y then
	 true
      else
	 {Member T Y}
      end
   end
end

%f
fun {Position Xs Y}
   case Xs of H|T then
      if H==Y then
	 1
      else
	 1+{Position T Y}
      end
   end
end
