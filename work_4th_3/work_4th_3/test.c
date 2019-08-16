#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

unsigned int Count(unsigned int n) {
	int num = 0;
	while (n > 0) {
		num++;
		n &= (n - 1);
	}
	return num;
}

int main()
{
	int n = 0;
	scanf("%d", &n);
	int ret = Count(n);
	printf("%d", ret);
	system("pause");
	return 0;
}