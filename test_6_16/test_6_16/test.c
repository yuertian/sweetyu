#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>

int Mystrcpy(const char* str1, const char* str2)
{
	
	assert(str1 != NULL&&str2 != NULL);
	while (*str1 == *str2)
	{
		if (str1 == '\0')
		{
			return 0;
		}
			str1++;
			str2++;
	}
	if (*str1>*str2)
	{
		return 1;
	}
	else
	{
		return -1;
	}
}

int main()
{
	char *str1 = "abcdef";
	char *str2 = "cbcdef"; 
	int ret = Mystrcpy(str1,str2);
	printf("%d\n", ret);
	system("pause");
	return 0;
}