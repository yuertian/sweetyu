#define _CRT_SECURE_NO_WARNINGS 
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<string.h>

void reserve(char *left, char *right)
{
	assert(left && right);
	while (left < right)
	{
		int temp = *left;
		*left = *right;
		*right = temp;
		left++;
		right--;
	}
}

void left_move(char *str, int k)
{
	int len = strlen(str);
	reserve(str, str + k - 1);
	reserve(str + k, str + len - 1);
	reserve(str, str + len - 1);
}

int main()
{
	char str[] = "ABCD";
	int k = 0;
	printf("左旋前%s\n",str);
	printf("输入要左旋的字符数：");
	scanf("%d", k);
	left_move(str, k);
	printf("左旋后%s",str)
	system("pause");
	return 0;
}