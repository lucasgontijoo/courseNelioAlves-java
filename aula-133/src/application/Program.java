package application;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import entities.*;

public class Program {
	public static void main(String[] args) {
		
		String instant = "21/06/2018 13:05:44";
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime moment = LocalDateTime.parse(instant, format);
		
		Post post1 = new Post(moment, "Traveling to New Zeland", "I'm going to visit this wonderful country!", 12);
		Comment c1 = new Comment("Have a nice trip");
		post1.sendComment(c1);
		Comment c2 = new Comment("Wow that's awesome!");
		post1.sendComment(c2);
		
		instant = "28/07/2018 23:14:19";
		moment = LocalDateTime.parse(instant, format);
		Post post2 = new Post(moment, "Good nigth guys", "See you tomorrow", 5);
		Comment c3 = new Comment("Good nigth");
		post2.sendComment(c3);
		Comment c4 = new Comment("May the Force be with you");
		post2.sendComment(c4);
		
		System.out.println(post1);
		System.out.println(post2);
	}
}
