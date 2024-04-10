package com.jrs.mhxytjapp.Utils;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLPullUtils {
    public static List<String> getAllTable(InputStream is) {
        List<String> mStrings = new ArrayList<String>();
        XmlPullParser parser = Xml.newPullParser();
        try {
            parser.setInput(is, "UTF-8");
            int event = 0;
            int i = 1;
            while (event != XmlPullParser.END_DOCUMENT) {
                switch (event) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        if (("tables" + i).equals(parser.getName())) {
                            mStrings.add(parser.nextText());
                            i++;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                event = parser.next();
            }
            event = parser.getEventType();
            return mStrings;
        } catch (Exception e) {
            mStrings = null;
        }
        return mStrings;
    }
}
