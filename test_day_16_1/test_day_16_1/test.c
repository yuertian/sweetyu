#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<string.h>

char *My_strstr(const char *str1, const char *str2)
{
	assert(str1!=NULL && str2!=NULL);
	const char *cp = str1;
	if (*str2 == '\0')
		return NULL;
	while (*cp)
	{
		char *s1 = cp;
		const char *s2 = str2;
		while (*s1&&*s2&&*s1 == *s2)
		{
			s1++;
			s2++;
		}
		if (*s2 == '\0')
		{
			return cp;
		}
		cp++;
	}
	return NULL;
}


int main()
{
	char *str1 = "abcdefg";
	char *str2 = "d";
	char* ret = My_strstr(str1, str2);
	printf("%s\n", ret);
	system("pause");
	return 0;
}
