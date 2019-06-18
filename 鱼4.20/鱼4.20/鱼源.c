#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
int main()
{
	int sum = 0;
	int i = 0;
	for (i = 1; i <= 100; i++)
	{
		sum = sum + i  (1 / i) * pow(-1, i + 1);
	}
	printf("sum=%d", sum);
	system("pause");
	return 0;
}
