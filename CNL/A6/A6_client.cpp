#include <stdio.h>
#include <sys/socket.h>
#include <stdlib.h>
#include <netinet/in.h>
#include <string.h>
#include <arpa/inet.h>
#include <unistd.h> 
#define PORT 8000

void chat(int sock){
	int valread;
	char hello[1024] = {0};
    char buffer[1024] = {0};
    
    printf("\nEnter the message to Send\n");
    fgets(hello,1024-1,stdin);
    send(sock , hello , strlen(hello) , 0 );
    printf("Message sent\n");
    valread = read( sock , buffer, 1024);
    printf("\nServer: %s\n",buffer );
}

void file_transfer(int sock){
    char buffer[1024] = {0};
	char str[1024]={0};
    FILE *fp;
    fp = fopen("text.txt","r");
    while (fgets(buffer, sizeof(buffer), fp)) {
		strcat(str,buffer);
	};
    send(sock,str,strlen(str),0);
    printf("\nFile Sent Successfully\n");
}

void calculator(int sock){
	int valread;
	char op[100]={0};
	char x[100]={0};
	char y[100]={0};
	char buffer3[100]={0};
	printf("\nEnter The Operator: \n1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n\n");
	fgets(op,100-1,stdin);
	send(sock , op , strlen(op) , 0 );
	printf("\nEnter The Operand 1: \n");
	fgets(x,100-1,stdin);
	send(sock , x , strlen(x) , 0 );
	printf("\nEnter The Operand 2: \n");
	fgets(y,100-1,stdin);
	send(sock , y , strlen(y) , 0 );
	valread = read( sock , buffer3, 1024);
	printf("The Result is : %s\n\n",buffer3);	
}

int main(int argc, char const *argv[])
{
    struct sockaddr_in address;
    int sock = 0, valread;
    struct sockaddr_in serv_addr;
    char temp1[1024] = {"1"};
    char temp[1024] = {0};
    char hello[1024] = {0};
    char buffer[1024] = {0};
    char buffer1[10240]={0};
    if ((sock = socket(AF_INET, SOCK_STREAM, 0)) < 0)
    {
        printf("\n Socket creation error \n");
        return -1;
    }
  
    memset(&serv_addr, '0', sizeof(serv_addr));
  
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(PORT);
      
    // Convert IPv4 and IPv6 addresses from text to binary form
    if(inet_pton(AF_INET, "127.0.0.1", &serv_addr.sin_addr)<=0) 
    {
        printf("\nInvalid address/ Address not supported \n");
        return -1;
    }
  
    if (connect(sock, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0)
    {
        printf("\nConnection Failed \n");
        return -1;
    }
    int ch=0;
    printf("\nMenu\n1.Send Message To Server\n2.Transfer File\n3.Calculator\n");
    fgets(temp,1024-1,stdin);
    temp[strcspn(temp, "\n")] = 0; 
    if(strcmp(temp,"1")==0)
    {
		send(sock , temp , strlen(temp) , 0 );
		chat(sock);
    }
    else if(strcmp(temp,"2")==0)
    {
		send(sock , temp , strlen(temp) , 0 );
		file_transfer(sock);
    }
    else if(strcmp(temp,"3")==0)
    {
		send(sock , temp , strlen(temp) , 0 );
		calculator(sock);		
    }
    else
    {
        printf("\n\nEnter The Correct Choice\n\n");
    }
    
    return 0;
}
