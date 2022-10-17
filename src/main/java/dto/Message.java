package dto;

import java.util.Date;

public class Message {
	
	private int messageNo;
	private String receiverName;
	private int division;
	private Date msgDate;
	private String msgContent;
	private String senderNBame;
	private int memberNo;
	
	public Message() {
	}

	public Message(int messageNo, String receiverName, int division, Date msgDate, String msgContent,
			String senderNBame, int memberNo) {
		super();
		this.messageNo = messageNo;
		this.receiverName = receiverName;
		this.division = division;
		this.msgDate = msgDate;
		this.msgContent = msgContent;
		this.senderNBame = senderNBame;
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "Message [messageNo=" + messageNo + ", receiverName=" + receiverName + ", division=" + division
				+ ", msgDate=" + msgDate + ", msgContent=" + msgContent + ", senderNBame=" + senderNBame + ", memberNo="
				+ memberNo + "]";
	}

	public int getMessageNo() {
		return messageNo;
	}

	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public int getDivision() {
		return division;
	}

	public void setDivision(int division) {
		this.division = division;
	}

	public Date getMsgDate() {
		return msgDate;
	}

	public void setMsgDate(Date msgDate) {
		this.msgDate = msgDate;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public String getSenderNBame() {
		return senderNBame;
	}

	public void setSenderNBame(String senderNBame) {
		this.senderNBame = senderNBame;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
}
