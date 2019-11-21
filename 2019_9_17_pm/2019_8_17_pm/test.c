#define _CRT_SECURE_NO_WARNINGS 1
#include "list.h"


int main()
{
	Node head;
	Node *p = NULL;
	InitList(&head);

	InsertTail(&head, 5);  
	InsertTail(&head, 2);
	InsertTail(&head, 3);
	InsertTail(&head, 4);
    Show(&head);

	InsertNode(&head,3,9);
	Show(&head);


	//p = LastKNode(&head, 4);
	//printf("%d\n", p->data);



	system("pause");
	return 0;
}