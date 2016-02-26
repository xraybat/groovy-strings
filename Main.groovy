class Main {                                    
	static void main(String... args) {          
	    def myExpando = new MyStrExpando()
	    myExpando.doIt('Arthur', 'W', 'Dent')
	    println '/main:/'
	  	println 'myExpando.str = ' + myExpando.str

	  	def person = new Expando(firstName: 'Random', middleName: 'D', lastName: 'Dent')
	  	myExpando.str = person
	  	println 'myExpando.str = ' + myExpando.str

	} // main
} // Main