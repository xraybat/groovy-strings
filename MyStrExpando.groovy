class MyStrExpando {
	// variables                              
	private _aPerson = new Expando(firstName: 'an Arthur', middleName: 'W', lastName: 'Dent')	// need this for _extrs's to work
	//private _aStr = "/_aStr:/ it's ${_aPerson.firstName} ${_aPerson.middleName} ${_aPerson.lastName}"				// direct eval
	private _aStr = "/_aStr:/ it's ${ -> _aPerson.firstName} ${ -> _aPerson.middleName} ${ -> _aPerson.lastName}"	// lazy eval

	// properties
	private _person = new Expando(firstName: 'Initial', middleName: 'R', lastName: 'Dent')	// default
	void setStr(def person) {
		println '/setStr:/'
		this._person = person
	}

	def getStr() {
		if (_person) {
			"/getStr:/ it's ${_person.firstName} ${_person.middleName} ${_person.lastName}"						// direct eval
			//"/getStr:/ it's ${ -> _person.firstName} ${ -> _person.middleName} ${ -> _person.lastName}"		// lazy eval
		}
		else
			throw new NullPointerException()
	}

	// methods
	private _str(firstName, middleName, lastName) {
		def person = new Expando(firstName: firstName, middleName: middleName, lastName: lastName)
		"/_str():/ it's ${ -> person.firstName} ${ -> person.middleName} ${ -> person.lastName}"				// lazy eval
	}

	def doIt(firstName, middleName, lastName) {
		println '/doIt:/'
		def person = new Expando(firstName: 'loc Arthur', middleName: 'W', lastName: 'Dent')
		println 'direct = ' + "it's ${person.firstName} ${person.middleName} ${person.lastName}"
		println 'lazy = ' + "it's ${ -> person.firstName} ${ -> person.middleName} ${ -> person.lastName}"

		def directStr = "it's ${person.firstName} ${person.middleName} ${person.lastName}"						// direct eval
		println 'directStr = ' + directStr

		def lazyStr  = "it's ${ -> person.firstName} ${ -> person.middleName} ${ -> person.lastName}"			// lazy eval
		println 'lazyStr = ' + lazyStr

		println '_str(firstName, middleName, lastName) = ' + _str('meth ' + firstName, middleName, lastName)

		println '_aStr = ' + _aStr

		println 'str = ' + str

	} // doIt
} // MyStrExpando