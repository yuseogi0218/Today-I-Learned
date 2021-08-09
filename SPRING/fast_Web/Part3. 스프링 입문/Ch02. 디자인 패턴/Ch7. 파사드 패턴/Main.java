package com.company.design;

import com.company.design.facade.Ftp;
import com.company.design.facade.Reader;
import com.company.design.facade.SftpClient;
import com.company.design.facade.Writer;
public class Main {

    public static void main(String[] args) {
     
        /**
         * Facade
         */
        //facade 이용 안하고 client 에게 의존해있는 상황
        Ftp ftpClient = new Ftp("www.foo.co.kr", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();

        // facade 이용
        SftpClient sftpClient = new SftpClient("www.foo.co.kr", 22, "/home/etc", "text.tmp");
        sftpClient.connect();

        sftpClient.read();

        sftpClient.write();
        
        sftpClient.disConnect();

    }

    //콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();

    }
}
