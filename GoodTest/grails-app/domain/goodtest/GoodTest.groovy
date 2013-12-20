package goodtest

class GoodTest {
	
	String name;
	
	static hasMany = [books: TestGood];
	static belongsTo = TestGood;
	
	static constraints = {
		name(blank: false, unique: true);
	}
	
	String toString() {
		return name;
	}
	
}
