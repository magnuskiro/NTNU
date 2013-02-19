declare
fun {NewPortObject Init Fun}
   Sin
in
   thread _={FoldL Sin Fun Init} end
   {NewPort Sin}
end
