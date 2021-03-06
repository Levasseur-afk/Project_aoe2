package com.example.project_aoe2.Tools;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetRawData {
    private String mRawUrl;
    private IProcessRawData context;

    public GetRawData(String url, IProcessRawData context){
        this.mRawUrl = url;
        this.context = context;
    }

    // Starter of the AsyncTask
    public void startDownload(){
        DownloadRawData downloadRawData = new DownloadRawData();
        downloadRawData.execute(this.mRawUrl);
    }
    // Long task => get data from website
    class DownloadRawData extends AsyncTask<String, Void, String> {

        // once the downloading has ended, the json string data is sent
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            context.processRawData(result);
        }

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            StringBuffer buffer = null;
            try {
                URL url = new URL(params[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                if(inputStream == null){
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                buffer = new StringBuffer();
                while((line = reader.readLine()) != null){
                    buffer.append(line + "\n");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally{
                if(urlConnection != null){
                    urlConnection.disconnect();
                }
                if(reader != null){
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return buffer.toString();
        }
    }
    public interface IProcessRawData{
        public void processRawData(String json);
    }
}