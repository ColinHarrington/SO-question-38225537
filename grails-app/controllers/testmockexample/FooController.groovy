package testmockexample

class FooController {

	SampleService sampleService

	def testFunction() {
		def result = sampleService.doSomething()
		String variable = ""

		if (result.empty) {
			variable = "it´s empty"
		}
		render variable
	}
}
