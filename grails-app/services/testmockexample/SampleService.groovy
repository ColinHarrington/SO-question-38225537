package testmockexample

class SampleService {

    PagedResultList doSomething() {
        println "doSomething"
        return new PagedResultList()
    }
}
