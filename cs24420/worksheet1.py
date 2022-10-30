import math
from operator import xor

#question 1
town = "Borth"
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
elif volume > 12000 and volume <= 15000:
    print("The cylinder is medium.")
else:
    print("The cylinder is large.")
#question 3
switch1 = True
switch2 = False
if switch1 ^ switch2:
    print("on")
else:
    print("off")
#question 4
n = 10
temp = 0
i = 0

while i <= 10:
    temp += 1/(2**i)
    i += 1
print(temp)