package com.example;

import com.sun.jna.Library;
import com.sun.jna.Native;

import com.sun.jna.Pointer;

import com.sun.jna.ptr.PointerByReference;


//  interface-mapped class, dynamically load the C library
public interface LibCurl  extends Library {
    
    /**
     * Make your target library available:
     * 1.set the jna.library.path system property
     * 2.Change the appropriate library access environment variable. PATH on Windows, LD_LIBRARY_PATH on Linux, and DYLD_LIBRARY_PATH on OSX
     * 3.Make your native library available on your classpath, under the path {OS}-{ARCH}/{LIBRARY}
    */     
    LibCurl INSTANCE = (LibCurl) Native.loadLibrary("libcurl-4", LibCurl.class);

    /**
     * Declare methods that mirror the functions in the target library by defining Java methods with the same name and argument types 
     * as the native function
    */
    PointerByReference xyz();
    // CURL_EXTERN CURL *curl_easy_init(void);
    public Pointer curl_easy_init();
    
    // CURL_EXTERN CURLcode curl_easy_setopt(CURL *curl, CURLoption option, ...);
    public int curl_easy_setopt(Pointer curl, int option, Object ... values);

    // CURL_EXTERN CURLcode curl_easy_perform(CURL *curl);
    public int curl_easy_perform(Pointer curl);

    // CURL_EXTERN void curl_easy_cleanup(CURL *curl);
    public void curl_easy_cleanup(Pointer curl);
}