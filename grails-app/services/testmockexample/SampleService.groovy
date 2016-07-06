package testmockexample

import grails.orm.PagedResultList

class SampleService {

    PagedResultList doSomething() {
        println "doSomething"
        return new PagedResultList()
    }
}
