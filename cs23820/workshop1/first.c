/* This is a first C program */
#include "functions.h"
#include "stdio.h"
void main() {
float a, b, c; 	/* define three integer variable */
int numofHeights;
	a = 4; b = 5; /* give them values */
	c = add_them_up(a, b); /* add them up */
	/* print out some answers */
	printf("The sum of %g and %g is %g\n", a, b, c);
    c = divide_them_up(a, b);
    printf("The division of %g and %g is %.2f\n", a, b, c);
    printf("How many heights do u wish to convert?");
    scanf("%d", numofHeights);
    for (int i = 0; i <= numofHeights; i++){
        int temp;
        printf("PLease enter a height to convert.. (feet and inches");
        scanf("%d", temp);

    }
}
