package xml.vo;

public class PersonVo {
	
	
	
	String	name;
	String	nickName;
	
	int		age;
	String	tel;
	String	homeTel;
	
	public PersonVo() {
	}
	
	public PersonVo(String name, String nickName, int age, String tel, String homeTel) {
		super();
		this.name = name;
		this.nickName = nickName;
		this.age = age;
		this.tel = tel;
		this.homeTel = homeTel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHomeTel() {
		return homeTel;
	}
	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}
}