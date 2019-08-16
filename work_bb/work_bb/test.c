#include<stdio.h>
#include<stdlib.h>

int My_pow(int x, int y)
{
	int z = 0;
	z = x*y;
	return z;
}

int main()
{
	int a = 4;
	int b = 3;
	int ret = My_pow(a, b);
	printf("%d\n", ret);
	system("pause");
	return 0;
}