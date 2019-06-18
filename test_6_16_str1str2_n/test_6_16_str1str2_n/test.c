#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>

char *Mystrcpy(char* str1, const char* str2, int n)
{
	char *p = str1;
	int count = 0;
	assert(str1 != NULL&&str2 != NULL);
	while (*str1 != '\0')
	{
		str1++;
	}
	while (count < n)
	{
		*str1++ = *str2++;
		count++;
	}
	return p;
}

int main()
{
	char str1[10] = "abcd";
	char *str2 = "efg";
	Mystrcpy(str1, str2, 2);
	printf("%s\n", str1);
	system("pause");
	return 0;
}