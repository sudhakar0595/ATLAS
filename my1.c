#include<stdio.h>
#include<unistd.h>
#include<fcntl.h>
#include<string.h>
#include<stdlib.h>


void shell()
{
	char cwd[1024];
	getcwd(cwd, sizeof(cwd));
	printf("sudhakar@sudhakar-Virtualbox:~%s$", cwd);
}

void mycat(char *u)
{
	int fda = 0;
        int len = 0;
        char buf[100000];
        char *cmd, *f1;
        cmd = strtok(u, " ");
        f1 = strtok(NULL, " ");
        fda = open(f1, O_RDONLY);
        if(fda == 0)
        {
                printf("\n%s : Fils doesn't exist", f1);
        }
        len = lseek(fda, 0, SEEK_END);
        lseek(fda, 0, SEEK_SET);
        read(fda, buf, len);
        printf("%s\n",buf);
        close(fda);
        return;
}

void myhead(char *u)
{
        printf("Displaying first 5 lines of the file\n");

        char *cmd, *f1;
        cmd = strtok(u, " ");
        f1 = strtok(NULL, " ");

        FILE *fp;
        char *line = NULL;
        size_t len  = 0;
        int count = 0;

        fp = fopen(f1,"r");

        // checking for file existency
        if( fp == NULL )
        {
                printf("\n%s : Files doesn't exist\n",f1);
                return;
        }

        // read lines from file one by one
        while (getline(&line, &len, fp) != -1)
        {
                count++;
                if (count>5)
                        break;

                printf("%s",line); fflush(stdout);
        }

        // close file
        fclose(fp);
        return;
}

void mytail(char *u)
{
        printf("Displaying last 5 lines of the file\n");

        char *cmd, *f1;
        cmd = strtok(u, " ");
        f1 = strtok(NULL, " ");

        FILE *fp, *fp1;
        char *line = NULL;
        size_t len  = 0;
        int count1 = 0;
        int count2 = 0;
        fp = fopen(f1,"r");

        // checking for file existency
        if( fp == NULL )
        {
                printf("\n%s : Files doesn't exist\n",f1);
                return;
        }

        // read lines from file one by one
        while (getline(&line, &len, fp) != -1)
        {
                count1++;
        }
        fclose(fp);
        fp1 = fopen(f1, "r");
        while (getline(&line, &len, fp1) != -1)
        {
                count2++;
                if(count2>(count1-5))
                        printf("%s", line); fflush(stdout);
        }

        // close file
        fclose(fp1);
        return;

}

void mycp(char *u)
{
        printf("this is my copy\n");
        char *cmd, *f1, *f2;
        char c;
        cmd = strtok(u, " ");
        f1 = strtok(NULL, " ");
        f2 = strtok(NULL, " ");

        FILE *fda, *fdb;

        fda = fopen(f1,"r");
        //perror("Error");
        //printf("%s\n",c);
        fdb = fopen(f2,"w");
        //perror("Error");
        c = fgetc(fda);
        while (c != EOF)
        {
                fputc(c,fdb);
                c = fgetc(fda);
        }

        fclose(fda);
        fclose(fdb);
        return;
}

void mymv(char *u)
{
        printf("this is my move\n");
        char *cmd, *f1, *f2;
        char c;
        cmd = strtok(u, " ");
        f1 = strtok(NULL, " ");
        f2 = strtok(NULL, " ");

        FILE *fda, *fdb;

        fda = fopen(f1,"r");
        //perror("Error");
        //printf("%s\n",c);
        fdb = fopen(f2,"w");
        //perror("Error");
        c = fgetc(fda);
        while (c != EOF)
        {
                fputc(c,fdb);
                c = fgetc(fda);
        }
        remove(f1);
        fclose(fda);
        fclose(fdb);
        return;
}
void myrm(char *u)
{
	printf("this is my remove\n");
	char *cmd, *f1;
	FILE *fda;
	cmd = strtok(u, " ");
	f1 = strtok(NULL, " ");
	remove(f1);
        return;
}

void history(char *u)
{
        //int fda =0;
        //char *buf;
        //int len =0;
       // fda = open("history.txt", O_RDONLY);
        //len = lseek(fda, 0 , SEEK_END);
        //lseek(fda, 0, SEEK_SET);
        //read(fda, buf, len);
        //printf("%s\n", buf);
        //return;
	FILE *fp, *fp1;
        char *line = NULL;
        size_t len  = 0;
        int count1 = 0;
	int count2 = 0;

        fp = fopen("history.txt","r");

        // checking for file existency
        if( fp == NULL )
        {
                printf("Internal Error create a history file\n");
                return;
        }

        // read lines from file one by one
        while (getline(&line, &len, fp) != -1)
        {
                count1++;
        }

        // close file
        fclose(fp);
	fp1 = fopen("history.txt","r");
	while(getline(&line,&len,fp1)!= -1)
	{
		count2++;
		if(count2>(count1-51)){
			printf("%s", line); fflush(stdout);
		}
	}
        return;

}

void takeinput()
{
	int fda = 0;
 	char usercmd[100]; 
	char *cmd;
	char usercommand[100];	
	//scanf("%[^\n]%*c", usercmd);
	fgets(usercmd, 100, stdin);
	//perror("Error");
	strtok(usercmd, "\n");
	//printf("%s~~\n",usercmd);
	strcpy(usercommand, usercmd);
	//printf("%d\n",strlen(usercommand));
	fda = open("history.txt",O_WRONLY|O_APPEND);
	lseek(fda,0,SEEK_END);
	write(fda,usercommand,strlen(usercommand));
	write(fda,"\n",1);
	//write(fd, "\n", 2);
	//write(fd, "\n", 1);
	cmd = strtok(usercmd, " ");
	//printf("%s\n",cmd);
	//printf("%s~~\n",usercommand);

	int totalcmd = 8, i, s= 0;
	char* ListOfCmds[totalcmd];

	ListOfCmds[0] = "mycat";
	ListOfCmds[1] = "myhead";
	ListOfCmds[2] = "mytail";
	ListOfCmds[3] = "mycp";
	ListOfCmds[4] = "mymv";
	ListOfCmds[5] = "myrm";
	ListOfCmds[6] = "history";
	ListOfCmds[7] = "exit";

	for (i = 0; i < totalcmd; i++) 
	{
		if (strcmp(cmd, ListOfCmds[i]) == 0) 
		{
			s = i+1;
			break;
		}
	}

	switch(s)
		{
		case 1:
			mycat(usercommand);
			break;
		case 2:
			myhead(usercommand);
			break;
			
		case 3:
			mytail(usercommand);
			break;
		
		case 4:
			mycp(usercommand);
			break;
		
		case 5:
			mymv(usercommand);
			break;
		
		case 6:
			myrm(usercommand);
			break;
		
		case 7:
			history(usercommand);
			break;
		
		case 8:
			exit(0);
			break;
		default:
			printf("Error please enter a valid command");
		}
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
