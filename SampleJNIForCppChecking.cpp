#include <jni.h>
#include "SampleJNIForCppChecking.h"
#include <string.h>
#include <iostream>  
#include <vector>
#include <winevt.h>
#include <windows.h>
#include <Lmcons.h>
#include <stdbool.h>

using namespace std;

void JNICALL Java_SampleJNIForCppChecking_printHello(JNIEnv *env, jobject obj)
{
	bool EvtGetLogInfo(EVT_HANDLE Log, EVT_LOG_PROPERTY_ID PropertyId, DWORD PropertyValueBufferSize, PEVT_VARIANT PropertyValueBuffer, PDWORD PropertyValueBufferUsed );
	TCHAR name [ UNLEN + 1 ];
	DWORD size = UNLEN + 1;

	if(GetUserName( (TCHAR*)name, &size ))
		wcout << L"Hello, " << name << L"!\n";
	else
		cout << "Hello, unnamed person!\n";
	cout<<"hello welcome to jni with C++";
}