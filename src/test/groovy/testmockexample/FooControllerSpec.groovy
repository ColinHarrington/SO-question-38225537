package testmockexample

import grails.orm.PagedResultList
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(FooController)
class FooControllerSpec extends Specification {

    void "sample Test with map"() {
        given:
            controller.sampleService = Mock(SampleService)
            PagedResultList emptyPagedResultList = [empty: true] as PagedResultList

        when:
            controller.testFunction()

        then:
            1 * controller.sampleService.doSomething() >> emptyPagedResultList
            response.text == "it´s empty"
    }

    void "sample Test with Mock()"() {
        given:
            controller.sampleService = Mock(SampleService)
            PagedResultList emptyPagedResultList = Mock(PagedResultList)

        when:
            controller.testFunction()

        then:
            1 * controller.sampleService.doSomething() >> emptyPagedResultList
            1 * emptyPagedResultList.isEmpty() >> true
            response.text == "it´s empty"
    }
}

