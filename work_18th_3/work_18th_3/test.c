#define _CRT_SECURE_NO_WARNINGS

#include<stdio.h>
#include<stdlib.h>

int My_Judgement(int n)//µ›πÈ µœ÷  14
{
	int m = My_Judgement(n)/2;
	int j = My_Judgement(n) % 2;
	if (m == 1 && j == 0)
		return 1;
	else
		return 0;
}

int main()
{
	int n = 0;
	scanf("%d", &n);
	int ret = My_Judgement(n);
	if (ret == 1)
		printf("YES!\n");
	else
	printf("NO..\n");
	system("pause");
	return 0;
}