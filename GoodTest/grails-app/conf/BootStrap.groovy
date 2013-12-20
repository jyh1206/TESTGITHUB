import goodtest.*;

class BootStrap {

    def init = { servletContext ->
		def name1 = new GoodTest(name:"Jung").save(failOnError:true);
		def name2 = new GoodTest(name:"Kim").save(failOnError:true);
		def name3 = new GoodTest(name:"Lee").save(failOnError:true);
		
		/*def book1 =  new TestGood(book: "JAVA", count_book: 100);
		def book2 =  new TestGood(book: "Groovy", count_book: 190);
		def book3 =  new TestGood(book: "Grails", count_book: 350);
		
		book1.addTobook_name(name1);
		book1.addTobook_name(name2);
		book1.addTobook_name(name3);
		book1.save(failOnError:true);
		book2.addTobook_name(name1);
		book2.save(failOnError:true);
		book3.addTobook_name(name1);
		book3.addTobook_name(name3);
		book3.save(failOnError:true);*/
    }
    def destroy = {
    }
}
