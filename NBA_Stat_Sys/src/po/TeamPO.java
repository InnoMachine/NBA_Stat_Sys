/**
 * puppy
 * 2015年3月8日 下午2:00:04
 * TODO
 */
package po;

public class TeamPO {
	
	private String teamName;
	private String abbreviation;
	private String city;
	private Conference conference;
	private Division division;
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
	public Conference getConference() {
		return conference;
	}
	public void setConference(Conference conf) {
		this.conference = conf;
	}
	public Division getDivision() {
		return division;
	}
	public void setDivision(Division div) {
		this.division = div;
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
