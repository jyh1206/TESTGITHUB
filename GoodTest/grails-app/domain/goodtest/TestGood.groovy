package goodtest

class TestGood {
	
	String book;
	int book_number;
	
	static hasMany = [book_name: GoodTest];
	
    static constraints = {
		book(blank: false, unique: true);
		book_number(blank : false); 
    }
	
	String toString(){
		return book;
	}
}
