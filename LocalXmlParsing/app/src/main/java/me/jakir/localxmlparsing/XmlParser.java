package me.jakir.localxmlparsing;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class XmlParser {
    private List<Food> foods= new ArrayList<Food>();
    private Food food;
    private String text;



    public List<Food> parse(InputStream is) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser  parser = factory.newPullParser();

            parser.setInput(is, null);

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("food")) {
                            // create a new instance of food
                            food = new Food();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase("food")) {
                            // add food object to list
                            foods.add(food);
                        }else if (tagname.equalsIgnoreCase("name")) {
                            food.setName(text);
                        } else if (tagname.equalsIgnoreCase("price")) {
                            food.setPrice(text);
                        } else if (tagname.equalsIgnoreCase("description")) {
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