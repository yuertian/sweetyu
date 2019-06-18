#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int DigitSum(unsigned int n)
{
	int m = 0;
	while(n > 9)
	{
		m = m + (n % 10);
		DigitSum(n / 10);
	}
	return m;
}
int main()
{
	unsigned int n = 0;
	int ret = 0;
	printf("n=");
	scanf("%d", &n);
	ret = DigitSum(n);
	printf("power=%d\n",ret);
	system("pause");
	return 0;
}
