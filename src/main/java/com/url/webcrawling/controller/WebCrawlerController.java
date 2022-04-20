package com.url.webcrawling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.url.webcrawling.dao.WebCrawlerDAO;
import com.url.webcrawling.model.LinksRequest;
import com.url.webcrawling.model.LinksResponse;

@RestController
public class WebCrawlerController {

	@Autowired
	WebCrawlerDAO webCrawlerDAO;
	
	
	@RequestMapping(value = "/crawl", method = RequestMethod.POST)
	public LinksResponse shortenUrl(@RequestBody LinksRequest shortnerData) {
		System.out.println("Long Url : "+shortnerData.getLongUrl());
		return webCrawlerDAO.getAllTheLinks(shortnerData.getLongUrl());
	}
}
