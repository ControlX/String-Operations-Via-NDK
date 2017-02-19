LOCAL_PATH := $(call my-dir)
MY_PATH := $(LOCAL_PATH)
include $(call all-subdir-makefiles)
include $(CLEAR_VARS)
LOCAL_PATH := $(MY_PATH)
LOCAL_LDLIBS := -llog
LOCAL_MODULE := MyNativeLibrary
LOCAL_SRC_FILES := MainActivity.c
#LOCAL_SRC_FILES := $(SRCS:$(LOCAL_PATH)/%=%)
include $(BUILD_SHARED_LIBRARY)