#define _CRT_SECURE_NO_WARNINGS 1
#include"contact.h"

void InitContact(Contact* pCon)
{
	assert(pCon != NULL);
	memset(pCon->per, 0, sizeof(pCon->per));
	pCon->usedSize = 0;
}

void AddContact(Contact* pCon)
{
	if (pCon->usedSize == MAX_NUMPERSON)
	{
		printf("ͨѶ¼���ˣ��Ӳ��˹p\n");
		return;
	}
	printf("��������:");
	scanf("%s", pCon->per[pCon->usedSize].name);

	printf("��������:");
	scanf("%d", &(pCon->per[pCon->usedSize].age));

	printf("����绰:");
	scanf("%s", pCon->per[pCon->usedSize].tele);

	printf("�����ַ:");
	scanf("%s", &pCon->per[pCon->usedSize].addr);

	printf("�����Ա�:");
	scanf("%s", &pCon->per[pCon->usedSize].sex);
	printf("��ӳɹ���\n");
	(pCon->usedSize)++;
}
int SearchContact(Contact* pCon)
{
	char name[MAX_NAME] = { 0 };
	printf("����������:");
	scanf("%s", name);
	int i = 0;
	if (pCon->usedSize == 0)
	{
		printf("ͨѶ¼Ϊ��\n");
		return -1;
	}
	else
	{
		for (i = 0; i < pCon->usedSize; i++)
		{
			if (strcmp(name, pCon->per[i].name) == 0)
			{
				printf("%-20s%-10s%-10s%-11s%-15s\n", "����", "�Ա�", "����", "�绰", "��ַ");
				printf("%-20s%-10s%-10d%-11s%-15s\n", pCon->per[i].name, pCon->per[i].sex, pCon->per[i].age, pCon->per[i].tele, pCon->per[i].addr);
				return 0;
			}
		}
		printf("û�����\n");
		return -1;
	}
}

void DelContact(Contact* pCon)
{
	char name[MAX_NAME];
	printf("����������:");
	scanf("%s", name);
	int j = 0;
	int i = 0;
	for (i = 0; i < pCon->usedSize; i++)
	{
		if (strcmp(name, pCon->per[i].name) == 0)
		{
			for (j = i; j < pCon->usedSize - 1; j++)
			{
				pCon->per[j] = pCon->per[j + 1];
			}
			(pCon->usedSize)--;
			printf("ɾ���ɹ�\n");
			return;
		}
	}
	printf("���޴���\n");
}

void ShowContact(Contact* pCon)
{
	assert(pCon != NULL);
	printf("%-20s%-10s%-10s%-11s%-15s\n", "����", "�Ա�", "����", "�绰", "��ַ");
	int i = 0;
	for (i = 0; i < pCon->usedSize; i++)
	{
		printf("%-20s%-10s%-10d%-11s%-15s\n", pCon->per[i].name, pCon->per[i].sex, pCon->per[i].age, pCon->per[i].tele, pCon->per[i].addr);
	}
}

void ClearContact(Contact* pCon)
{
	assert(pCon != NULL);
	memset(pCon->per, 0, sizeof(pCon->per));
	pCon->usedSize = 0;
	/*InitContact(pCon);*/
	printf("����ɹ�\n");
}


void SortContact(Contact* pCon)
{
	PersonInfo *q, *p, *pCon = pCon->next;
	if (pCon == NULL)
	{
		printf("ͨѶ¼Ϊ�գ���������Ϣ\n");
		return;
	}
	PersonInfo temp = {0};
	while (pCon)
	{
		int i = 0;
		int j = 0;
		p = pCon;
		q = pCon->per;
		PersonInfo *tmp;//��������ʱ�ݴ�ڵ�  
		InitContact(tmp);
		for (j = 0; j < pCon->usedSize; j++)
		{
			for (i = 0; i < (pCon->usedSize)-j; i++)
			{
				if (strcmp(pCon->per[i].name, pCon->per[i + 1].name) == 1)
				{
					strcpy(tmp, pCon->per[i].name);
					strcpy(tmp, pCon->per[i].sex);
					strcpy(tmp, pCon->per[i].age);
					strcpy(tmp, pCon->per[i].tele);
					strcpy(tmp, pCon->per[i].addr);

					strcpy(pCon->per[i].name, pCon->per[i + 1].name);
					strcpy(pCon->per[i].sex, pCon->per[i + 1].sex);
					strcpy(pCon->per[i].age, pCon->per[i + 1].age);
					strcpy(pCon->per[i].tele, pCon->per[i + 1].tele);
					strcpy(pCon->per[i].addr, pCon->per[i + 1].addr);

					strcpy(pCon->per[i + 1].name, tmp);
					strcpy(pCon->per[i + 1].sex, tmp);
					strcpy(pCon->per[i + 1].age, tmp);
					strcpy(pCon->per[i + 1].tele, tmp);
					strcpy(pCon->per[i + 1].addr, tmp);
				}
			}
		}
	}
	printf("������ѧ����Ϣ�ǣ�\n");
	ShowContact(pCon);
}