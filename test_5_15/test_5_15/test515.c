#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int print(int n)
{
	if (n > 9)
	    print(n / 10);
	printf("%d\n", n % 10);
}
int main()
{
	int n = 0;
	printf("n=");
	scanf("%d", &n);
	print(n);
	system("pause");
	return 0;
}
