declare

fun {Compress Moves}
   NewMvs = {ApplyRules Moves}
in
   if NewMvs==Moves then Moves 
   else 
        {Compress NewMvs} 
   end
end

fun {ApplyRules Mvs}
   case Mvs of nil then nil
   [] one(A) | one(B) | Rest then
      one(A+B) | {ApplyRules Rest}
   [] two(A) | two(B) | Rest then
      two(A+B) | {ApplyRules Rest}
   [] one(0) | Rest then
      {ApplyRules Rest}
   [] two(0) | Rest then
      {ApplyRules Rest}
   [] H | Rest then
      H | {ApplyRules Rest}
   end
end
