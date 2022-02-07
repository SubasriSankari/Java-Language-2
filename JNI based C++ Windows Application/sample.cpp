#include <stdio.h>
#include <iostream>
#include <string>

using namespace std;

int main(){

	//string id = "4624";
	//system(("wevtutil qe security \"/q:*[System[EventID="+id+"]]\" /f:text /rd:true").c_str()); 
	//system("%id%");
	string fromDate = "2021-12-15T00:00:00";
	string toDate = "2021-12-15T23:59:59";
	cout<<"this is login";
	string cmd = "wevtutil qe security \"/q:*[System[TimeCreated[@SystemTime >='"+fromDate+"' and @SystemTime <'"+toDate+"']]] and *[System[EventID=4624]]\" /f:text /rd:true";
	//cout<<cmd;
	system(cmd.c_str());

}