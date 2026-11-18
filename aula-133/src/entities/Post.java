package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {
	private LocalDateTime moment;
	private String title;
	private String content;
	private int likes;
	
	private List<Comment> comments = new ArrayList<>();
	
	public Post(LocalDateTime moment, String title, String content, int likes) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	public void sendComment(Comment comment) {
		comments.add(comment);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(title + "\n");
		sb.append(likes);
		sb.append(" Likes - " + moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n");
		sb.append(content + "\n");
		sb.append("Comments:" + "\n");
		for(int i = 0; i<comments.size(); i++) {
			sb.append(comments.get(i).getText() + "\n");
		}
		
		return sb.toString();
	}
}
