#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include <string.h>
#include<math.h>
int main()
{
	int a = 0;
	int i = 0;
	int n = 0;
	int Sn = 0;
	scanf("%d", &a);
	for (i = 1; i <= 5; i++)
	{
		n = (n * 10) + a;
		Sn = Sn + n;
	}
	printf("Sn=%d\n", Sn);
	system("pause");
	return 0;
}
