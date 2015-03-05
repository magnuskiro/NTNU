\insert 'List.oz'
declare
fun {FewerFind Ms Os Ts Ys}
   case Ys of nil then nil
   [] Y | Yr then
      if {Member Ms Y} then
	 M | Mr = Ms in
	 if Y==M then
	    {FewerFind Mr Os Ts Yr}
	 else
	    Fs Bs in
	    Fs#Bs = {SplitTrain Ms Y}
	    one({Length Bs}+1) |
	    two({Length Fs}) |
	    one(~1) |
	    {FewerFind nil {Append Bs Os} {Append Fs Ts} Yr}
	 end
      elseif {Member Os Y} then Fs Bs in
	 Fs#Bs = {SplitTrain Os Y}
	 one(~{Length Fs}) |
	 two({Length Fs}) |
	 one(~1) |
	 {FewerFind nil Bs {Append Fs Ts} Yr}
      elseif {Member Ts Y} then Fs Bs in
	 Fs#Bs = {SplitTrain Ts Y}
	 two(~{Length Fs}) |
	 one({Length Fs}) |
	 two(~1) |
	 {FewerFind nil {Append Fs Os} Bs Yr}
      else
	 raise something_is_wrong end
      end
   end
end
