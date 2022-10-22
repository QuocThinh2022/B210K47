#define MaxLength <n>
typedef <datatype> ElementType;
typedef struct {
	ElementType Elements[MaxLength];
	int Front, Rear;
} Queue;

// Function Prototype
void makenullQueue(Queue* pQ);
int emptyQueue(Queue Q);
int fullQueue(Queue Q);
void enQueue(ElementType x, Queue* pQ);
void deQueue(Queue *pQ);
ElementType front(Queue Q);

// Function 
void makenullQueue(Queue *pQ){
	pQ->Front = -1;
	pQ->Rear = -1;
}

Queue makenullQueue2(){
	Queue Q;
	Q.Front = -1;
	Q.Rear = -1;
	return Q;
}

int emptyQueue(Queue Q){
	return Q.Front == -1;
}

int fullQueue(Queue Q){
	return Q.Rear - Q.Front + 1 == MaxLength; // Logic
}

ElementType front(Queue Q){
	if (emptyQueue(Q)){
		printf("Queue Emptied!\n");
	}
	return Q.Elements[Q.Front];
}

void deQueue1(Queue* pQ){
	if (pQ->Front == -1){
		printf("Error: Queue is emptied, can't delete it\n");
	}
	else{
		pQ->Front++;
		if (pQ->Front > pQ->Rear){
			pQ->Front = pQ->Rear = -1;
		}
	}
}

void deQueue(Queue* pQ){
	if (emptyQueue(*pQ)){
		printf("Error: Queue is emptied, can't delete it\n");
	}
	else{
		pQ->Front++;
		if (pQ->Front > pQ->Rear)
			makenullQueue(pQ);
	}
	
//	if (!emptyQueue(*pQ)){
//		if (pQ->Front == pQ->Rear){
//			makenullQueue(pQ);
//		}
//		else
//			pQ->Front++;
//	}
//	else		
//		printf("Error: Queue is emptied, can't delete it\n");
}

void enQueue(ElementType x, Queue* pQ){
	if (fullQueue(*pQ)){
		printf("Error: Queue is fulled!");
	}
	else{
		if (emptyQueue(*pQ)){
			pQ->Front = 0;
		}
		else if (pQ->Rear == MaxLength - 1){ // Queue not full but bi tran
			for (int i = pQ->Front; i <= pQ->Rear; i++){ // di chuyen Queue ve truoc Front vi tri
				pQ->Elements[i - pQ->Front] = pQ->Elements[i]; 
			}
			pQ->Rear -= pQ->Front; // Rear_new = Rear - Front
			pQ->Front = 0;
		}
		
		pQ->Rear++;
		pQ->Elements[pQ->Rear] = x;
	}
}

// Queue vong
int fullQueue(Queue Q){
	return (Q.Rear - Q.Front + 1) % MaxLength == 0;
}

void deQueue3(Queue *pQ){
	if (!emptyQueue(*pQ)){
		if (pQ->Front == pQ->Rear)
			makenullQueue(pQ);
		else{
			pQ->Front++;
			pQ->Front %= MaxLength;
		}
	}
	else
		printf("Error: Queue is emptied!");
}

void enQueue3(ElementType x, Queue *pQ){
	if (fullQueue(*pQ))
		printf("Error: Queue is fulled!");
	else{
		pQ->Rear++;
		pQ->Rear %= MaxLength;
		pQ->Elements[pQ->Rear] = x;
	}
}
