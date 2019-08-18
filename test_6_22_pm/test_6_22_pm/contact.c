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
		printf("通讯录满了，加不了筽\n");
		return;
	}
	printf("输入姓名:");
	scanf("%s", pCon->per[pCon->usedSize].name);

	printf("输入年龄:");
	scanf("%d", &(pCon->per[pCon->usedSize].age));

	printf("输入电话:");
	scanf("%s", pCon->per[pCon->usedSize].tele);

	printf("输入地址:");
	scanf("%s", &pCon->per[pCon->usedSize].addr);

	printf("输入性别:");
	scanf("%s", &pCon->per[pCon->usedSize].sex);
	printf("添加成功！\n");
	(pCon->usedSize)++;
}
int SearchContact(Contact* pCon)
{
	char name[MAX_NAME] = { 0 };
	printf("请输入姓名:");
	scanf("%s", name);
	int i = 0;
	if (pCon->usedSize == 0)
	{
		printf("通讯录为空\n");
		return -1;
	}
	else
	{
		for (i = 0; i < pCon->usedSize; i++)
		{
			if (strcmp(name, pCon->per[i].name) == 0)
			{
				printf("%-20s%-10s%-10s%-11s%-15s\n", "姓名", "性别", "年龄", "电话", "地址");
				printf("%-20s%-10s%-10d%-11s%-15s\n", pCon->per[i].name, pCon->per[i].sex, pCon->per[i].age, pCon->per[i].tele, pCon->per[i].addr);
				return 0;
			}
		}
		printf("没这个人\n");
		return -1;
	}
}

void DelContact(Contact* pCon)
{
	char name[MAX_NAME];
	printf("请输入姓名:");
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
			printf("删除成功\n");
			return;
		}
	}
	printf("查无此人\n");
}

void ShowContact(Contact* pCon)
{
	assert(pCon != NULL);
	printf("%-20s%-10s%-10s%-11s%-15s\n", "姓名", "性别", "年龄", "电话", "地址");
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
	printf("清除成功\n");
}


void SortContact(Contact* pCon)
{
	PersonInfo *q, *p, *pCon = pCon->next;
	if (pCon == NULL)
	{
		printf("通讯录为空，请增加信息\n");
		return;
	}
	PersonInfo temp = {0};
	while (pCon)
	{
		int i = 0;
		int j = 0;
		p = pCon;
		q = pCon->per;
		PersonInfo *tmp;//用于排序时暂存节点  
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
	printf("排序后的学生信息是：\n");
	ShowContact(pCon);
}