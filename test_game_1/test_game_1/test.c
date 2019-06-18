#define _CRT_SECURE_NO_WARNINGS 1
#include"game.h"
double start, finish;

void muen()
{
	printf("*******************************\n");
	printf("***********  1.play  **********\n");
	printf("***********  0.exit  **********\n");
	printf("*******************************\n");
}

void game()
{

	int ret = 0;
	init_mine();//��ʼ������
	set_mine();//����
	print_mine();//��ӡ��������
	printf("\n");
	print_player();//��ӡ�������
	start = clock();
	safe_mine();//�����һ�α�ը��

	if (count_show_mine() == COUNT)
	{
		print_mine();
		printf("���Ӯ��\n\n");
		return;
	}
	print_player();

	while (1)
	{
		int ret = sweep_mine();//ɨ��,�ȵ��׷���1��û�вȵ��׷���0
		if (count_show_mine() == COUNT)//����ʾ��*����Ϊ����ʱ�����Ӯ
		{
			print_mine();//��ӡ��������
			printf("���Ӯ��\n\n");
			finish = clock();//���ʱ��
			printf("��ʱ%d ��\n", (int)(finish - start) / CLOCKS_PER_SEC);
			break;
		}
		if (ret)//�ж��Ƿ�ȵ���
		{
			printf("����ը��\t");
			finish = clock();//���ʱ��
			printf("��ʱ%d ��\n", (int)(finish - start) / CLOCKS_PER_SEC);
			print_mine();//�鿴�׵ķֲ�
			break;
		}
		print_player();//��ӡ�������
	}
}


int main()
{
	srand((unsigned int)time(NULL));
	int input = 0;
	muen();
	do
	{
		scanf("%d", &input);
		switch (input)
		{
		case 1:game();
			break;
		case 0:exit(1);
			break;
		default:
			printf("���������������\n");
			break;
		}
		muen();
		printf("contiue?\n");
	} while (1);
	system("pause");
	return 0;
}
