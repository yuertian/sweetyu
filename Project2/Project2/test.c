#include<stdio.h>
#include<stdlib.h>


int main()
{
	int i = 10;
	long long t = sizeof(i++);
	printf("%d\n",i);
	system("pause");
	return 0;
}