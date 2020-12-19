#include <stdio.h>
#include <sys/socket.h>
#include <stdlib.h>
#include <netinet/in.h>
#include <string.h>
#include <arpa/inet.h>
#include <unistd.h>
#define PORT 8000

void chat(int new_socket){
	char buffer[1024]={0};
    char hello[1024] = {0};
	int valread;

    valread = read(new_socket , buffer, 1024);
    printf("Client: %s\n",buffer );
    printf("Enter the Response Message\n");
    fgets(hello,1024-1,stdin);
    send(new_socket , hello , strlen(hello) , 0 );
    printf("Response sent\n");
}

void file_transfer(int new_socket){
	int val;
	char buffer1[1024]={0};

    val = read(new_socket,buffer1,10240);
    printf("%s\n",buffer1 );
    FILE *fp;
    fp = fopen("new.txt","w");
    fprintf(fp,"%s",buffer1);
}

void calculator(int new_socket){
	int val1,val2,val3,x,y,r=0,c;
	char buffer2[100]={0};
	char buffer3[100]={0};
	char buffer4[100]={0};
	char a[100]={0};
			
	val1 = read(new_socket,buffer2,1024);
		
	c = atoi(buffer2);
	val1 = read(new_socket,buffer3,1024);
		
	x=atoi(buffer3);
		
	val1 = read(new_socket,buffer4,1024);
		
	y=atoi(buffer4);
		
	if(c==1)
	{	
		r = x+y;	
	}
	else if(c==2)
	{
		r = x-y;
	}
	else if(c==3)
	{
		r = x*y;
	}
	else if(c==4)
	{
		r = x/y;
	}
	printf("\n\nResult is: %d\n\n",r);
	sprintf(a, "%d", r);
	send(new_socket , a , strlen(a) , 0 );
}

int main(int argc, char const *argv[])
{
    int server_fd, new_socket, valread, val;
    struct sockaddr_in address;
    int opt = 1;
    int addrlen = sizeof(address);
    char temp[1024]={0};
      
    // Creating socket file descriptor
    if ((server_fd = socket(AF_INET, SOCK_STREAM, 0)) == 0)
    {
        perror("socket failed");
        exit(EXIT_FAILURE);
    }
      
    // Forcefully attaching socket to the port 8080
    if (setsockopt(server_fd, SOL_SOCKET, SO_REUSEADDR | SO_REUSEPORT,
                                                  &opt, sizeof(opt)))
    {
        perror("setsockopt");
        exit(EXIT_FAILURE);
    }
    address.sin_family = AF_INET;
    address.sin_addr.s_addr = INADDR_ANY;
    address.sin_port = htons( PORT );
      
    // Forcefully attaching socket to the port 8080
    if (bind(server_fd, (struct sockaddr *)&address, 
                                 sizeof(address))<0)
    {
        perror("bind failed");
        exit(EXIT_FAILURE);
    }
    if (listen(server_fd, 3) < 0)
    {
        perror("listen");
        exit(EXIT_FAILURE);
    }
    if ((new_socket = accept(server_fd, (struct sockaddr *)&address, 
                       (socklen_t*)&addrlen))<0)
    {
        perror("accept");
        exit(EXIT_FAILURE);
    }

	printf("Waiting for Menu Select...\n");

    valread = read( new_socket , temp, 1024);
    if(strcmp(temp,"1")==0)
    {
		chat(new_socket);
    }
    else if(strcmp(temp,"2")==0)
    {
		file_transfer(new_socket);
    }
    else if(strcmp(temp,"3")==0)
    {
        calculator(new_socket);
    }
    
    return 0;
}
