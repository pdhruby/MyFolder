package kr.human.json;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@Data
@XmlRootElement(name="rss")
public class Rss {
	private Channel channel;
	@Data
	@XmlRootElement
	@XmlType(propOrder = {"title","link","lastBuildDate","item"})
	public static class Channel{
		private String title;
		private String link;
		private String lastBuildDate;
		private List<Item> item;
	}
	@Data
	@XmlRootElement
	public static class Item{
		private String title;
		private String link;
		private String author;
		private String pubDate;
		private String image;
	}
}
