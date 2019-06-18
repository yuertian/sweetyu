#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
int main()
{
	int i = 0;
	int count = 0;
	for (i = 1; i <= 100; i++)
	{
		if (i %10 == 9)
			count++;
		if (i % 100 > 89 && i % 100 < 99)
			count++;
	}
	printf("count=%d\n",count);
	system("pause");
	return 0;
}