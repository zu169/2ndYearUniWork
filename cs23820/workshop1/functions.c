/* This is my first file of functions */
#include "functions.h"
int add_them_up (int x, int y) {
    int temp; /* define a local automatic variable which is not initialised*/
	temp = x + y; /* add up the value of the two parameters */
	return temp;
}

float divide_them_up (float x, float y) {
    float temp;
    temp = x / y;
    return temp;
}