/**
 * University of Macedonia,
 * Department of Applied Informatics
 * Semester: 1,
 * Class: Algorithms with C,
 * ProjectName: LockersParser
 *
 * Author: Andronikos Giachanatzis
 */

#include <stdio.h>
#include <stdlib.h>

void PrintData(int NoLockers, int *object);

int main()
{
    int *lockers, NoLockers, i, j;

    // get the total number of lockers and set them to 0 so they are all closed at the beginning
    printf ("Please enter the number of the lockers: ");
        scanf("%d", &NoLockers);
    lockers=(int *)calloc(NoLockers, sizeof(int));

    // start parsing
    for (i=1;i<=NoLockers;i++)
    {
        /* the first locker that changes its state in every pass is the locker with index i, because the lockers with
            with a smaller index are not multiples of the i. So in order to avoid useless compares, the j starts every
            time from i-1 */
        for (j=i-1;j<NoLockers;j++)
        {
            // if the locker we are now interests us invert its state(closed-open)
            if ((j+1)%i==0)
                lockers[j]=(lockers[j]==0)?1:0;
        }
    }

    // print the current state of the lockers
    PrintData(NoLockers, lockers);
    free(lockers);

    system ("PAUSE");
    return 0;
}


/* Input: NoLockers: the number of the lockers, *lockers: the lockers
 * Function: Prints the current state of all the lockers (0: closed, 1:open)
 */
void PrintData(int NoLockers, int *lockers)
{
    int i;

    // start printing
    for(i=0;i<NoLockers;i++)
        printf ("%d", lockers[i]);
    printf ("\n");
}
