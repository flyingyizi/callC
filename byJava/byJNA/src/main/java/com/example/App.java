/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.example;

import com.sun.jna.Pointer;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        LibCurl lib = LibCurl.INSTANCE;

        // CURL *curl; //定义CURL类型的指针
        // CURLcode res; //定义CURLcode类型的变量，保存返回状态码
        // if(argc!=2)
        // {
        // printf("Usage : file <url>;\n");
        // exit(1);
        // }
        if (args.length != 1) {
            System.out.printf("Usage : file <url>; received %d\n", args[0]);
            return;
        }
        // curl = curl_easy_init(); //初始化一个CURL类型的指针
        // if(curl!=NULL)
        // {
        // //设置curl选项. 其中CURLOPT_URL是让用户指 定url. argv[1]中存放的命令行传进来的网址
        // curl_easy_setopt(curl, CURLOPT_URL, argv[1]);
        // //调用curl_easy_perform 执行我们的设置.并进行相关的操作. 在这 里只在屏幕上显示出来.
        // res = curl_easy_perform(curl);
        // //清除curl操作.
        // curl_easy_cleanup(curl);
        // }
        Pointer curl = lib.curl_easy_init();
        if (curl != null) {
            // public static final int CURLOPT_URL = 10000 + 2;
            // com.example.jna.Libcurl4Library.CURLoption.CURLOPT_URL
            lib.curl_easy_setopt(curl, 10000 + 2, args[0]);
            var res = lib.curl_easy_perform(curl);
            lib.curl_easy_cleanup(curl);
        }

    }
}
