#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(void)
{
	int n = 0;
	int i = 0;
	int f1, f2, f3;
	printf("请输入斐波那契数列的项数：");
	scanf("%d", &n);
	f1 = 1;
	f2 = 2;
	if (1 == n)
	{
		f3 = 1;
	}
	else if (2 == n)
	{
		f3 = 2;
	}
	else
	{
		for (i = 3; i <= n; ++i)
		{
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
	}
	printf("该项对应的斐波那契数列值为：%d\n", f3);
	system("pause");
	return 0;
}