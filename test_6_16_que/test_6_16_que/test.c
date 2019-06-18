#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>

void left_move(char *str, int k)
{
	char arr[10] = { 0 };
	char* p = arr;
	int count = 0;
	while (count < k)
	{
		str++;
		count++;
	}
	while (str)
	{
		*p++ == *str++;

	}


}

int main()
{
	char str = "abcdef";
	left_move(char *str, 3);
	printf("%s\n", str);
	system("pause");
	return 0;
}