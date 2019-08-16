#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>


char FindChar(char* str){
	char a[256] = { 0 };
	char* tmp = str;
	while (*str)
	{
		a[*str]++;
		str++;
	}
	str = tmp;
	while (*str)
	{
		if (a[*str] >= 2){
			return *str;
		}
		str++;
	}
	return 0;
}
int main(){
	char str[] = "qwyyer23td";
	char c = FindChar(str);
	if (c){
		printf("%c\n", c);
	}
	else {
		printf("Œ¥’“µΩ\n");
	}
	system("pause");
	return 0;
}