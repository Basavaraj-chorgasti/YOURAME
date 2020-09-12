package bean;

public class Image {
	
	private int img_id;
	private String img_src;
	private String img_name;
	public int getImg_id() {
		return img_id;
	}
	public void setImg_id(int img_id) {
		this.img_id = img_id;
	}
	public String getImg_src() {
		return img_src;
	}
	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public Image(int img_id, String img_src, String img_name) {
		super();
		this.img_id = img_id;
		this.img_src = img_src;
		this.img_name = img_name;
	}
	

}
