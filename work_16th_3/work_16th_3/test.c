#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int My_pow(int x, int y)
{
	int pow = x;
	int i = 0;
	for (i = 1; i < y; i++)
	{
		pow = pow*x;
	}
	return pow;
}

int main()
{
	int a = 2;
	int b = 3;
	int ret = My_pow(a, b);
	printf("%d", ret);
	system("pause");
	return 0;
}