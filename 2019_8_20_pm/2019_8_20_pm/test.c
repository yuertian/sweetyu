#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<string.h>



int JudgeHuiwenStr(char *str)
{
	char strN[10] = { 0 };
	char *p = str;
	char *q = strN;
	char *s = strN;
	int count = 0;
	int len = 0;
	assert(str != NULL);
	while (*str != '\0')
	{
		p++;
		len++;
	}
	while (*p != '\0')
	{
		*q++ = --*p;
	}
	*q = '\0';
	while (*p != '\0')
	{
		if (*p == *s)
		{
			count++;
		}
		p++;
		s++;
	}
	if (count == len)
	{
		return 1;
	}
	else
	{
		return 0;
	}
}

int main()
{
	char *str = "1234321";
	int ret = JudgeHuiwenStr(str);
	printf("%d\n", ret);
	system("pause");
	return 0;
}



//char *DeleteRepeate(char *str1, char *str2)
//{
//	char arr[256] = { 0 };
//	char *p = str1;
//	char *q = str2;
//	while (*str2 != '\0')
//	{
//		arr[*str2] = 1;
//		str2++;
//	}
//	while (*p != '\0')
//	{
//		if (arr[*p] == 1)
//		{
//			*q++ = *p;
//		}
//		p++;
//	}
//	*q = '\0';
//	return str1;
//}
//
//int main()
//{
//	char str1[] = "welcome to cvte";
//	char *str2 = "come";
//	printf("%s", DeleteRepeate(str1, str2));
//	system("pause");
//	return 0;
//}