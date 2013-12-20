package goodtest

class NoHasMany {

	String testGe;
	
    static constraints = {
		testGe(blank: false);
    }
}
