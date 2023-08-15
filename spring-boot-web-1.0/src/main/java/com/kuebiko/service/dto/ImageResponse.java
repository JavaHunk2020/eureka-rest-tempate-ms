package com.kuebiko.service.dto;

//{"ctid" :1902,
 //  "image" : 10923982782
//   }
public class ImageResponse {

	private int ctid;
	private byte[] image;

	public int getCtid() {
		return ctid;
	}

	public void setCtid(int ctid) {
		this.ctid = ctid;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
