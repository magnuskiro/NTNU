declare
fun {SumTo F L}
   if L>=F then
      F + {SumTo F+1 L-1}
   else
      F
   end
end

{Browse {SumTo 3 5}}