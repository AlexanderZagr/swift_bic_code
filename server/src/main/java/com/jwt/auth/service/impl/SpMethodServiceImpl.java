package com.jwt.auth.service.impl;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service(value = "spService")
public class SpMethodServiceImpl {
    final Logger logger = LoggerFactory.getLogger(SpMethodServiceImpl.class);

    @Value("${service.sp.url}")
    private String m_sUrl;

    private static String sDirSeparator = System.getProperty("file.separator");

    //Файл для тестирования
    public String fileTestDataXml(String sFileName) {
        String result="";
        //определяем полный путь к файлу
        File currentDir=new File(".");
        String sFilePath = null;
        try {
            sFilePath = currentDir.getCanonicalPath() + sDirSeparator + sFileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Stream<String> lines = Files.lines(Paths.get(sFilePath))) {
            result = lines.collect(Collectors.joining(System.lineSeparator()));
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public String InitSpConnect(String testDataXml) {
        String response = null;

        try {
            URL url = new URL(m_sUrl);
            //получили набор параметров для post запроса
            byte[] postDataBytes = testDataXml.getBytes("UTF-8");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0; .NET CLR 1.1.4322)");
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestProperty("Content-Length", Integer.toString(postDataBytes.length));
            conn.setRequestProperty("Accept", "application/xml");
            conn.setUseCaches(false);
            try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
                wr.write(postDataBytes);
            }
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (int c; (c = in.read()) >= 0; ) {
                sb.append((char) c);
            }
            response = sb.toString();
            return response;

        } catch (Exception e) {
            response = "Error " + e;
            return response;
        }

    }


   // public static String convertXMLtoJson( String inputxml) {
     //   String json="";
       // try {
        //    ObjectMapper objectMapper = new XmlMapper();
         //   ObjectMapper jsonMapper = new ObjectMapper();
          //  Employee emp = objectMapper.readValue(inputxml, Employee.class);
           // json =jsonMapper.writeValueAsString(emp);
           // System.out.println(jsonMapper.writeValueAsString(emp));
        //} catch (Exception e) {
         //   e.printStackTrace();
        //}
        //return json;
   // }

}
