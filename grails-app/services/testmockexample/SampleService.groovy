package testmockexample

import grails.orm.PagedResultList
import grails.transaction.Transactional

class SampleService {

    PagedResultList doSomething() {
    	println "doSomething"
    }
}
