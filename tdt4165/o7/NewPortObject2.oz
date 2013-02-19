declare
fun {NewPortObject2 Proc}
   Sin
in
   thread
      for Msg in Sin do {Proc Msg} end
   end
   {NewPort Sin}
end
