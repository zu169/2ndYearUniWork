from plot_mars import *
import matplotlib.pyplot as plt
import numpy as np
lowerBound, higherBound = 0.5, 5.0
#question 1, 2
arrHeights = np.random.uniform(lowerBound, higherBound, 100)
mean = np.mean(arrHeights)
print(f"The mean of the 100 trees is {round(mean, 2)} metres.")
#question 3
forest_means = []
for x in range(0, 1000):
    forest_means.append(round(np.mean(np.random.uniform(lowerBound, higherBound, 100)),3)) 
#question 4
s_means = sorted(forest_means)
print(f"Sorted list of a 1000 means: {s_means}")
#question 5
amazon_mean = 2.50
fifth = np.percentile(s_means,5)
if amazon_mean < fifth:
    print(f"The mean of the Amazon forest, {amazon_mean}m is within the lowest 5% ({fifth:.3f}m) of the artificially simulated forests.")
else: 
    print(f"The mean of the Amazon forest, {amazon_mean}m isn't within the lowest 5% ({fifth:.3f}m) of the artificially simulated forests. ")

#question 6 (extra work)
marsHeightMap = np.fromfile("megt90n000cb", dtype='>i2')
