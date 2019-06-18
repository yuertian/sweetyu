#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
int print_num(unsigned int m,unsigned int n)
{
	int count = 0;
	int r = m^n;
	while (r)
	{
		if (r & 1 == 1)
		{
			count++;
		}
		r = r >> 1;
	}
	return count;
}
int main()
{
	int m = 1999;
	int n = 2299;
	int ret = print_num(m, n);
	printf("%d\n", ret);
	system("pause");
	return 0;
}
