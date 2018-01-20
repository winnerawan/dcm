#include <jni.h>
#include <string>

extern "C" {
JNIEXPORT jstring JNICALL
Java_id_co_next_1innovation_leaseapp_data_network_AppKey_invokeNativeFunction(JNIEnv *env,
                                                                             jobject instance) {
    return env->NewStringUTF("aHR0cDovL2FwaS5ub3NsZWVwLmlkL2RjbS8=");
}
}

