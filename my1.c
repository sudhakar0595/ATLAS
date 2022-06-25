#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>
#include<string.h>
#include <readline/readline.h>
#include <readline/history.h>


void shell()
{
	char cwd[1024];
	getcwd(cwd, sizeof(cwd));
	printf("sudhakar@sudhakar-Virtualbox:~%s$", cwd);
}

void takeinput()
{
	int fd = 0;
	char *usercmd[1000];
	char *cmd;
	char *usercommand[1000];	
	gets(usercmd);
	strcpy(usercommand, usercmd);
	fd = open ("history.txt",O_WRONLY);
	write(fd,usercmd,sizeof(usercmd));
	cmd = strtok(usercmd, " ");
	//printf("%s\n",cmd);
	//printf("%s\n",usercommand);

	int totalcmd = 6, i, switchOwnArg = 0;
	char* ListOfOwnCmds[totalcmd];

	ListOfOwnCmds[0] = "mycat";
	ListOfOwnCmds[1] = "myhead";
	ListOfOwnCmds[2] = "mytail";
	ListOfOwnCmds[3] = "mycp";
	ListOfOwnCmds[4] = "mymv";
	ListOfOwnCmds[5] = "myrm";

	for (i = 0; i < totalcmd; i++) 
	{
		if (strcmp(cmd, ListOfOwnCmds[i]) == 0) 
		{
			switchOwnArg = i + 1;
			break;
		}
	}

	switch(switchOwnArg)
		{
		case 1:
			mycat(usercommand);
			break;
		case 2:
			myhead();
			break;
			
		case 3:
			mytail();
			break;
		
		case 4:
			mycp();
			break;
		
		case 5:
			mymv();
			break;
		
		case 6:
			myrm();
			break;

		default:
			printf("Error please enter a valid command");
		}
		return;
}

void mycat(char *u)
{
	//printf("Inside Mycat : %s\n", u);
	int fda = 0;
	char buf[100000];
	char *cmd, *f1;
	cmd = strtok(u, " ");
	//printf("%s\n",cmd);
	f1 = strtok(NULL, " ");
	//printf("%s",f1);
	fda = open(f1, O_RDONLY);
	perror("Error");
	read(fda, buf, 100000);
	printf("%s\n",buf);

	return;
}
void myhead()
{
	printf("this is my head\n");
	return;
}
void mytail()
{
	printf("this is my tail\n");
	return;
}
void mycp()
{
	printf("this is my copy\n");
	return;
}
void mymv()
{
	printf("this is my move\n");
	return;
}
void myrm()
{
	printf("this is my remove\n");
	return;
}


void main()
{
	char command;
	printf("\n\n\nWelcome to the shell\n\n\n");
	while(1)
	{
		shell();
		takeinput();
		
	}
	return;
}
