package testmockexample

import grails.orm.PagedResultList
import grails.test.mixin.TestFor
import org.hibernate.Criteria
import spock.lang.Specification

@TestFor(FooController)
class FooControllerSpec extends Specification {

    void "sample Test with a real instance"() {
        given:
            controller.sampleService = Mock(SampleService)
            Criteria criteria = [list:{->[]}] as Criteria
            PagedResultList emptyPagedResultList = new PagedResultList(null, criteria)

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

