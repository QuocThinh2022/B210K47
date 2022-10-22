#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define Max_length 100

typedef char ElementType;
typedef struct{
    ElementType elements[Max_length];
    int Top_inx; // giu vi tri dinh ngan xep
} Stack;

void makenullStack(Stack *pS){
    pS->Top_inx = Max_length;
}

int emptyStack(Stack S){
    return S.Top_inx == Max_length;
}

int full(Stack S){
    return S.Top_inx == 0;
}

ElementType top(Stack S){
    return S.elements[S.Top_inx];
}

void push(ElementType x, Stack *pS){
    if (!full(*pS)){
        pS->elements[pS->Top_inx - 1] = x;
        pS->Top_inx--;
    }
}

void pop(Stack *pS){
    if (!emptyStack(*pS))
        pS->Top_inx++;
}

int precedence(char x){
	switch (x){
		case '=' :
			return 0;
		case '+' :
		case '-' :
			return 1;
		case '*' :
		case '/' :
		case '%' :
			return 2;
		case '^' :
			return 3;
	default :
		return 100;
	}
}

int main(){
    char s[500];

    // nhap chuoi can tinh
    fgets(s, sizeof(s), stdin);
    // xoa enter
    if (s[strlen(s) - 1] == '\n')
        s[strlen(s) - 1] = '\0';

    Stack S;
    makenullStack(&S);

    char BT[500] = "";
    int k = 0;
    for (int i = 0; i < strlen(s); i++){
        // neu la toan hang
        if (s[i] >= '0' && s[i] <= '9'){
            // them vao BT
            BT[k++] = s[i];
		}
        else if (s[i] == '('){
            push('(', &S);
        }
        else if (s[i] == ')'){
            // lap cho den khi tim duoc dau ngoac (
            while (S.elements[S.Top_inx] != '('){
                // lay toan tu ra, them vao BT, roi xoa
                BT[k++] = S.elements[S.Top_inx];
                pop(&S);
            }
            pop(&S);
            //=====================
//	(2 + 3*(5 / (4 - 3) - 3) + 1)
//	2 3 5 4 3 - / 3 - *  + 1 +
            //=======================
        }
		else if (s[i] != ' '){
			while (!emptyStack(S) && S.elements[S.Top_inx] != '(' && (precedence(S.elements[S.Top_inx]) >= precedence(s[i]))){
				BT[k++] = S.elements[S.Top_inx];
				pop(&S);
			}
			push(s[i], &S);
        }        
    }
    
    while (!emptyStack(S)){
        BT[k++] = S.elements[S.Top_inx];
        pop(&S);
    }

    for (int i = 0; i < k; i++)
        printf("%c ", BT[i]);
    
    return 0;
}


// test sdfjd dfgdbfngf
