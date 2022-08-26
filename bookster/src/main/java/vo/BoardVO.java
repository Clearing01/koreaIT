package vo;

public class BoardVO {

	private int bid;
	private String btitle;
	private String bcontent;
	private String bdate;
	private String mid;
	private int lid;
	private int bcnt; // 페이징 처리를 위한 변수
	
	
	public int getBcnt() {
		return bcnt;
	}
	public void setBcnt(int bcnt) {
		this.bcnt = bcnt;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	@Override
	public String toString() {
		return "BoardVO [bid=" + bid + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bdate=" + bdate + ", mid="
				+ mid + ", lid=" + lid + ", bcnt=" + bcnt + "]";
	}
	
	
	
}
