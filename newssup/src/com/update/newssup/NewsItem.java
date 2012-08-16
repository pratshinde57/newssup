/* 
* �newssup�- Open Source Android application which shows news updates using 
* Google and BBC News API. User can read as well as listen to the news.     
*
* Copyright (C) 2012  Pratibha Natani
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see <http://www.gnu.org/licenses/>.
*
* Please see the file �License� in this distribution for the license terms. Link is:
* https://github.com/Pnatani/newssup/blob/master/LICENSE.odt
*
* Following is the link for the repository: https://github.com/Pnatani/newssup
* 
* Written by Pratibha Natani <pnatani@pdx.edu>
* 
* References: (Detailed references at the end of the page)
* -Tutorial by IBM on building a mobile RSS Reader.
* https://www.ibm.com/developerworks/xml/tutorials/x-androidrss/
* This tutorial introduces XML handling on the Android platform. 
* It demonstrates  you'll build out the important elements which are relevant to XML handling and rendering on the Android platform.
*
* -Taken inspiration from below link for implementing XMLParsing:
* http://code.google.com/p/krvarma-android-samples/
* 
* -Application is powered by Google News API.  
* http://support.google.com/news/bin/answer.py?hl=en&answer=59255
* 
* -Application is powered by BBC News API. 
* http://www.bbc.co.uk/news/10628494
*
*/


package com.update.newssup;

import android.os.Parcel;
import android.os.Parcelable;

public class NewsItem implements Parcelable{
        public String title;
        public String date;
        public String link;
        
        public NewsItem (String t, String d, String l)
        {
        	title=t;
        	date=d;
        	link=l;
        }
        
        public NewsItem (Parcel in)
        {
             title = in.readString ();
             date = in.readString ();
             link = in.readString ();
        }
        
        public NewsItem() {
        	
        }

		public static final Parcelable.Creator<NewsItem> CREATOR
        = new Parcelable.Creator<NewsItem>() 
       {
             public NewsItem createFromParcel(Parcel in) 
             {
                 return new NewsItem(in);
             }

             public NewsItem[] newArray (int size) 
             {
                 return new NewsItem[size];
             }
        };
       
        
		public int describeContents ()
        {
            return 0;
        }

        public void writeToParcel (Parcel dest, int flags)
        {
            dest.writeString (title);
            dest.writeString (date);
            dest.writeString (link);
        }
}

/*
*  Reference details:
*  
* 1) https://www.ibm.com/developerworks/xml/tutorials/x-androidrss/
* This tutorial introduces XML handling on the Android platform. 
* This tutorial is explains following sections:
* RSS basics
* Android RSS reader application architecture
* Fetching and parsing XML data with SAX
* Rendering RSS data in Android
* 
* 2) http://code.google.com/p/krvarma-android-samples/
* This site has various sample Android applications which have helped me in coding
* in Android, including RSS Parsing. 
* 
* 3) Application is powered by Google News API.  
* http://support.google.com/news/bin/answer.py?hl=en&answer=59255
* In an effort to provide our users with easier access to updates about news topics 
* of interest to them, we offer RSS feeds of Google News. Feeds are available for 
* any section of Google News (such as Sports or Business), for your Google News 
* search results, or for your customized Google News page. When you subscribe to a 
* Google News feed using a feed reader, you'll receive a regularly updated summary 
* of relevant news articles along with links to the full articles. 
* Google News feeds are available in RSS 2.0 format.
* 
* 4) Application is powered by BBC News API. 
* http://www.bbc.co.uk/news/10628494
* BBC News provides feeds for both the desktop website as well as for our mobile 
* site and the most popular feeds are listed here.
*/
