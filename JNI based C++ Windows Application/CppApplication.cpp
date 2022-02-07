#include <stdio.h>
#include <iostream>
#include <string>
#include <jni.h>
#include "JavaApplication.h"

using namespace std;

JNIEXPORT void JNICALL Java_JavaApplication_basedonDate(JNIEnv *env, jobject obj,jstring date,jboolean status)
{

	const jclass stringClass = env -> GetObjectClass(date);
	const jmethodID getBytes = env -> GetMethodID( stringClass, "getBytes", "(Ljava/lang/String;)[B");
	const jbyteArray stringJbytes = (jbyteArray) env -> CallObjectMethod(date, getBytes, env->NewStringUTF("UTF-8"));
    	size_t length = (size_t) env -> GetArrayLength(stringJbytes);
    	jbyte* pBytes = env -> GetByteArrayElements(stringJbytes, NULL);
    	string strDate = string((char*)pBytes, length);

	string id;
	bool check = (bool) status;

	if(check)
	{	
		id = "4624";
	}
	else
	{
		id = "4634";
	}

	string fromDate = strDate+"T00:00:00";
	string toDate = strDate+"T23:59:59";

	string cmd = "wevtutil qe security \"/q:*[System[TimeCreated[@SystemTime >='"+fromDate+"' and @SystemTime <'"+toDate+"']]] and *[System[EventID="+id+"]]\" /f:text /rd:true /c:10";

	system(cmd.c_str());

}

JNIEXPORT void JNICALL Java_JavaApplication_basedonUser(JNIEnv *env, jobject obj,jstring user,jboolean status)
{

	const jclass stringClass = env -> GetObjectClass(user);
	const jmethodID getBytes = env -> GetMethodID(stringClass, "getBytes", "(Ljava/lang/String;)[B");
	const jbyteArray stringJbytes = (jbyteArray) env -> CallObjectMethod(user, getBytes, env->NewStringUTF("UTF-8"));
    	size_t length = (size_t) env -> GetArrayLength(stringJbytes);
    	jbyte* pBytes = env -> GetByteArrayElements(stringJbytes, NULL);
    	string strUser = string((char*)pBytes, length);

	string id;
	bool check = (bool)status;
	if(check)
	{	
		id = "4624";
	}
	else
	{
		id = "4634";
	}

	string cmd = "wevtutil qe security \"/q:*[EventData[Data[@Name='TargetUserName']='"+strUser+"']] and *[System[EventID="+id+"]]\" /f:text /c:10";
	system(cmd.c_str());

}