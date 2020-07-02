package io.imfast.webrwd.model;

public class Comment extends Abstract<Comment> {
	private Long CommentID;
	private Long UserID;
	private String Content;
	private Long ItemID;
	public Long getCommentID() {
		return CommentID;
	}
	public void setCommentID(Long commentID) {
		CommentID = commentID;
	}
	public Long getUserID() {
		return UserID;
	}
	public void setUserID(Long userID) {
		UserID = userID;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Long getItemID() {
		return ItemID;
	}
	public void setItemID(Long itemID) {
		ItemID = itemID;
	}
	
	
	
}
