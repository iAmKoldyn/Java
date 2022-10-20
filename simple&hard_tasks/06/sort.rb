list = ["5","7","4","6","3","2","1"]
swap = true
size = list.length - 1																							
while swap
   swap = false
    for i in 0...size
        swap = list[i] > list[i + 1] 
	if list[i] > list [i + 1]
        	list[i], list[i + 1] = list[i + 1], list[i]
	end 
    end
    size -= 1
end
puts list.join(', ')

