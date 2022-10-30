
if town.__contains__("yth") == True:
    temp = 0
    print("hooray!")
    for x in town:
        if x == "y":
            temp += 1
    print("number of 'y's in town :", temp)
    print("length of town :", len(town))
#question 2
depth = 20
radius = 14
volume = (math.pi * (radius ** 2)) * depth
print("Volume : " , volume)
if volume <= 12000:
    print("The cylinder is small.")