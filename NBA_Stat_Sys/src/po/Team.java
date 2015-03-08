/**
 * puppy
 * 2015年3月8日 下午2:00:04
 * TODO
 */
package po;

public class Team {
	
	private String teamName;
	private String abbreviation;
	private String city;
	private Conference conf;
	private Division div;
	private String homeField;
	private String birthYear;
	private String imgPath;
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Conference getConf() {
		return conf;
	}
	public void setConf(Conference conf) {
		this.conf = conf;
	}
	public Division getDiv() {
		return div;
	}
	public void setDiv(Division div) {
		this.div = div;
	}
	public String getHomeField() {
		return homeField;
	}
	public void setHomeField(String homeField) {
		this.homeField = homeField;
	}
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
}
