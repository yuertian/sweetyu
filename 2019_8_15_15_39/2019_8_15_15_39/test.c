#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>


void Judge_huiwen(char *str)
{
	char *left = str;
	char *right = str;
	int len = 0;
	int count = 0;
	while (str)
	{
		right++;
		len++;
	}
	while (left < right)
	{
		if (*left == *right)
		{
			count++;
			left++;
			right--;
		}
	}
	if (len/2 == count)
		printf("shi\n");
	else
		printf("bushi\n");
}


int main()
{
	char* str="12321";
	Judge_huiwen(str);
	system("pause");
	return 0;
}