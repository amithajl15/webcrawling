package com.url.webcrawling.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.url.webcrawling.dao.WebCrawlerDAO;
import com.url.webcrawling.model.LinksResponse;


@Service
public class WebCrawlerImpl implements WebCrawlerDAO {
	  Set<String> urlLink = new HashSet<String>();  
	@Override
	public LinksResponse getAllTheLinks(String url)  {
		
		if (!urlLink.contains(url)) {   
			try {  
			                // if the URL is not present in the set, we add it to the set  
			if (urlLink.add(url)) {   
		System.out.println(url);
			}
	Document doc = Jsoup.connect(url).get();  
    Elements availableLinksOnPage = doc.select("a[href]");   
  for (Element ele : availableLinksOnPage) {   
	getAllTheLinks(ele.attr("abs:href"));   
    }   
}   
			
			catch (IOException e) {   
			    // print exception messages  
			System.err.println("For '" + url + "': " + e.getMessage());   
			            }   
	
		}
	       
    
		 LinksResponse links=new LinksResponse();
		links.setLinks(urlLink);
		return links;
		
	}
}
