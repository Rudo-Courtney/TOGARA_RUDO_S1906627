package com.example.togara_rudo_s1906627.my_RSS;

/* Rudo Courtney Togara
 * S1906627
 * Mobile Platform Development Coursework 1
 * */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.togara_rudo_s1906627.my_DataObject.Roadwork;
import com.example.togara_rudo_s1906627.my_UI.CustomAdapter;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RSSParser extends AsyncTask<Void,Void,Boolean> {

    Context c;
    InputStream is;
    ListView lv;

    ProgressDialog pd;
    public static ArrayList<Roadwork> roadworkList = new ArrayList<>();

    public RSSParser(Context c, InputStream is, ListView lv) {
        this.c = c;
        this.is = is;
        this.lv = lv;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        pd= new ProgressDialog(c);
        pd.setTitle("Parse Roadwork");
        pd.setMessage("Parsing Roadwork Data...");
        pd.show();
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        return this.parseRSS();

    }

    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);
        pd.dismiss();

        if(isParsed){
            lv.setAdapter(new CustomAdapter(c, roadworkList));
        }else{
            Toast.makeText(c, "Cannot parse", Toast.LENGTH_SHORT).show();
        }
    }
    private Boolean parseRSS(){

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();

            parser.setInput(is, null);
            int event=parser.getEventType();

            String value=null;
            Boolean isSiteMeta = true;

            roadworkList.clear();
            Roadwork roadwork = new Roadwork();

            do{
                String name = parser.getName();

                switch(event)
                {
                    case XmlPullParser.START_TAG:
                        if(name.equals("item")){
                            roadwork=new Roadwork();
                            isSiteMeta = false;
                        }
                        break;

                    case XmlPullParser.TEXT:
                        value = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if(!isSiteMeta){
                        if(name.equals("title")){
                            roadwork.setTitle(value);

                        }
                        else if(name.equals("description")){
                            roadwork.setDescription(value);

                        }else if(name.equals("road")){
                            roadwork.setRoad(value);

                        }else if(name.equals("region")){
                            roadwork.setRegion(value);

                        }else if(name.equals("pubDate")){
                            roadwork.setPubDate(value);
                        }
                        }
                        if(name.equals("item")) {
                            roadworkList.add(roadwork);
                            isSiteMeta = true;
                        }
                        break;
                }

                event = parser.next();

            }
            while(event != XmlPullParser.END_DOCUMENT);
            return true;
        }
        catch(XmlPullParserException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }




}
