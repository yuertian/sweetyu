#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
void menu()
{
	printf("--------------------------\n");
	printf("--------  1����   --------\n");
	printf("--------  0������ --------\n");
	printf("--------------------------\n");
	printf("--------- ��ѡ�� ---------\n");
}
void game()
{
	int guess = 0;
	int ret = 0;
	srand((unsigned int)time(NULL)); //������ں�������Ҳ��ok��ѽ
	ret = rand() % 100 + 1;
	while (1)
	{
		printf("����Ҫ�µ�����\n");
		scanf("%d", &guess);
		if (guess > ret)
		{
			printf("�´���\n");
		}
		else if (guess < ret)
		{
			printf("��С��\n");
		}
		else
		{
			printf("�¶���\n");
			break;
		}
	}

}
int main()
{
	int input = 0;
	do{
		menu();
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("�˳���Ϸ");
			break;
		default:
			printf("�����������������");
			break;
		}
	} while (input);
	system("pause");
	return 0;
}
