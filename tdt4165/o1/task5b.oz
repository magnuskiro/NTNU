declare
fun{Max X Y}
   if X==0 then
      Y
   else
      {Max X-1 Y-1}
   end
end

declare K = {Max 7 6}
if K<0 then
   {Browse 'X is the biggest'}
else
   {Browse 'Y is the biggest'}
end
