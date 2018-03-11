package com.wx.model.explore;

/**
 *<p>Title: JKFqzVo</p>
 *<p>Description:
 *{
    "code": "10000",
    "charge": false,
    "msg": "查询成功",
    "result": {
        "userid": "13012345678",
        "inlabel": "反欺诈",
        "label": "反欺诈",
        "risk": "high",
        "hit": "网站1，网站2，网站3，网站4等",
        "hitcount": 20,
        "status": 0,
        "ver": "v100"
    }
}
 * </p>
 * @author zhugf
 * @date 2018年2月24日
 */
public class JKFqzVo {
	private String code;
	private boolean charge;
	private String msg;
	private Result result;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isCharge() {
		return charge;
	}

	public void setCharge(boolean charge) {
		this.charge = charge;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public class Result{
		private String userid;
		private String inlabel;
		private String label;
		private String risk;
		private String hit;
		private Integer hitcount;
		private Integer status;
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getInlabel() {
			return inlabel;
		}
		public void setInlabel(String inlabel) {
			this.inlabel = inlabel;
		}
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
		public String getRisk() {
			return risk;
		}
		public void setRisk(String risk) {
			this.risk = risk;
		}
		public String getHit() {
			return hit;
		}
		public void setHit(String hit) {
			this.hit = hit;
		}
		public Integer getHitcount() {
			return hitcount;
		}
		public void setHitcount(Integer hitcount) {
			this.hitcount = hitcount;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public String getVer() {
			return ver;
		}
		public void setVer(String ver) {
			this.ver = ver;
		}
		private String ver;
	}

}
