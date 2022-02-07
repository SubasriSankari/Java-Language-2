#include <tchar.h>
#include <system.dll>
#include <mscorlib.dll>

using namespace System;
using namespace System::Diagnostics;

int _tmain()
{
    String^ sSource;
    String^ sLog;
    String^ sEvent;

    sSource = gcnew String("dotNET Sample App1");
    sLog = gcnew String("Application1");
    sEvent = gcnew String("Sample Event1");

     if(!EventLog::SourceExists(sSource))
       EventLog::CreateEventSource(sSource,sLog);

    EventLog::WriteEntry(sSource,sEvent);
    EventLog::WriteEntry(sSource, sEvent,
    EventLogEntryType::Warning, 234);
    return 0;
}


/*#include <iostream>
#include <sysinfoapi.h>
#include <chrono>
#include <winbase.h>
#include <winevt.h>
using namespace std;

typedef void* HWND;
int main(){
	/*auto uptime = std::chrono::milliseconds(GetTickCount());
	auto boot_time = std::chrono::system_clock::now() - uptime;
	cout << "Time is "+boot_time;*/


	const char* custom_log_name = "MyLogName";
	HANDLE event_log = RegisterEventSource(NULL, custom_log_name);
	const char* message = "I'm in an event log";
	ReportEvent(event_log, EVENTLOG_SUCCESS, 0, 0, NULL, 1, 0, &message, NULL);
}*/