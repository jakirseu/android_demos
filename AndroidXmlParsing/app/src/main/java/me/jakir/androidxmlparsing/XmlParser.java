package me.jakir.androidxmlparsing;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


public class XmlParser {

    public static List<Food> parse(String content) {

        List<Food> foods= new ArrayList<Food>();
        Food food = null;
        String text ="";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser  parser = factory.newPullParser();

            parser.setInput(new StringReader(content));

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagName.equalsIgnoreCase("food")) {
                            // create a new instance of food
                            food = new Food();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagName.equalsIgnoreCase("food")) {
                            // add food object to list
                            foods.add(food);
                        }else if (tagName.equalsIgnoreCase("name")) {
                            food.setName(text);
                        } else if (tagName.equalsIgnoreCase("price")) {
                            food.setPrice(text);
                        } else if (tagName.equalsIgnoreCase("description")) {
                            food.setDescription(text);
                        }
                        break;

                    default:
                        break;
                }
                eventType = parser.next();
            }

        } catch (XmlPullParserException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}

        return foods;
    }
}