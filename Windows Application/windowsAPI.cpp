#include <stdio.h>
#include <iostream>
#include <string>

using namespace std;

int main(){
	cout<<"Hi Please enter to view the event";
	string fromDate = "2021-12-15T00:00:00";
	string toDate = "2021-12-15T12:00:00";
	string XPATH = "*/System/TimeCreated[@SystemTime >='@fromDate%' and @SystemTime <'%toDate%']";
	system("wevtutil qe Security /q:\"*[EventData/@TargetUserName='LENOVO']\" /c:1 /f:text /rd:true /e:event");

}