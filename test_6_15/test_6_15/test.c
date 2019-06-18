#define _CRT_SECURE_NO_WARNINGS 
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<string.h>

char Mystrncmp(char *str1, const char *str2, int n)
{
	int count = 0;
	char *p = str1;
	assert(str1 != NULL&&str2 != NULL);
	while (str1)
	{
		str1++;
	}
	while (count<n)
	{
		*str1++ = *str2++;
		count++;
	}
	str1 = '\0';
	return p;
}

int main()
{
	char str1[10] = "hello";
	char *str2 = "abcde";
	Mystrncmp(str1, str2, 3);
	printf("%s", str1);
	system("pause");
	return 0;
}