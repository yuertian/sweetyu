#define _CRT_SECURE_NO_WARNINGS 1
#include "contact.h"
/*
1. �����ϵ����Ϣ
2. ɾ��ָ����ϵ����Ϣ
3. ����ָ����ϵ����Ϣ
5. ��ʾ������ϵ����Ϣ
6. ���������ϵ��
7. ����������������ϵ��
8. ������ϵ�˵��ļ�
9. ������ϵ��
*/
void menu()
{
	printf("*********1.add************2.search***********\n");
	printf("*********3.del*************4.show************\n");
	printf("*********5.clear***********6.sort**************\n");
	printf("*********0.exit********************************\n");
}

void start()
{
	int input = 0;
	//��ʼ��ͨѶ¼   ����   usedSize
	Contact con;
	InitContact(&con);
	do
	{
		menu();
		printf("��������Ĳ���>>");
		scanf("%d", &input);
		switch (input)
		{
		case  ADD:
			AddContact(&con);
			break;
		case SEAR:
			SearchContact(&con);
			break;
		case DEL:
			DelContact(&con);
			break;
		case SHOW:
			ShowContact(&con);
			break;
		case CLEAR:
			ClearContact(&con);
			break;
		case SORT:
			SortContact(&con);
			break;
		}
	} while (input);
}

int main()
{
	start();
	return 0;
	system("pause");
}

