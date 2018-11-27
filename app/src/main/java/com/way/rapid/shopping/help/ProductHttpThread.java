package com.way.rapid.shopping.help;

import com.way.rapid.shopping.bean.HttpMethod;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProductHttpThread extends Thread{
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public void run() {
        try {
            URL url = new URL("http://192.168.22.2:8080/shopping/product");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(HttpMethod.GET.toString());
            httpURLConnection.setReadTimeout(5000);
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            String tmp = "";
            while ((tmp = bufferedReader.readLine()) != null){
                stringBuffer.append(tmp);
            }
            setResult(stringBuffer.toString());
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
