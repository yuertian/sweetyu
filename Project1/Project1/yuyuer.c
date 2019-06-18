#include<stdio.h>
#include<stdlib.h>
int main()
{
	int year;
	printf("1000-2000年之间的闰年有：");
	for (year = 1000; year <= 2000;year++)
	{
		if(year%4==0&&year%100!=0||year%400==0)
		{
			printf("%d\n",year);
		}
	}
		system("pause");
		return 0;
}
